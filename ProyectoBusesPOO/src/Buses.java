import java.util.ArrayList;
import java.util.HashMap;

public class Buses {
    private int NumeroBus;
    private String Destino;
    private int Pasajes = 0;
    private HashMap <String,Pasajero> mapaListaPasajeros;
    private int[] listaAsientos = {1,2,3,4,5,6,7,8,9,10};

    // ------------constructores-----------\\
    public Buses(){
    }
    public Buses(int num, String Destino){
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

    // ----------metodoses-----------\\
    public void sumarPasajero(Pasajero Nuevo){
        definirAsientoAleatorio(Nuevo);
        mapaListaPasajeros.put(Nuevo.getRut(),Nuevo); //AAAAA
        Pasajes ++;

    }
    public void sumarPasajero(Pasajero nuevo, int numAsiento){
        definirAsientoElegido(nuevo,numAsiento);
        mapaListaPasajeros.put(nuevo.getRut(),nuevo); //AAAAA
        Pasajes ++;
    }
    public void quitarPasajeros(){
        Pasajes = 0;
        mapaListaPasajeros.clear();
        for (int i = 0 ; i < 10 ;i++){
            listaAsientos[i] = i+1;
        }
    }
    public void quitarPasajero(String rut){
        mapaListaPasajeros.remove(rut);
    }
    public boolean revisarRentabilidad() {
        return Pasajes >= 20;
    }

    public void definirAsientoAleatorio(Pasajero nuevo)
    {
        int i = 0;
        while (listaAsientos[i] == 0){
            i++;
        }
        nuevo.setNumeroDeAsiento(listaAsientos[i]);
        listaAsientos[i] = 0;
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
    }
}
