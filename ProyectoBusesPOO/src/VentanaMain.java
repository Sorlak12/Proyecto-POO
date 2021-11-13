import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class VentanaMain extends javax.swing.JFrame {
    private JPanel BusesGUI;
    private JLabel opcionMain;
    private JButton agregarPasajeroButton;
    private JButton agregarBusButton;
    private JButton mostrarBusesButton;
    private JButton mostrarPasajerosButton;
    private JButton asignarBusAPasajeroButton;
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
        this.pack();


        agregarPasajeroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame ventanaPasajero = new VentanaAgregarPasajeros("Agregar Pasajero", Gerencia);
                ventanaPasajero.setVisible(true);
                dispose();
            }
        });

        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        mostrarPasajerosImparesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame mostarPImparesVentana = new MostarPasajerosImparesFrame ("Mostrar Pasajeros Impares", Gerencia);
                mostarPImparesVentana.setVisible(true);
                dispose();
            }
        });
    }

    private void createUIComponents() {

    }

    public static void main(String[] args) {

    }
}
