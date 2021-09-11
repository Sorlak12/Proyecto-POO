import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class main {
    public static void main(String[] args)throws IOException {

        int opcion ;

        BufferedReader usuario = new BufferedReader(new InputStreamReader (System.in));
        AgenciaBuses Gerencia = new AgenciaBuses();


        do {
            System.out.println("Opcion 1 : Agregar Pasajero");
            System.out.println("Opcion 2 : Agregar Bus");
            System.out.println("Opcion 3 : Mostrar Buses");
            System.out.println("Opcion 4 : Mostrar Pasajeros");
            System.out.println("Opcion 5 : Asignar bus a pasajero");
            System.out.println("Opcion 6 : Eliminar Bus");
            System.out.println("Opcion 7 : Eliminar Pasajero");
            System.out.println("Opcion 0 : Finalizar");
            opcion = Integer.parseInt(usuario.readLine());
            switch(opcion)
            {
                case 1 :
                    Pasajero nuevo = new Pasajero();
                    System.out.println("Ingrese el nombre del pasajero: ");
                    nuevo.setNombre(usuario.readLine());
                    System.out.println("Ingrese el rut del pasajero: ");
                    nuevo.setRut(usuario.readLine());
                    System.out.println("Ingrese el numero de bus:");
                    nuevo.setNumeroBus(usuario.readLine());
                    System.out.println("Ingrese el numero de asiento:");
                    nuevo.setNumeroDeAsiento(Integer.parseInt(usuario.readLine()));
                    Gerencia.sumarPasajero(nuevo);
                    break;
                case 2 :
                    System.out.println("Ingrese el numero del Bus: ");
                    int numeroBus = Integer.parseInt(usuario.readLine());
                    System.out.println("Ingrese el destino del bus: ");
                    String destinoBus = usuario.readLine();
                    Buses busNuevo = new Buses(numeroBus,destinoBus);
                    Gerencia.sumarBus(busNuevo);
                    break;
                case 3 :
                    System.out.println(Gerencia.mostrarBuses());
                    break;
                case 4 :
                    System.out.println(Gerencia.mostrarPasajeros());
                    break;
                case 5 :
                    System.out.println("Ingrese rut pasajero");
                    String destinoPasajero, rut;
                    rut = usuario.readLine();
                    System.out.println("Ingrese el destino");
                    destinoPasajero = usuario.readLine();
                    Gerencia.asignarBus(rut,destinoPasajero);
                    break;
                case 6 :
                    System.out.println("Ingrese el numero del bus que desa eliminar");
                    Gerencia.eliminarBus(Integer.parseInt(usuario.readLine()));
                    break;
                case 7 :
                    System.out.println("Ingrese el rut del pasajero que desea eliminar");
                    Gerencia.eliminarPasajero(usuario.readLine());
                    break;
                case 0:
                    System.out.println("Bye <3");
                    break;
                default:
                    System.out.println("Opcion ingresada no es valida");
                    break;
            }
        }while( opcion != 0 );

    }

 /* el siguiente metodo esta incompleto, se dejo como intento de llenar el mapa, pero se decidio ir por otro metodo

         public static void llenarMapa(HashMap mapaListaPasajeros, AgenciaBuses Gerencia, ArrayList listaPasajeros){
        int largo = Gerencia.cantidadBuses();

        for(int i = 0; i < largo; i++){
            mapaListaPasajeros.put(i,listaPasajeros.get(i));
        }
    }
*/
}

