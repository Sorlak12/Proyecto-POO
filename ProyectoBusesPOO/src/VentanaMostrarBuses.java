import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        ListasBusesTexto.setText(Gerenecia.mostrarBuses());atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame menuPrincipal = null;
                try {
                    menuPrincipal = new VentanaMain("Agencia de Buses", Gerenecia);
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                assert menuPrincipal != null;
                menuPrincipal.setVisible(true);
                dispose();
            }
        });
    }

}
