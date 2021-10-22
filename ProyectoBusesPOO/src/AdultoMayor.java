public class AdultoMayor extends Pasajero{
    public AdultoMayor(String nombre, String Rut, int anyoNacimiento, int mesNacimiento, int diaNacimiento, int NumeroBus, int NumeroDeAsiento){
        super(nombre,Rut,diaNacimiento,mesNacimiento,anyoNacimiento,NumeroBus,NumeroDeAsiento);
    }

    public AdultoMayor(){}

    public int obtenerPorcentajeDescuento(){
        return 20;
    }
}
