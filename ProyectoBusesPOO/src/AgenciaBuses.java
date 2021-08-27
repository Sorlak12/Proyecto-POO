public class AgenciaBuses {
    public static void main(String[] arg){
        Buses[] listaBuses;
        Pasajero[] listaPasajeros;
        int numeroBus;
        String destinoAuxiliar;

        listaBuses = new Buses[12];
        listaPasajeros = new Pasajero[480];

        for (int i = 0 ; i < 480 ; i++){
            numeroBus = listaPasajeros[i].getNumeroBus();
            int j = 0;
            while (listaBuses[j].getNumeroBus() != numeroBus ){
                j++;
            }
            listaBuses[j].sumarPasajero(listaPasajeros[i]);
        }
        for (int i = 0 ; i < 12 ; i++){
            if (!listaBuses[i].revisarRentabilidad())
            {
                Pasajero[] ListaPasajerosAuxiliar = new Pasajero[listaBuses[i].getPasajes() -1];
                destinoAuxiliar = listaBuses[i].getDestino();
                listaBuses[i].quitarPasajeros();
            }
        }
    }
}
