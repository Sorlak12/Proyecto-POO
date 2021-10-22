public abstract class Pasajero extends Persona  {
    private int NumeroBus = 0;
    private int NumeroDeAsiento;
    private int PorcentajeDescuento;


    // ----------constructores----------\\
    public Pasajero(int NumeroBus){
        this.NumeroBus = NumeroBus;
    }
    public Pasajero( String nombre, String Rut, int anyoNacimiento, int mesNacimiento, int diaNacimiento, int NumeroBus, int NumeroDeAsiento){
        super(nombre,Rut,diaNacimiento,mesNacimiento,anyoNacimiento);
        this.NumeroBus = NumeroBus;
        this.NumeroDeAsiento = NumeroDeAsiento;
    }
    public Pasajero(){
    }

    public int getNumeroBus(){
        return NumeroBus;
    }
    public int getPorcentajeDescuento(){
        return PorcentajeDescuento;
    }

    public int getNumeroDeAsiento(){
        return NumeroDeAsiento;
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

    public void setNumeroDeAsiento(int NumeroDeAsiento) {
        this.NumeroDeAsiento = NumeroDeAsiento;
    }

    // ----------metodos-----------\\
    public void cambiarNumeroBus(int NumeroBus){

        this.NumeroBus = NumeroBus;
    }

    public void cambiarNumeroDeAsiento(int NumeroDeAsiento){
        this.NumeroDeAsiento = NumeroDeAsiento;
    }
    public String mostrarDatos(){
        return "Nombre: " + getNombre() +"\n" + "Rut:" + getRut() + "\n" +  "Fecha de Nacimiento"+
                getDiaNacimiento() + "/" + getMesNacimiento() + "/" + getAnyoNacimiento() +
                "\n" + "Numero de bus; " + getNumeroBus() + "Numero de Asiento" + getNumeroDeAsiento();
    }
    public void setPorcentajeDescuento(){
        PorcentajeDescuento = obtenerPorcentajeDescuento();
    }
    public abstract int obtenerPorcentajeDescuento();

}
