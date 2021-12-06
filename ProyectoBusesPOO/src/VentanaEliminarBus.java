import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;

public class VentanaEliminarBus extends javax.swing.JFrame{
    private JButton atrasButton;
    private JPanel EliminarBusPanel;
    private JTextField NumeroBusText;
    private JButton confirmarButton;
    private JButton guardarButton;
    private JLabel EstadoLabel;

    public VentanaEliminarBus(String title, AgenciaBuses Gerencia) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(EliminarBusPanel);
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
            if (Gerencia.getMapaListaBuses().get(Integer.parseInt(NumeroBusText.getText())) != null){
                EstadoLabel.setText(Gerencia.eliminarBus(Integer.parseInt(NumeroBusText.getText())));
                confirmarButton.setVisible(false);
                guardarButton.setVisible(true);
            }
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
                bufferedWriter.close();

            }
            catch (Exception error){
                error.printStackTrace();
            }
            EstadoLabel.setText("Se ha guardado la operacion, presione atras para volver al menu principal");
            guardarButton.setVisible(false);

        });
    }
}
