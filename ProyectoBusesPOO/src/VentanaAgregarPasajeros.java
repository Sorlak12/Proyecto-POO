import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class VentanaAgregarPasajeros extends javax.swing.JFrame{
    private JPanel AgregarPasajerosMenu;
    private JLabel nombrePasajeroLabel;
    private JTextField NombreText;
    private JLabel OpcionPasajeroLabel;
    private JTextField opcionTextField;
    private JLabel RutPasajeroLabel;
    private JTextField RutPasajeroText;
    private JLabel NumeroBusLabel;
    private JTextField NumeroBusText;
    private JLabel NumeroAsientoLabel;
    private JTextField NumeroAsientoText;
    private JLabel AnyoNacimientoLabel;
    private JTextField AnyoNacimientoText;
    private JLabel MesNacimientoLabel;
    private JTextField MesNacimientoText;
    private JLabel DiaNacimientoLabel;
    private JTextField DiaNacimientoText;
    private JButton ConfirmarButton;
    private JLabel EstadoLabel;
    private JButton atrasButton;
    Pasajero nuevo = new PasajeroComun();

    public VentanaAgregarPasajeros(String title, AgenciaBuses Gerencia){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(AgregarPasajerosMenu);
        this.pack();

        ConfirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crearPasajero(Gerencia);
            }
        });
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame menuPrincipal = null;
                try {
                    menuPrincipal = new VentanaMain("Agencia de Buses",Gerencia);
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                assert menuPrincipal != null;
                menuPrincipal.setVisible(true);
                dispose();
            }
        });
    }
    public void crearPasajero(AgenciaBuses Gerencia){
        Pasajero nuevo = new PasajeroComun();
        String opcionPasajero = opcionTextField.getText() ;
        if (opcionPasajero.compareTo("estudiante") == 0) {
            nuevo = new Estudiante();
        } else if (opcionPasajero.compareTo("Adulto Mayor") == 0) {
            nuevo = new AdultoMayor();
        };
        nuevo.setNombre(NombreText.getText());
        nuevo.setRut(RutPasajeroText.getText());
        nuevo.setNumeroBus(Integer.parseInt(NumeroBusText.getText()));
        nuevo.setNumeroDeAsiento(Integer.parseInt(NumeroAsientoText.getText()));
        nuevo.setAnyoNacimiento(Integer.parseInt(AnyoNacimientoText.getText()));
        nuevo.setMesNacimiento(Integer.parseInt(MesNacimientoText.getText()));
        nuevo.setDiaNacimiento(Integer.parseInt(DiaNacimientoText.getText()));
        nuevo.setPorcentajeDescuento();
        EstadoLabel.setText("Operacion Exitosa");
        Gerencia.sumarPasajero(nuevo);
    }
    public Pasajero getPasajero(){
        return nuevo;
    }
}
