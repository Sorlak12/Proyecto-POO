import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class VentanaMostrarPasajerosPares extends javax.swing.JFrame{
    private JButton atrasButton;
    private JPanel VentanaListaPares;
    private JTextArea PasajerosParesText;

    public VentanaMostrarPasajerosPares(String title, AgenciaBuses Gerencia){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(VentanaListaPares);
        this.setSize(600, 500);
        ArrayList<Pasajero> pasajerosPares = new ArrayList<>(Gerencia.buscarPasajerosAsientoPar());
        String Pasajeros = "\tLista Pasajeros con asiento par\n";
        for (Pasajero pasajero : pasajerosPares) {
            Pasajeros += (pasajero.getNombre() + " "  + pasajero.getRut()) + " Numero de Bus: " + pasajero.getNumeroBus()
                    + " Numero de Asiento: " + pasajero.getNumeroDeAsiento() +"\n";
        };
        PasajerosParesText.setText(Pasajeros);
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