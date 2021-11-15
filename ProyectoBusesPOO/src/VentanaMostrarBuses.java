import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.io.FileNotFoundException;
import java.util.List;

public class VentanaMostrarBuses extends javax.swing.JFrame {
    private JButton atrasButton;
    private JTextArea ListasBusesTexto;
    private JPanel MostrarBusesPanel;
    private JScrollPane ScrollPane;

    public VentanaMostrarBuses(String title, AgenciaBuses Gerenecia){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(MostrarBusesPanel);
        this.setSize(600, 800);
        ListasBusesTexto.setText(Gerenecia.mostrarBuses());
        ListasBusesTexto.setCaretPosition(0);
        atrasButton.addActionListener(new ActionListener() {
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
