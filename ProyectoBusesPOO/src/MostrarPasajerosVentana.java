import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class MostrarPasajerosVentana extends javax.swing.JFrame {
    private JButton atrasButton;
    private JTextPane ListaPasajerosText;
    private JPanel MostrarPasajerosFrame;
    private JScrollPane ScrollPane;

    public MostrarPasajerosVentana(String title, AgenciaBuses Gerencia){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(MostrarPasajerosFrame);
        this.setSize(600, 500);
        ListaPasajerosText.setText(Gerencia.mostrarPasajeros());
        ListaPasajerosText.setCaretPosition(0);
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame menuPrincipal = null;
                try {
                    menuPrincipal = new VentanaMain("Agencia de Buses", Gerencia);
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
