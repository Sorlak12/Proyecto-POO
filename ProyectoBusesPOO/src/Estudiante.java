public class Estudiante extends Pasajero {
    //Constructor  estudiante//
    public Estudiante(String nombre, String Rut, int anyoNacimiento, int mesNacimiento, int diaNacimiento, int NumeroBus, int NumeroDeAsiento){
        super(nombre,Rut,diaNacimiento,mesNacimiento,anyoNacimiento,NumeroBus,NumeroDeAsiento);
    }
    public Estudiante(){}
    //metodo//
    public int obtenerPorcentajeDescuento(){
        return 15;
    }
}