import javax.swing.*;
import java.io.FileNotFoundException;

public class VentanaPasajeroMenor extends javax.swing.JFrame{
    private JPanel PasajeroMenorPanel;
    private JLabel PasajeroMenorText;
    private JButton atrasButton;

    public VentanaPasajeroMenor(String title, AgenciaBuses Gerencia) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(PasajeroMenorPanel);
        this.setSize(600, 500);
        Pasajero PasajeroMasJoven = Gerencia.buscarPasajeroMenor();
        PasajeroMenorText.setText("El pasajero mas joven es " + PasajeroMasJoven.getNombre() + ", nacido el " +
                PasajeroMasJoven.getDiaNacimiento() + "/" + PasajeroMasJoven.getMesNacimiento() + "/" + PasajeroMasJoven.getAnyoNacimiento());
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
    }
}
