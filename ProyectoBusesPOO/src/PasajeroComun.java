public class PasajeroComun extends Pasajero{
    //constructores  pasajero comun//
    public PasajeroComun(String nombre, String Rut, int anyoNacimiento, int mesNacimiento, int diaNacimiento, int NumeroBus, int NumeroDeAsiento){
        super(nombre,Rut,diaNacimiento,mesNacimiento,anyoNacimiento,NumeroBus,NumeroDeAsiento);
    }
    public PasajeroComun(){}
    //metodos//
    public int obtenerPorcentajeDescuento(){
        return 0;
    }
}