import java.util.ArrayList;

public class Buses {
    private int NumeroBus;
    private String Destino;
    private int Pasajes = 0;
    private ArrayList <Pasajero> ListaPasajeros; //CAMBIE EL VECTOR PASAJEROS POR UNA LISTA
    private int[] listaAsientos = {1,2,3,4,5,6,7,8,9,10};


    public Buses(int num, String Destino){
        NumeroBus = num;
        this.Destino = Destino;
        ListaPasajeros = new ArrayList<>(); // AAAAAA SE INICIA LA LISTA
    }

    public String getDestino(){
        return Destino;
    }
    public int getPasajes(){
        return Pasajes;
    }
    public int getNumeroBus(){
        return NumeroBus;
    }

    public void sumarPasajero(Pasajero Nuevo){
        definirAsientoAleatorio(Nuevo,listaAsientos);
        ListaPasajeros.add(Nuevo); //AAAAA
        Pasajes ++;
    }
    public void sumarPasajero(Pasajero nuevo, int numAsiento){
        definirAsientoElegido(nuevo,listaAsientos,numAsiento);
    }

    public void quitarPasajeros(){
        Pasajes = 0;
        ListaPasajeros.clear(); // AAAAAAA Se remueve el pasajero;
    }

    public void setNumeroBus(int numeroBus) {
        NumeroBus = numeroBus;
    }
    public void setDestino(String destino) {
        Destino = destino;
    }
    public void setPasajes(int pasajes) {
        Pasajes = pasajes;
    }

    public boolean revisarRentabilidad() {
        return Pasajes >= 20;
    }
    public void definirAsientoAleatorio(Pasajero nuevo,int[] listaAsientos)
    {
        int i = 0;
        while (listaAsientos[i] != 0){
            i++;
        }
        nuevo.setNumeroDeAsiento(listaAsientos[i]);
        listaAsientos[i] = 0;
    }

    public void definirAsientoElegido(Pasajero nuevo,int[] listaAsientos,int numAsiento){
        for (int i = 0 ; i< listaAsientos.length; i++){
            if (numAsiento == listaAsientos[i])
            {
                nuevo.setNumeroDeAsiento(listaAsientos[i]);
                listaAsientos[i] = 0;
                break; //En caso de estar disponible el asiento buscado, este se asigna al pasajero
            }
        }
        definirAsientoAleatorio(nuevo, listaAsientos);
        // En caso de no encontrar disponibilidad para el asiento se asignara uno de manera aleatorioa
    }

}
