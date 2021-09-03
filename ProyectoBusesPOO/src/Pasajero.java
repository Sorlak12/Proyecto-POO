public class Pasajero {
    private String Nombre, Rut;
    private int NumeroBus;
    private int NumeroDeAsiento;

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
    public String getNombre(){
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public void setNumeroBus(int numeroBus) {
        NumeroBus = numeroBus;
    }

    public void setRut(String rut) {
        Rut = rut;
    }
    public void cambiarNumeroBus(int NumeroBus){

        this.NumeroBus = NumeroBus;
    }

    public void setNumeroDeAsiento(int NumeroDeAsiento) {
        this.NumeroDeAsiento = NumeroDeAsiento;
    }
}
