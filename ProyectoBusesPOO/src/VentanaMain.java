import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;

public class VentanaMain extends javax.swing.JFrame {
    private JPanel BusesGUI;
    private JLabel opcionMain;
    private JButton agregarPasajeroButton;
    private JButton agregarBusButton;
    private JButton mostrarBusesButton;
    private JButton mostrarPasajerosButton;
    private JButton cambiarBusAPasajeroButton;
    private JButton eliminarBusButton;
    private JButton cambiarConductorBusButton;
    private JButton mostrarPasajerosParesButton;
    private JButton mostrarPasajerosImparesButton;
    private JButton buscarPasajeroMasJovenButton;
    private JButton eliminarPasajeroButton;
    private JButton buscarBusDePasajeroButton;
    private JButton salirButton;



    public VentanaMain(String title, AgenciaBuses Gerencia) throws FileNotFoundException {

        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(BusesGUI);
        this.setSize(600, 500);

        agregarPasajeroButton.addActionListener(e -> {
            JFrame ventanaPasajero = new VentanaAgregarPasajeros("Agregar Pasajero", Gerencia);
            ventanaPasajero.setVisible(true);
            dispose();
        });

        salirButton.addActionListener(e -> {
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
            System.exit(0);
        });
        mostrarPasajerosImparesButton.addActionListener(e -> {
            JFrame mostarPImparesVentana = new MostarPasajerosImparesFrame ("Mostrar Pasajeros Impares", Gerencia);
            mostarPImparesVentana.setVisible(true);
            dispose();
        });
        mostrarPasajerosButton.addActionListener(e -> {
            JFrame mostarPasajerosVentana = new MostrarPasajerosVentana("Mostrar Pasajeros", Gerencia);
            mostarPasajerosVentana.setVisible(true);
            dispose();
        });
        mostrarBusesButton.addActionListener(e -> {
            JFrame ventanaMostrarBuses = new VentanaMostrarBuses("Mostrar Buses", Gerencia);
            ventanaMostrarBuses.setVisible(true);
            dispose();
        });
        agregarBusButton.addActionListener(e -> {
            JFrame AgregarBusPanel = new AgregarBusPanel("Agregar Bus", Gerencia);
            AgregarBusPanel.setVisible(true);
            dispose();
        });
        cambiarBusAPasajeroButton.addActionListener(e -> {
            JFrame ventanaCambiarBus = new VentanaCambiarBus("Agregar Bus", Gerencia);
            ventanaCambiarBus.setVisible(true);
            dispose();
        });
        mostrarPasajerosParesButton.addActionListener(e -> {
            JFrame ventanaPasajerosPares = new VentanaMostrarPasajerosPares("Lista Pasajersos con Asiento Par",
                                                                                                          Gerencia);
            ventanaPasajerosPares.setVisible(true);
            dispose();
        });
        buscarBusDePasajeroButton.addActionListener(e -> {
            JFrame ventanaBuscarBusPasajero = new VentanaBuscarBusPasajero("Buscar en que bus está el pasajero"
                                                                                                        , Gerencia);
            ventanaBuscarBusPasajero.setVisible(true);
            dispose();
        });
        buscarPasajeroMasJovenButton.addActionListener(e -> {
            JFrame ventanaPasajeroMenor = new VentanaPasajeroMenor("Pasajero Mas Joven", Gerencia);
            ventanaPasajeroMenor.setVisible(true);
            dispose();
        });
    }


    private void createUIComponents() {

    }

    public static void main(String[] args) {

    }
}
