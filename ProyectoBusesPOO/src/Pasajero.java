public class Pasajero {
    private String Nombre, Rut;
    private int NumeroBus = 0;
    private int NumeroDeAsiento;


    // ----------constructores----------\\
    public Pasajero(String Nombre, String Rut, int NumeroBus){
        this.Nombre = Nombre;
        this.Rut = Rut;
        this.NumeroBus = NumeroBus;
    }
    public Pasajero(String Nombre, String Rut, int NumeroBus, int NumeroDeAsiento){
        this.Nombre = Nombre;
        this.Rut = Rut;
        this.NumeroBus = NumeroBus;
        this.NumeroDeAsiento = NumeroDeAsiento;
    }
    public Pasajero(){
    }

    // ----------setters y getters-----------\\
    public String getRut(){
        return Rut;
    }
    public int getNumeroBus(){
        return NumeroBus;
    }
    public String getNombre(){
        return Nombre;
    }
    public int getNumeroDeAsiento(){
        return NumeroDeAsiento;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public void setNumeroBus(int numeroBus) {
        NumeroBus = numeroBus;
    }
    public void setNumeroBus(String numeroBus) {
        try{
            NumeroBus = Integer.parseInt(numeroBus);
        }catch (NumberFormatException e) {
            System.out.println("Numero bus no es un numero");
        }
    }
    public void setRut(String rut) {
        Rut = rut;
    }
    public void setNumeroDeAsiento(int NumeroDeAsiento) {
        this.NumeroDeAsiento = NumeroDeAsiento;
    }

    // ----------metodos-----------\\
    public void cambiarNumeroBus(int NumeroBus){

        this.NumeroBus = NumeroBus;
    }


}
