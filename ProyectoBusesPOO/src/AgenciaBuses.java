import java.util.ArrayList;

public class AgenciaBuses {

     private ArrayList <Buses> listaBuses;
     private ArrayList <Pasajero> listaPasajeros;

     public AgenciaBuses(){
         listaBuses = new ArrayList<Buses>();
         listaPasajeros = new ArrayList<Pasajero>();

         Pasajero nuevo = new Pasajero("Juan","123",1);
         listaPasajeros.add(nuevo);
         nuevo = new Pasajero("Juan", "1234", 1);
         listaPasajeros.add(nuevo);
         nuevo = new Pasajero("Felipe", "12345", 2);
         listaPasajeros.add(nuevo);
         nuevo = new Pasajero("Daniel", "123456", 2);
         listaPasajeros.add(nuevo);
         nuevo = new Pasajero("Pablo", "1234567", 1);
         listaPasajeros.add(nuevo);
         nuevo = new Pasajero("Esteban", "12345678", 2);
         listaPasajeros.add(nuevo);

         Buses busNuevo = new Buses(1, "Los Angeles");
         listaBuses.add(busNuevo);
         busNuevo = new Buses(2, "La Serena");
         listaBuses.add(busNuevo);

         for (Pasajero listaPasajero : listaPasajeros) {
             for (Buses listaBus : listaBuses) {
                 if (listaPasajero.getNumeroBus() == listaBus.getNumeroBus()) {
                     listaBus.sumarPasajero(listaPasajero);
                 }
             }
         }
     }
}

