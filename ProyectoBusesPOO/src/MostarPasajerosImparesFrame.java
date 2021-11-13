import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class MostarPasajerosImparesFrame extends javax.swing.JFrame{
    private JPanel VentanaLIstaImpares;
    private JTextArea PasajerosImparesText;
    private JButton atrasButton;
    private JLabel ListaPasajerosImparesLable;
    public MostarPasajerosImparesFrame(String title, AgenciaBuses Gerencia){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(VentanaLIstaImpares);
        this.setSize(700, 600);
        ArrayList<Pasajero> pasajerosImpares = new ArrayList<Pasajero>(Gerencia.buscarPasajerosAsientoImpar());
        String Pasajeros = "\tLista Pasajeros Impares\n";
        for (Pasajero pasajero : pasajerosImpares) {
            Pasajeros += (pasajero.getNombre() + " "  + pasajero.getRut()) + " Numero de Bus: " + pasajero.getNumeroBus()
                    + " Numero de Asiento: " + pasajero.getNumeroDeAsiento() +"\n";
        };
        PasajerosImparesText.setText(Pasajeros);
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
