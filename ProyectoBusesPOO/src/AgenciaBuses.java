import java.util.ArrayList;
import java.util.HashMap;

public class AgenciaBuses {

    private ArrayList <Buses> listaBuses;
    private HashMap<String,Pasajero> mapaListaPasajeros;
    private HashMap<Integer, Buses> mapaListaBuses;

    // ------------constructores-----------\\
    public AgenciaBuses(){
        listaBuses = new ArrayList<Buses>();
        mapaListaPasajeros = new HashMap<>();
        mapaListaBuses = new HashMap<>();
    }
    // ------------Metodos-----------\\
    //agregar / eliminar / obtener

    public String mostrarBuses(){
        String texto = "\tLISTA DE BUSES\n";
        for (Buses bus: listaBuses) {
            texto += "Número de Bus: " + bus.getNumeroBus() + "\tDestino: " + bus.getDestino() + "\n";
        }
        return texto;
    }
    public String mostrarPasajeros(){
        String texto = "\tLISTA PASAJEROS\n";
        for(String rut : mapaListaPasajeros.keySet()){
            texto += "Nombre Pasajero:" + mapaListaPasajeros.get(rut).getNombre() + "\tNumero de bus: " + mapaListaPasajeros.get(rut).getNumeroBus()  + "\n";
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
             mapaListaBuses.get(nuevo.getNumeroBus()).definirAsientoElegido(nuevo, nuevo.getNumeroDeAsiento());//creo que seria solo 1
        }else {
            System.out.println("El bus no existe");
        }
    }

    public void asignarBus(String rut,String destino){
        for (Buses bus: listaBuses){
            if(bus.getDestino().compareTo(destino)== 0){
                bus.sumarPasajero(mapaListaPasajeros.get(rut));
                return;
            }
        }
    }
    public void eliminarBus(int numeroBus){
        mapaListaBuses.remove(numeroBus);
        for (int i = 0 ; i < listaBuses.size(); i++){
            if (listaBuses.get(i).getNumeroBus() == numeroBus) {
                listaBuses.remove(i);
                return;
            }
        }
    }
    public void eliminarPasajero(String rutPasajero){
        mapaListaPasajeros.remove(rutPasajero);
        mapaListaBuses.get(mapaListaPasajeros.get(rutPasajero).getNumeroBus()).quitarPasajero(rutPasajero);
    }
}

