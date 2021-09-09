import java.util.ArrayList;
import java.util.HashMap;

public class AgenciaBuses {

     private ArrayList <Buses> listaBuses;
     private ArrayList <Pasajero> listaPasajeros;
     HashMap<Integer, Buses> mapaListaBuses = new HashMap<>() ;

    // ------------constructores-----------\\
     public AgenciaBuses(){
         listaBuses = new ArrayList<Buses>();
         listaPasajeros = new ArrayList<Pasajero>();

         for (Pasajero listaPasajero : listaPasajeros) {
             for (Buses listaBus : listaBuses) {
                 if (listaPasajero.getNumeroBus() == listaBus.getNumeroBus()) {
                     listaBus.sumarPasajero(listaPasajero);
                 }
             }
         }
     }

    // ------------getters y setters-----------\\
    public ArrayList<Pasajero> getListaPasajeros() {
        ArrayList<Pasajero> copiaListaPasajeros = listaPasajeros;
        return copiaListaPasajeros;
    }
    public ArrayList<Buses> getListaBuses() {
        ArrayList<Buses> copiaListaBuses = listaBuses;
        return copiaListaBuses;
    }

    // ------------Metodos-----------\\
     public int cantidadBuses(){
         return listaBuses.size();
     }
     public void sumarPasajero(Pasajero nuevo){
         listaPasajeros.add(nuevo);
     }
     public void sumarBus(Buses nuevo){
         mapaListaBuses.put(nuevo.getNumeroBus(),nuevo);
         listaBuses.add(nuevo);
     }
     public void asignarBus(String rut,String destino){
         int i;
         for (i = 0 ; i < listaPasajeros.size() ; i++){
             if(rut.compareTo(listaPasajeros.get(i).getRut()) == 0){
                for (int j = 0 ; j < listaBuses.size() ; j++){
                    if(destino.compareTo(listaBuses.get(i).getDestino()) == 0){
                        mapaListaBuses.get(listaBuses.get(i).getNumeroBus()).sumarPasajero(listaPasajeros.get(i));
                        break;
                    }
                }
             }
         }
     }
}

