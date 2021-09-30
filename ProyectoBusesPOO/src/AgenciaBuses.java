import java.util.ArrayList;
import java.util.HashMap;

public class AgenciaBuses {

    private ArrayList <Buses> listaBuses;
    private HashMap<String,Pasajero> mapaListaPasajeros;
    private HashMap<Integer, Buses> mapaListaBuses;

    // ------------constructores-----------\\
    public AgenciaBuses(){
        listaBuses = new ArrayList<>();
        mapaListaPasajeros = new HashMap<>();
        mapaListaBuses = new HashMap<>();
    }
    // ------------Metodos-----------\\
    //agregar / eliminar / obtener

    public String mostrarBuses(){
        String texto = "\tLISTA DE BUSES\n";
        for (Buses bus: listaBuses) {
            texto += "Número de Bus: " + bus.getNumeroBus() + "\tDestino: " + bus.getDestino() + "\n" + bus.mostrarPasajerosBus()+ "\n";
        }

        return texto;
    }
    public String mostrarPasajeros(){
        String texto = "\tLISTA PASAJEROS\n";
        for(String rut : mapaListaPasajeros.keySet()){
            texto += "Nombre Pasajero: " + mapaListaPasajeros.get(rut).getNombre() + "\tNumero de bus: " + mapaListaPasajeros.get(rut).getNumeroBus()  + "\n";
        }
        return texto;
    }

    public int cantidadBuses(){
         return listaBuses.size();
     }
    public void sumarPasajero(Pasajero nuevo){
        mapaListaPasajeros.put(nuevo.getRut(),nuevo);
        asignarBus(nuevo);
    }
    public void sumarBus(Buses nuevo){
        mapaListaBuses.put(nuevo.getNumeroBus(),nuevo);
        listaBuses.add(nuevo);
    }

    public void asignarBus(Pasajero nuevo){
        if(mapaListaBuses.get(nuevo.getNumeroBus()) != null){
             mapaListaBuses.get(nuevo.getNumeroBus()).sumarPasajero(nuevo, nuevo.getNumeroDeAsiento());//creo que seria solo 1
        }else {
            System.out.println("El bus no existe");
        }
    }

    public void asignarBus(String rut,String destino){
        for (Buses bus: listaBuses){
            if(bus.getDestino().compareTo(destino)== 0){
                mapaListaBuses.get(bus.getNumeroBus()).sumarPasajero(mapaListaPasajeros.get(rut));
                return;
            }
        }
    }
    public void eliminarBus(int numeroBus){
        mapaListaBuses.remove(numeroBus);
        for (int i = 0 ; i < listaBuses.size(); i++){
            if (listaBuses.get(i).getNumeroBus() == numeroBus) {
                listaBuses.remove(i);
                System.out.println("El bus ha sido eliminado correctamente");
                return;
            }
        }
        System.out.println("No se encontro el bus seleccionado");
    }
    public void eliminarPasajero(String rutPasajero){
        if (mapaListaPasajeros.get(rutPasajero) != null) {
            if(mapaListaPasajeros.get(rutPasajero).getNumeroBus() != 0) {
                mapaListaBuses.get(mapaListaPasajeros.get(rutPasajero).getNumeroBus()).quitarPasajero(rutPasajero);
            }
            mapaListaPasajeros.remove(rutPasajero);
            System.out.println("El pasajero se elimino correctamente");
            return;
        }
        System.out.println("El pasajero selccionado no se encontro");
    }
    public void obtenerNumeroBusPasajero(String rut){
        if (mapaListaPasajeros.get(rut) != null)
        {
            int numeroBus = mapaListaPasajeros.get(rut).getNumeroBus();
            if (numeroBus != 0) {
                System.out.println("El pasajero se encuentra en el bus N°" + numeroBus);
            } else {
                System.out.println("El pasajero aun no ha sido asignado a un bus");
            }
        }
        else System.out.println("El pasajero ingreasdo no existe, intente nuevamente");
    }
}

