import java.util.ArrayList;
import java.util.HashMap;

public class Buses implements DatosAgencia{
    //Atributos//
    private  Conductor conductor;
    private int NumeroBus;
    private String Destino;
    private int Pasajes = 0;
    private HashMap <String,Pasajero> mapaListaPasajeros;
    private int[] listaAsientos = {1,2,3,4,5,6,7,8,9,10};

    // ------------constructores-----------\\
    public Buses(){
    }
    public Buses(int num, String Destino,Conductor conductor){
        this.conductor = conductor;
        NumeroBus = num;
        this.Destino = Destino;
        mapaListaPasajeros = new HashMap<>();// AAAAAA SE INICIA LA LISTA
    }

    // ----------setters y getters-----------\\
    public void setPasajes(int pasajes) {
        Pasajes = pasajes;
    }
    public void setDestino(String destino) {
        Destino = destino;
    }
    public int getNumeroBus(){
        return NumeroBus;
    }
    public void setNumeroBus(int numeroBus) {
        NumeroBus = numeroBus;
    }
    public int getPasajes(){
        return Pasajes;
    }
    public String getDestino(){
        return Destino;
    }
    public void setConductor(Conductor conductor){
        this.conductor = conductor;
    }
    public Conductor getConductor(){return conductor;}

    // ----------metodos-----------\\
    public String mostrarPasajerosBus(){
        String texto = 	"\tLISTA PASAJEROS EN EL BUS\n";
        for(String rut : mapaListaPasajeros.keySet()){
            texto += "Nombre Pasajero: " + mapaListaPasajeros.get(rut).getNombre() + "\t" + "Rut: " + mapaListaPasajeros.get(rut).getRut()
                    + " Numero de Asiento: "+ + mapaListaPasajeros.get(rut).getNumeroDeAsiento() + "\n";
        }
        return texto;
    }

    public void sumarPasajero(Pasajero Nuevo){
        definirAsientoAleatorio(Nuevo);
        mapaListaPasajeros.put(Nuevo.getRut(),Nuevo); //AAAAA
        Pasajes ++;

    } //Agrega un pasajero a un bus
    public void sumarPasajero(Pasajero nuevo, int numAsiento){
        definirAsientoElegido(nuevo,numAsiento);
        mapaListaPasajeros.put(nuevo.getRut(),nuevo); //AAAAA
        Pasajes ++;
    } //Agrega un pasajero con un asiento escojido
    public void quitarPasajeros(){
        Pasajes = 0;
        mapaListaPasajeros.clear();
        for (int i = 0 ; i < 10 ;i++){
            listaAsientos[i] = i+1;
        }
    }//elimina todos los pasajeros de un bus
    public void quitarPasajero(String rut){
        listaAsientos[(mapaListaPasajeros.get(rut).getNumeroDeAsiento())-1] = (mapaListaPasajeros.get(rut).getNumeroDeAsiento());
        mapaListaPasajeros.remove(rut);
        Pasajes--;
    } //elimina un pasajero en especifico de un bus
    public boolean revisarRentabilidad() {
        return Pasajes >= 20;
    } //revisa que el viaje sea rentable

    public void definirAsientoAleatorio(Pasajero nuevo) //asigna un asiento aleatorio a pasajero que no especifica su numero de asiento
    {
        for (int i = 0 ; i < 10 ; i++){
            if (listaAsientos[i] != 0){
                nuevo.setNumeroDeAsiento(i+1);
                listaAsientos[i] = 0;
                return;
            }
        }
    }
    public void definirAsientoElegido(Pasajero nuevo,int numAsiento){
        try{
            if (numAsiento == listaAsientos[numAsiento-1]){
                nuevo.setNumeroDeAsiento(numAsiento);
                listaAsientos[numAsiento-1] = 0;
            }else {
                System.out.println("asiento ocupado, se seleccionara otro al azar");
                definirAsientoAleatorio(nuevo);
            }
        }catch (Exception e) {
            System.out.println("asiento no existe, se seleccionara otro al azar");
            definirAsientoAleatorio(nuevo);
        }
    }// asigna al pasajero el numero de asiento escojido

    @Override
    public String mostrarDatos() { // mumuetras los datos del bus
        return "N??mero de Bus: " + NumeroBus + "\n"+ "Destino: " + Destino + "\n"+ "Conductor: " + conductor.getNombre() + "\n"
                + "Rut: "+conductor.getRut() + "\n" + mostrarPasajerosBus()+ "\n";
    }
    public HashMap<String,Pasajero> getMapaListaPasajeros(){
        return mapaListaPasajeros;
    }
}