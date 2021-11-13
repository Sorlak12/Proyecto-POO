import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;
import java.util.Scanner;
import java.io.File;


public class AgenciaBuses {
    //Atributos//
    private ArrayList<Buses> listaBuses;
    private HashMap<String, Pasajero> mapaListaPasajeros;
    private HashMap<Integer, Buses> mapaListaBuses;
    private HashMap<String, Conductor> listaConductores;

    // ------------constructores-----------\\
    public AgenciaBuses() {
        listaBuses = new ArrayList<>();
        listaConductores = new HashMap<>();
        mapaListaPasajeros = new HashMap<>();
        mapaListaBuses = new HashMap<>();
    }
    // ------------Metodos---------

    public String mostrarBuses() {
        String texto = "\tLISTA DE BUSES\n";
        for (Buses bus : listaBuses) {
            texto += bus.mostrarDatos();
        }

        return texto;
    }

    public String mostrarPasajeros() {
        String texto = "\tLISTA PASAJEROS\n";
        for (String rut : mapaListaPasajeros.keySet()) {
            texto += mapaListaPasajeros.get(rut).mostrarDatos();
        }
        return texto;
    } // muestra la lista de pasajeros

    public int cantidadBuses() {
        return listaBuses.size();
    } // muestra la cantidad de buses

    public void sumarPasajero(Pasajero nuevo) {
        mapaListaPasajeros.put(nuevo.getRut(), nuevo);
        asignarBus(nuevo);
    }//agrega un pasajero al hashmap y se manda agregar a la funcion asignar bus

    public void sumarBus(Buses nuevo, Conductor conductor) {
        mapaListaBuses.put(nuevo.getNumeroBus(), nuevo);
        listaBuses.add(nuevo);
        listaConductores.put(conductor.getRut(), conductor);
    }//agrega un bus al hashmap, al arraylist de buses y agrega el conductor al arraylist de conductores

    public void asignarBus(Pasajero nuevo) {
        if (mapaListaBuses.get(nuevo.getNumeroBus()) != null) {
            mapaListaBuses.get(nuevo.getNumeroBus()).sumarPasajero(nuevo, nuevo.getNumeroDeAsiento());//creo que seria solo 1
        } else {
            System.out.println("El bus no existe");
        }
    } // se le asigna un bus al pasajero nuevo

    public void asignarBus(String rut, String destino) {
        for (Buses bus : listaBuses) {
            if (bus.getDestino().compareTo(destino) == 0) {
                mapaListaBuses.get(bus.getNumeroBus()).sumarPasajero(mapaListaPasajeros.get(rut));
                return;
            }
        }
    }//se le asigna un bus con un mismo destino al pasajero del bus no rentable eliminado

    public void eliminarBus(int numeroBus) {
        mapaListaBuses.get(numeroBus).getConductor().setNumeroDeBus(0);
        mapaListaBuses.remove(numeroBus);
        for (int i = 0; i < listaBuses.size(); i++) {
            if (listaBuses.get(i).getNumeroBus() == numeroBus) {
                listaBuses.remove(i);
                System.out.println("El bus ha sido eliminado correctamente");
                return;
            }
        }
        System.out.println("No se encontro el bus seleccionado");
    }

    public void eliminarPasajero(String rutPasajero) {
        if (mapaListaPasajeros.get(rutPasajero) != null) {
            if (mapaListaPasajeros.get(rutPasajero).getNumeroBus() != 0 && mapaListaBuses.get(mapaListaPasajeros.get(rutPasajero).getNumeroBus()) != null) {
                mapaListaBuses.get(mapaListaPasajeros.get(rutPasajero).getNumeroBus()).quitarPasajero(rutPasajero);
            }
            mapaListaPasajeros.remove(rutPasajero);
            System.out.println("El pasajero se elimino correctamente");
            return;
        }
        System.out.println("El pasajero selccionado no se encontro");
    }

    public void obtenerNumeroBusPasajero(String rut) {
        if (mapaListaPasajeros.get(rut) != null) {
            int numeroBus = mapaListaPasajeros.get(rut).getNumeroBus();
            if (numeroBus != 0) {
                System.out.println("El pasajero se encuentra en el bus N°" + numeroBus);
            } else {
                System.out.println("El pasajero aun no ha sido asignado a un bus");
            }
        } else System.out.println("El pasajero ingreasdo no existe, intente nuevamente");
    }

    public Pasajero buscarPasajeroMenor() {
        Pasajero pasajeroMenor = null;
        for (String rut : mapaListaPasajeros.keySet()) {
            if (pasajeroMenor == null || compararEdad(mapaListaPasajeros.get(rut), pasajeroMenor) == 1) {
                pasajeroMenor = mapaListaPasajeros.get(rut);
            }
        }
        return pasajeroMenor;
    }

    public int compararEdad(Pasajero pasajero, Pasajero pasajeroMenor) { //metodo rertona 1 si pasajero nuevo es menor
        if (pasajero.getAnyoNacimiento() > pasajeroMenor.getAnyoNacimiento()) return 1;
        else if (pasajero.getAnyoNacimiento() == pasajeroMenor.getAnyoNacimiento())
            if (pasajero.getMesNacimiento() > pasajeroMenor.getMesNacimiento()) return 1;
            else if (pasajero.getMesNacimiento() == pasajeroMenor.getMesNacimiento())
                if (pasajero.getDiaNacimiento() > pasajero.getDiaNacimiento()) return 1;
        return 0;
    }

    public ArrayList<Pasajero> buscarPasajerosAsientoImpar() {
        ArrayList<Pasajero> PasajerosAsientoImpar = new ArrayList<>();
        for (String rut : mapaListaPasajeros.keySet()) {
            if ((mapaListaPasajeros.get(rut).getNumeroDeAsiento() % 2) != 0) {
                PasajerosAsientoImpar.add(mapaListaPasajeros.get(rut));
            }
        }
        return PasajerosAsientoImpar;
    }

    public ArrayList<Pasajero> buscarPasajerosAsientoPar() {
        ArrayList<Pasajero> PasajerosAsientoPar = new ArrayList<>();
        for (String rut : mapaListaPasajeros.keySet()) {
            if ((mapaListaPasajeros.get(rut).getNumeroDeAsiento() % 2) == 0) {
                PasajerosAsientoPar.add(mapaListaPasajeros.get(rut));
            }
        }
        return PasajerosAsientoPar;
    }

    public void cambiarConductor(String rutConductorNuevo, int numeroBus) {
        if (mapaListaBuses.get(numeroBus).getConductor() != null)
            mapaListaBuses.get(numeroBus).getConductor().setNumeroDeBus(0);
        mapaListaBuses.get(numeroBus).setConductor(listaConductores.get(rutConductorNuevo));
        listaConductores.get(rutConductorNuevo).setNumeroDeBus(numeroBus);
    }

    public void llenarBuses() throws FileNotFoundException {
        Scanner archivo = new Scanner(new File("BusesAgencia.txt"));
        while (archivo.hasNext()) {
            String str = archivo.nextLine();
            String[] DatosBuses;
            DatosBuses = str.split(",");
            int numeroBus = Integer.parseInt(DatosBuses[0]);
            String DestinoBus = DatosBuses[1];
            String nombreConductor = DatosBuses[2];
            String rutConductor = DatosBuses[3];
            Conductor conductor = new Conductor(nombreConductor, rutConductor, numeroBus);
            Buses bus = new Buses(numeroBus, DestinoBus, conductor);
            sumarBus(bus, conductor);
        }
    }

    public void llenarPasajeros() throws FileNotFoundException {
        Scanner archivo = new Scanner(new File("PasajerosAgencia.txt"));
        while (archivo.hasNext()) {
            String str = archivo.nextLine();
            String[] DatosPasajeros = str.split(",");
            String tipoPasajero = DatosPasajeros[0];
            String nombrePasajero = DatosPasajeros[1];
            String rutPasajero = DatosPasajeros[2];

            int numeroBus = Integer.parseInt(DatosPasajeros[3]);
            int numeroAsiento = Integer.parseInt(DatosPasajeros[4]);
            int anyoNacimiento = Integer.parseInt(DatosPasajeros[5]);
            int mesNacimiento = Integer.parseInt(DatosPasajeros[6]);
            int diaNacimiento = Integer.parseInt(DatosPasajeros[7]);
            Pasajero nuevo;
            switch (tipoPasajero) {
                case "estudiante" -> {
                    nuevo = new Estudiante(nombrePasajero, rutPasajero, anyoNacimiento, mesNacimiento,
                            diaNacimiento, numeroBus, numeroAsiento);
                    sumarPasajero(nuevo);
                }
                case "Adulto mayor" -> {
                    nuevo = new AdultoMayor(nombrePasajero, rutPasajero, anyoNacimiento, mesNacimiento,
                            diaNacimiento, numeroBus, numeroAsiento);
                    sumarPasajero(nuevo);
                }
                default -> {
                    nuevo = new PasajeroComun(nombrePasajero, rutPasajero, anyoNacimiento, mesNacimiento,
                            diaNacimiento, numeroBus, numeroAsiento);
                    sumarPasajero(nuevo);
                }
            }
        }
    }

    public String imprimirPasajerosEnArchivo() {
        String texto = "";
        for (String rut : mapaListaPasajeros.keySet()) {
            if (mapaListaPasajeros.get(rut).getPorcentajeDescuento() == 15) {
                texto += "estudiante," + mapaListaPasajeros.get(rut).getNombre() + "," + mapaListaPasajeros.get(rut).getRut()
                        + "," + mapaListaPasajeros.get(rut).getNumeroBus() + "," + mapaListaPasajeros.get(rut).getNumeroDeAsiento() + ","
                        + mapaListaPasajeros.get(rut).getAnyoNacimiento() + "," + mapaListaPasajeros.get(rut).getMesNacimiento()
                        + "," + mapaListaPasajeros.get(rut).getDiaNacimiento() + "\n";
            } else if (mapaListaPasajeros.get(rut).getPorcentajeDescuento() == 20) {
                texto += "Adulto mayor," + mapaListaPasajeros.get(rut).getNombre() + "," + mapaListaPasajeros.get(rut).getRut()
                        + "," + mapaListaPasajeros.get(rut).getNumeroBus() + "," + mapaListaPasajeros.get(rut).getNumeroDeAsiento() + ","
                        + mapaListaPasajeros.get(rut).getAnyoNacimiento() + "," + mapaListaPasajeros.get(rut).getMesNacimiento()
                        + "," + mapaListaPasajeros.get(rut).getDiaNacimiento() + "\n";
            } else
                texto += "Pasajero comun," + mapaListaPasajeros.get(rut).getNombre() + "," + mapaListaPasajeros.get(rut).getRut()
                        + "," + mapaListaPasajeros.get(rut).getNumeroBus() + "," + mapaListaPasajeros.get(rut).getNumeroDeAsiento() + ","
                        + mapaListaPasajeros.get(rut).getAnyoNacimiento() + "," + mapaListaPasajeros.get(rut).getMesNacimiento()
                        + "," + mapaListaPasajeros.get(rut).getDiaNacimiento() + "\n";
        }
        return texto;
    }

    public String imprimirBusesArchivo() {
        String texto = "";
        for (int Bus : mapaListaBuses.keySet()) {
            texto += mapaListaBuses.get(Bus).getNumeroBus() + "," + mapaListaBuses.get(Bus).getDestino() + "," +
                    mapaListaBuses.get(Bus).getConductor().getNombre() + "," + mapaListaBuses.get(Bus).getConductor().getRut() + "\n";
        }
        return texto;
    }
}