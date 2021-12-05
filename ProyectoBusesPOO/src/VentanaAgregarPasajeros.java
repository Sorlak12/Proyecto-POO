import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;

public class VentanaAgregarPasajeros extends javax.swing.JFrame{
    private JPanel AgregarPasajerosMenu;
    private JTextField NombreText;
    private JTextField opcionTextField;
    private JTextField RutPasajeroText;
    private JTextField NumeroBusText;
    private JTextField NumeroAsientoText;
    private JTextField AnyoNacimientoText;
    private JTextField MesNacimientoText;
    private JTextField DiaNacimientoText;
    private JButton ConfirmarButton;
    private JLabel EstadoLabel;
    private JButton atrasButton;
    private JLabel ErrorLabel;

    public VentanaAgregarPasajeros(String title, AgenciaBuses Gerencia){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(AgregarPasajerosMenu);
        this.setSize(600, 500);

        ConfirmarButton.addActionListener(e -> {
            crearPasajero(Gerencia);
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
        });
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
    }
    public void crearPasajero(AgenciaBuses Gerencia){
        Pasajero nuevo = new PasajeroComun();
        String opcionPasajero = opcionTextField.getText().toLowerCase() ;

            if (opcionPasajero.compareTo("estudiante") == 0) {
                nuevo = new Estudiante();
            } else if (opcionPasajero.compareTo("adulto Mayor") == 0) {
                nuevo = new AdultoMayor();
            }
        if (NombreText.getText().equals(""))
                ErrorLabel.setText("Debe ingresar un nombre");
            nuevo.setNombre(NombreText.getText());
            nuevo.setRut(RutPasajeroText.getText());
            nuevo.setNumeroBus(Integer.parseInt(NumeroBusText.getText()));
            nuevo.setNumeroDeAsiento(Integer.parseInt(NumeroAsientoText.getText()));
            nuevo.setAnyoNacimiento(Integer.parseInt(AnyoNacimientoText.getText()));
            nuevo.setMesNacimiento(Integer.parseInt(MesNacimientoText.getText()));
            nuevo.setDiaNacimiento(Integer.parseInt(DiaNacimientoText.getText()));
            nuevo.setPorcentajeDescuento();
            EstadoLabel.setText("Operacion Exitosa");
            Gerencia.sumarPasajero(nuevo);
    }
}
