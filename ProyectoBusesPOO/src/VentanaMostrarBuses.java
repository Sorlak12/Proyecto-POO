import javax.swing.*;
import java.io.FileNotFoundException;

public class VentanaMostrarBuses extends javax.swing.JFrame {
    private JButton atrasButton;
    private JTextArea ListasBusesTexto;
    private JPanel MostrarBusesPanel;

    public VentanaMostrarBuses(String title, AgenciaBuses Gerenecia){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(MostrarBusesPanel);
        this.setSize(600, 800);
        ListasBusesTexto.setText(Gerenecia.mostrarBuses());
        ListasBusesTexto.setCaretPosition(0);
        atrasButton.addActionListener(e -> {
            JFrame menuPrincipal = null;
            try {
                menuPrincipal = new VentanaMain("Agencia de Buses", Gerenecia);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            assert menuPrincipal != null;
            menuPrincipal.setVisible(true);
            dispose();
        });

    }

}
