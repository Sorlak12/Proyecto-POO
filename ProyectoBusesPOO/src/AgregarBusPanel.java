import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;

public class AgregarBusPanel extends javax.swing.JFrame {
    private JButton atrasButton;
    private JTextField NroBusText;
    private JTextField DestinoText;
    private JTextField RutConductorText;
    private JTextField NConductorText;
    private JPanel PanelAgregarBuses;
    private JButton confirmarButton;
    private JLabel EstadoLabel;

    public AgregarBusPanel(String title, AgenciaBuses Gerencia) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(PanelAgregarBuses);
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
            crearBus(Gerencia);
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
        });
    }
    public void crearBus(AgenciaBuses Gerencia){
        Conductor conductor = new Conductor(NConductorText.getText(),RutConductorText.getText(),Integer.parseInt(NroBusText.getText()));
        Buses bus = new Buses(Integer.parseInt(NroBusText.getText()), DestinoText.getText(),conductor);
        EstadoLabel.setText("Operacion Exitosa");
        Gerencia.sumarBus(bus, conductor);
    }
}
