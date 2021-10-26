public class Persona implements DatosAgencia {
    //Atributos de la clase persona//
    private String nombre;
    private String rut;
    int diaNacimiento;
    int mesNacimiento;
    int anyoNacimiento;

    //Constructores//
    public Persona(){};

    public Persona(String nombre, String rut,int anyoNacimiento, int mesNacimiento, int diaNacimiento ){
        this.nombre = nombre;
        this.rut = rut;
        this.diaNacimiento = diaNacimiento;
        this.mesNacimiento = mesNacimiento;
        this.anyoNacimiento = anyoNacimiento;
    }

    public Persona(String nombre, String rut){
        this.nombre = nombre;
        this.rut = rut;
    }
    //Setters clase persona
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setRut(String rut) {
        this.rut = rut;
    }
    public void setDiaNacimiento(int diaNacimiento) {
        this.diaNacimiento = diaNacimiento;
    }
    public void setMesNacimiento(int mesNacimiento) {
        this.mesNacimiento = mesNacimiento;
    }
    public void setAnyoNacimiento(int anyoNacimiento) {
        this.anyoNacimiento = anyoNacimiento;
    }


    //Getters clase persona
    public int getAnyoNacimiento() {
        return anyoNacimiento;
    }
    public int getDiaNacimiento() {
        return diaNacimiento;
    }
    public int getMesNacimiento() {
        return mesNacimiento;
    }
    public String getNombre(){
        return nombre;
    }
    public String getRut(){
        return rut;
    }

    //metodos//
    public String mostrarDatos(){
        return ("Nombre: " + getNombre() +"\n" + "Rut:" + getRut() + "\n" +  "Fecha de Nacimiento"+
                getDiaNacimiento() + "/" + getMesNacimiento() + "/" + getAnyoNacimiento());
    }
}
