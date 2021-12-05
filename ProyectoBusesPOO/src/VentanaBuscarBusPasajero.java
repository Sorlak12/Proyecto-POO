import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class VentanaBuscarBusPasajero extends javax.swing.JFrame{
    private JButton atrasButton;
    private JTextField RutPasajeroText;
    private JButton confirmarButton;
    private JPanel BuscarBusPasajeroPanel;
    private JLabel EstadoOperacionLabel;
    private JLabel InstruccionLabel;

    public VentanaBuscarBusPasajero(String title, AgenciaBuses Gerencia) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(BuscarBusPasajeroPanel);
        this.setSize(600, 500);
        confirmarButton.addActionListener(e -> {
            if (!Gerencia.getMapaListaPasajeros().containsKey(RutPasajeroText.getText())){
                EstadoOperacionLabel.setText("El pasajero no se ha encontrado");
            }
            else {
                int numBus = Gerencia.getMapaListaPasajeros().get(RutPasajeroText.getText()).getNumeroBus();
                EstadoOperacionLabel.setText("");
                if (numBus == 0){
                    EstadoOperacionLabel.setText("El pasajero no se encuentra asignado a ningun bus");
                }
                else {
                    InstruccionLabel.setVisible(false);
                    RutPasajeroText.setVisible(false);
                    confirmarButton.setVisible(false);
                    EstadoOperacionLabel.setText("El pasajero se encuentra en el bus Nro " + numBus + " con destino a "
                            + Gerencia.getMapaListaBuses().get(numBus).getDestino());
                }
            }

        });
        atrasButton.addActionListener(e -> {

            JFrame menuPrincipal = null;
            try {
                menuPrincipal = new VentanaMain("Agencia de Buses", Gerencia);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            assert menuPrincipal != null;
            menuPrincipal.setVisible(true);
            dispose();
        });
    }
}
