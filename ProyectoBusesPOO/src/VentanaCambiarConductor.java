import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;

public class VentanaCambiarConductor  extends javax.swing.JFrame{
    private JButton atrasButton;
    private JTextField RutConductorText;
    private JTextField NumBusText;
    private JButton confirmarButton;
    private JButton guardarButton;
    private JPanel CambiarConductorPanel;
    private JLabel EstadoLabel;
    private JLabel IngreseRutLabel;
    private JLabel IngreseNumBusLabel;

    public VentanaCambiarConductor(String title, AgenciaBuses Gerencia) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(CambiarConductorPanel);
        this.setSize(600, 500);
        guardarButton.setVisible(false);
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
        confirmarButton.addActionListener(e -> {
            EstadoLabel.setText(Gerencia.cambiarConductor(RutConductorText.getText(), Integer.parseInt(NumBusText.getText())));
            confirmarButton.setVisible(false);
            RutConductorText.setVisible(false);
            NumBusText.setVisible(false);
            guardarButton.setVisible(true);
            IngreseNumBusLabel.setVisible(false);
            IngreseRutLabel.setVisible(false);

        });
        guardarButton.addActionListener(e -> {
            try{
                File archivo = new File("reporte.txt");
                File pasajerosAgencia = new File("PasajerosAgencia.txt");
                File busesAgencia = new File("BusesAgencia.txt");
                if (!archivo.exists()){
                    if (archivo.createNewFile()){
                        FileWriter fw = new FileWriter(archivo);
                        BufferedWriter bw = new BufferedWriter(fw);
                        bw.write(Gerencia.mostrarPasajeros());
                        bw.write(Gerencia.mostrarBuses());
                        bw.close();
                        System.out.println("El archivo ha sido creado correctamente");
                    }
                    else System.out.println("El arhivo no se pudo crear");
                }
                else {
                    FileWriter fw = new FileWriter(archivo);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(Gerencia.mostrarPasajeros());
                    bw.write(Gerencia.mostrarBuses());
                    bw.close();
                    System.out.println("El archivo se ha sobreescrito");
                }
                FileWriter pasjaros = new FileWriter(pasajerosAgencia);
                BufferedWriter bufferedWriter = new BufferedWriter(pasjaros);
                bufferedWriter.write(Gerencia.imprimirPasajerosEnArchivo());
                bufferedWriter.close();
                FileWriter buses = new FileWriter(busesAgencia);
                bufferedWriter = new BufferedWriter(buses);
                bufferedWriter.write(Gerencia.imprimirBusesArchivo());
            }
            catch (Exception error){
                error.printStackTrace();
            }
            EstadoLabel.setText("Se ha guardado la operacion, presione atras para ir al menu principal");
            guardarButton.setVisible(false);
        });
    }
}
