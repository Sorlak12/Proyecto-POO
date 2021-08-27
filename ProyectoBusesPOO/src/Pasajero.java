public class Pasajero {
    private String Nombre, Rut;
    private int NumeroBus;
    public Pasajero(String Nombre, String Rut, int NumeroBus){
        this.Nombre = Nombre;
        this.Rut = Rut;
        this.NumeroBus = NumeroBus;
    }
    public String getRut(){
        return Rut;
    }
    public int getNumeroBus(){
        return NumeroBus;
    }
    public void reasignarBus(int NumeroBus){
        this.NumeroBus = NumeroBus;
    }
}