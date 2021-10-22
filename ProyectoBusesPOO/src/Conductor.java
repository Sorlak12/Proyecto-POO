public class Conductor extends Persona {
    //Atributos Conductor//
    int numeroDeBus;
    //constructor conductor//
    public Conductor(String nombre, String rut,int numeroDeBus){
        super(nombre,rut);
        this.numeroDeBus = numeroDeBus;
    }
    public Conductor(){};

    // Setter y Getters //
    public void setNumeroDeBus(int numeroDeBus){
        this.numeroDeBus = numeroDeBus;
    }
    public int getNumeroDeBus() {
        return numeroDeBus;
    }

    //metodos//
    @Override
    public String mostrarDatos() {
        return getNombre() + getRut();
    }
}
