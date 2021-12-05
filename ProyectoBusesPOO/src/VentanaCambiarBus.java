import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Objects;

public class VentanaCambiarBus extends javax.swing.JFrame {
    private JPanel CambiarBusPanel;
    private JButton atrasButton;
    private JTextField RutUsuarioText;
    private JButton confirmarButton;
    private JLabel ErrorLabel;
    private JScrollPane BusesDisponiblesPanel;
    private JTextField BusesDisponiblesText;
    private JTextField DestinoUsuarioText;
    private JLabel DestinoUsuarioLabel;
    private JLabel RutLabel;
    private JTextField SeleccionTextField;
    private JLabel TextoExito;
    private JButton guardarButton;

    public VentanaCambiarBus(String title, AgenciaBuses Gerencia){
        super(title);
        SeleccionTextField.setVisible(false);
        BusesDisponiblesPanel.setVisible(false);
        BusesDisponiblesText.setVisible(false);
        guardarButton.setVisible(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(CambiarBusPanel);
        this.setSize(600, 500);
        atrasButton.addActionListener(e -> {
            JFrame menuPrincipal = null;
            try {
                menuPrincipal = new VentanaMain("Agencia de Buses",Gerencia);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            assert menuPrincipal != null;
            menuPrincipal.setVisible(true);
            dispose();
        });
        confirmarButton.addActionListener(e -> {
            if (!Gerencia.getMapaListaPasajeros().containsKey(RutUsuarioText.getText())) {
                ErrorLabel.setText("Pasajero No encontrado");
                }
            else {
                ErrorLabel.setVisible(false);
                RutLabel.setVisible(false);
                DestinoUsuarioLabel.setVisible(false);
                DestinoUsuarioText.setVisible(false);
                RutUsuarioText.setVisible(false);
                Pasajero pasajero = Gerencia.getMapaListaPasajeros().get(RutUsuarioText.getText());
                if (pasajero.getNumeroBus() != 0){
                    Gerencia.getMapaListaBuses().get(pasajero.getNumeroBus()).quitarPasajero(pasajero.getRut());
                    pasajero.setNumeroBus(0);
                }
                for (Buses Bus : Gerencia.getListaBuses()){
                    if (Objects.equals(Bus.getDestino(), DestinoUsuarioText.getText())){
                        pasajero.setNumeroBus(Bus.getNumeroBus());
                        Bus.sumarPasajero(pasajero);
                    }
                }
                Gerencia.getMapaListaPasajeros().put(pasajero.getRut(), pasajero);
                TextoExito.setVisible(true);
                guardarButton.setVisible(true);
                TextoExito.setText("El Pasajero se ha cambiado al bus Nro: " + pasajero.getNumeroBus() + " Presione Guardar");
                confirmarButton.setVisible(false);
            }
        });
        guardarButton.addActionListener(e -> {
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
            catch (Exception error){
                error.printStackTrace();
            }
            TextoExito.setText("Se ha guardado la operacion, presione atras para volver al menu principal");
            guardarButton.setVisible(false);
        });
    }
}
