import jdk.swing.interop.SwingInterOpUtils;

import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class main {
    public static void main(String[] args)throws IOException {

        //declaramos la variable de opcion para que el usuario pueda escoger en el menu
        int opcion ;

        BufferedReader usuario = new BufferedReader(new InputStreamReader (System.in));
        AgenciaBuses Gerencia = new AgenciaBuses();
        Gerencia.llenarBuses();
        Gerencia.llenarPasajeros();


        do {//mostramos las diferentes opciones a escoger
            System.out.println("Opcion 1 : Agregar Pasajero");
            System.out.println("Opcion 2 : Agregar Bus");
            System.out.println("Opcion 3 : Mostrar Buses");
            System.out.println("Opcion 4 : Mostrar Pasajeros");
            System.out.println("Opcion 5 : Asignar bus a pasajero");
            System.out.println("Opcion 6 : Eliminar Bus");
            System.out.println("Opcion 7 : Eliminar Pasajero");
            System.out.println("Opcion 8 : Buscar numero de bus Pasajero");
            System.out.println("opcion 9 : Buscar al pasajero más joven");
            System.out.println("opcion 10 : Mostrar lista de pasajeros con asientos impares");
            System.out.println("opcion 11 : Mostras lista de pasajeros con asientos pares");
            System.out.println("opcion 12 : Cambiar Conductor de bus");
            System.out.println("Opcion 0 : Finalizar");
            opcion = Integer.parseInt(usuario.readLine());
            switch (opcion) {
                case 1 -> { //inicializamos una variable pasajero y luego llenamos sus datos
                    Pasajero nuevo = new PasajeroComun();
                    System.out.println("Ingrese si pasajero es \"estudiante\" o \"Adulto mayor\" o \"pasajero comun\"");
                    String opcionPasajero = usuario.readLine();
                    if (opcionPasajero.compareTo("estudiante") == 0) {
                        nuevo = new Estudiante();
                    } else if (opcionPasajero.compareTo("Adulto Mayor") == 0) {
                        nuevo = new AdultoMayor();
                    }
                    System.out.println("Ingrese el nombre del pasajero: ");
                    nuevo.setNombre(usuario.readLine());
                    System.out.println("Ingrese el rut del pasajero: ");
                    nuevo.setRut(usuario.readLine());
                    System.out.println("Ingrese el numero de bus:");
                    nuevo.setNumeroBus(usuario.readLine());
                    System.out.println("Ingrese el numero de asiento:");
                    nuevo.setNumeroDeAsiento(Integer.parseInt(usuario.readLine()));
                    System.out.println("Ingrese la fecha de nacimiento: ");
                    System.out.println("Año: ");
                    nuevo.setAnyoNacimiento(Integer.parseInt(usuario.readLine()));
                    System.out.println("Mes: ");
                    nuevo.setMesNacimiento(Integer.parseInt(usuario.readLine()));
                    System.out.println("Dia: ");
                    nuevo.setDiaNacimiento(Integer.parseInt(usuario.readLine()));
                    nuevo.setPorcentajeDescuento();
                    Gerencia.sumarPasajero(nuevo);
                }
                case 2 -> {//inicializamos una variable conductor y una de bus para agregarlos
                    Conductor conductor = new Conductor();
                    System.out.println("Ingrese el numero del Bus: ");
                    int numeroBus = Integer.parseInt(usuario.readLine());
                    System.out.println("Ingrese el destino del bus: ");
                    String destinoBus = usuario.readLine();
                    System.out.println("Ingrese nombre del conductor: ");
                    conductor.setNombre(usuario.readLine());
                    System.out.println("Ingrese rut del conductor: ");
                    conductor.setRut(usuario.readLine());
                    conductor.setNumeroDeBus(numeroBus);
                    Buses busNuevo = new Buses(numeroBus, destinoBus, conductor);
                    Gerencia.sumarBus(busNuevo, conductor);
                }
                case 3 ->//mostramos los buses que tenemos
                        System.out.println(Gerencia.mostrarBuses());
                case 4 ->//mostramos todos los pasajeros
                        System.out.println(Gerencia.mostrarPasajeros());
                case 5 -> {//asignamos a un pasajero un nuevo bus
                    System.out.println("Ingrese rut pasajero");
                    String destinoPasajero, rut;
                    rut = usuario.readLine();
                    System.out.println("Ingrese el destino");
                    destinoPasajero = usuario.readLine();
                    Gerencia.asignarBus(rut, destinoPasajero);
                }
                case 6 -> {//eliminamos un bus
                    System.out.println("Ingrese el numero del bus que desa eliminar");
                    Gerencia.eliminarBus(Integer.parseInt(usuario.readLine()));
                }
                case 7 -> {//eliminamos un pasajero
                    System.out.println("Ingrese el rut del pasajero que desea eliminar");
                    Gerencia.eliminarPasajero(usuario.readLine());
                }
                case 8 -> {//buscamos el numero de bus que tiene un pasajero utilizando su rut
                    System.out.println("Ingrese el rut del pasajero: ");
                    Gerencia.obtenerNumeroBusPasajero(usuario.readLine());
                }
                case 9 ->//buscamos el pasajero más joven
                        System.out.println(Gerencia.buscarPasajeroMenor().getNombre());
                case 10 -> {//mostramos la lista de pasajeros con asiento impar
                    ArrayList<Pasajero> listaAsientosImpar = new ArrayList<>(Gerencia.buscarPasajerosAsientoImpar());
                    for (Pasajero pasajero : listaAsientosImpar) System.out.println("" + pasajero.getNombre());
                }
                case 11 -> {
                    ArrayList<Pasajero> listaAsientosPar = new ArrayList<>(Gerencia.buscarPasajerosAsientoPar());
                    for (Pasajero pasajero : listaAsientosPar) System.out.println("" + pasajero.getNombre());
                }
                case 12 -> {//mostramos la lista de pasajeros con asiento par
                    int numeroBusNuevoConductor;
                    System.out.println("Ingrese el número de bus al que se le agregara un conductor");
                    numeroBusNuevoConductor = Integer.parseInt(usuario.readLine());
                    System.out.println("Ingrese rut del conductor al que le quiere agregar un bus: ");
                    Gerencia.cambiarConductor(usuario.readLine(), numeroBusNuevoConductor);
                }
                case 0 ->//terminamos de trabajar y se cierra el codigo
                        System.out.println("Bye <3");
                default -> System.out.println("Opcion ingresada no es valida");//pa los que no saben poner un numero
            }
        }while( opcion != 0 );

        try{
            File archivo = new File("reporte.txt");
            File pasajerosAgencia = new File("PasajerosAgencia.txt");
            File busesAgencia = new File("BusesAgencia.txt");
            if (!archivo.exists()){
                if (archivo.createNewFile()){
                    FileWriter fw = new FileWriter(archivo);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(Gerencia.mostrarPasajeros());
                    bw.write(Gerencia.mostrarBuses());
                    bw.close();
                    System.out.println("El archivo ha sido creado correctamente");
                }
                else System.out.println("El arhivo no se pudo crear");
            }
            else {
                FileWriter fw = new FileWriter(archivo);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(Gerencia.mostrarPasajeros());
                bw.write(Gerencia.mostrarBuses());
                bw.close();
                System.out.println("El archivo se ha sobreescrito");
            }
            FileWriter pasjaros = new FileWriter(pasajerosAgencia);
            BufferedWriter bufferedWriter = new BufferedWriter(pasjaros);
            bufferedWriter.write(Gerencia.imprimirPasajerosEnArchivo());
            bufferedWriter.close();
            FileWriter buses = new FileWriter(busesAgencia);
            bufferedWriter = new BufferedWriter(buses);
            bufferedWriter.write(Gerencia.imprimirBusesArchivo());
            bufferedWriter.close();

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    
}

