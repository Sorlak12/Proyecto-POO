public class AgenciaBuses {
    public static void main(String[] arg){
        Buses[] listaBuses;
        Pasajero[] listaPasajeros;
        int numeroBus;
        String destinoAuxiliar;

        listaBuses = new Buses[2];
        listaPasajeros = new Pasajero[5];

        listaPasajeros[0] = new Pasajero("Juan","Los Angeles",1);
        listaPasajeros[1] = new Pasajero("Felipe","La Serena",2);
        listaPasajeros[2] = new Pasajero("Daniel","La Serena",2);
        listaPasajeros[3] = new Pasajero("Pablo","Los Angeles",1);
        listaPasajeros[4] = new Pasajero("Esteban","La Serena",2);

        listaBuses[0] = new Buses(1,"Los Angeles");
        listaBuses[1] = new Buses(2,"La Serena");

        //El siguiente bloque de codigo asigna un asiento en cada bus a cada pasajero
        for (int i = 0 ; i < 4 ; i++){
            int j = 0;
            while(listaPasajeros[i].getNumeroBus() != listaBuses[j].getNumeroBus()){
                j++;
            }
            listaBuses[j].sumarPasajero(listaPasajeros[i]);
        }

        //El siguiente bloque de codigo revisa la rentabilidad de cada uno de los viajes para
        //revisar si estos se realizan o sus pasajeros son reasignados
        for (int i = 0 ; i < 2 ; i++){
            if (!listaBuses[i].revisarRentabilidad())
            {
                Pasajero[] ListaPasajerosAuxiliar = new Pasajero[listaBuses[i].getPasajes() -1];
                destinoAuxiliar = listaBuses[i].getDestino();
                listaBuses[i].quitarPasajeros();
            }
            //Bloque por completar
        }
    }
}
