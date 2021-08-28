public class Buses {
    private int NumeroBus;
    private String Destino;
    private int Pasajes = 0;
    private Pasajero[] ListaPasajeros;

    public Buses(int num, String Destino){
        NumeroBus = num;
        this.Destino = Destino;
        ListaPasajeros = new Pasajero[40]; //Se define 40 como la capacidad maxima del bus
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
        ListaPasajeros[Pasajes] = Nuevo;
        Pasajes ++;
    }

    public void quitarPasajeros(){
        Pasajes = 0;
        ListaPasajeros = null;
    }
    public boolean revisarRentabilidad() {
        return Pasajes >= 20;
    }

}



