import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;

public class VentanaEliminarPasajero extends javax.swing.JFrame{
    private JButton atrasButton;
    private JPanel EliminarPasajeroPanel;
    private JTextField RutPasajeroText;
    private JLabel EstadoLabel;
    private JButton ConfirmarButton;
    private JButton guardarButton;

    public VentanaEliminarPasajero(String title, AgenciaBuses Gerencia) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(EliminarPasajeroPanel);
        this.setSize(600, 500);
        guardarButton.setVisible(false);
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
        ConfirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EstadoLabel.setText(Gerencia.eliminarPasajero(RutPasajeroText.getText()));
                ConfirmarButton.setVisible(false);
                guardarButton.setVisible(true);
            }
        });
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
                RutPasajeroText.setVisible(false);
                guardarButton.setVisible(false);
                EstadoLabel.setText("Se ha guardado la operacion, presione atras para ir al menu principal");
            }
        });
    }
}
