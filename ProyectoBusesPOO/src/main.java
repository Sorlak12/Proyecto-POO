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
            System.out.println("Opcion 0 :  Finalizar");
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
                    nuevo.setNumeroBus(Integer.parseInt(usuario.readLine()));
                    Gerencia.sumarPasajero(nuevo);
                case 2 :
                    Buses busNuevo = new Buses();
                    System.out.println("Ingrese el numero del Bus: ");
                    busNuevo.setNumeroBus(Integer.parseInt(usuario.readLine()));
                    System.out.println("Ingrese el destino del bus: ");
                    busNuevo.setDestino(usuario.readLine());
                    Gerencia.sumarBus(busNuevo);

                case 3 :
                    Gerencia.getListaBuses();

                case 4 :
                    Gerencia.getListaPasajeros();
                case 5 :
                    System.out.println("Ingrese rut pasajero");
                    String destino, rut;
                    rut = usuario.readLine();
                    System.out.println("Ingrese el destino");
                    destino = usuario.readLine();
                    Gerencia.asignarBus(rut,destino);


                case 0:
                    System.out.println("Bye <3");
                    break;
                default:
                    System.out.println("Opcion ingresada no es valida");
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

