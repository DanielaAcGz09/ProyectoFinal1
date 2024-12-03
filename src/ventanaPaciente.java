import Metodos.metodoPaciente;
import entidades.Paciente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ventanaPaciente extends JFrame{
    private JPanel miPanel;
    private JTextField txtNSS;
    private JTextField txtNombre;
    private JTextField txtApPaterno;
    private JTextField txtApMaterno;
    private JTextField txtTelefono;
    private JTextField txtEdad;
    private JTextField txtFechConsu;
    private JButton btnBuscar;
    private JButton btnAgregar;
    private JButton btnGuardar;
    private JButton btnEliminar;
    private JComboBox comboBox1;

    public ventanaPaciente() {
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                metodoPaciente crud = new metodoPaciente();
                String numeroDeSeguridadSocial = txtNSS.getText();
                Paciente a = null;
                try {
                    a = crud.getInfoPacientePornumeroDeSeguridadSocial(numeroDeSeguridadSocial);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                if (a == null) {
                    int respuesta = JOptionPane.showConfirmDialog(
                            miPanel,
                            "No se encuentra ese Paciente " + numeroDeSeguridadSocial + ". ¿Desea ingresarlo?",
                            "Paciente",
                            JOptionPane.YES_NO_OPTION
                    );
                    if (respuesta == 0) {
                        //dar de alta a un Paciente inexistente
                        btnAgregar.setEnabled(true);
                        txtNombre.requestFocus();
                    } else if (respuesta == 1) {
                        //No quiere dar de alta, limpiar formulario

                    }
                } else {
                    //Se encontro al Paciente
                    txtNombre.setText(a.getNombre());
                    txtApPaterno.setText(a.getApellidoPat());
                    txtApMaterno.setText(a.getApellidoMat());
                    txtTelefono.setText(a.getTelefono());
                    txtEdad.setText(String.valueOf(a.getEdad()));
                    txtFechConsu.setText(a.getFechadeconsulta());
                    btnGuardar.setEnabled(true);
                    btnEliminar.setEnabled(true);
                }
            }
        });
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //instanciar un obejcto de la clase Paciente
                Paciente miPacienciente = new Paciente();
                miPacienciente.setNumeroDeSeguridadSocial(txtNSS.getText());
                miPacienciente.setNombre(txtNombre.getText());
                miPacienciente.setApellidoPat(txtApPaterno.getText());
                miPacienciente.setApellidoMat(txtApMaterno.getText());
                miPacienciente.setTelefono(txtTelefono.getText());
                miPacienciente.setEdad(Integer.parseInt(txtEdad.getText()));
                miPacienciente.setFechadeconsulta(txtFechConsu.getText());

                //invocar metodo para agregar Paciente
                metodoPaciente crud = new metodoPaciente();
                crud.agregarPaciente(miPacienciente);
            }
        });
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                metodoPaciente crud = new metodoPaciente();
                Paciente miPacienciente = new Paciente();
                miPacienciente.setNumeroDeSeguridadSocial(txtNSS.getText());
                miPacienciente.setNombre(txtNombre.getText());
                miPacienciente.setApellidoPat(txtApPaterno.getText());
                miPacienciente.setApellidoMat(txtApMaterno.getText());
                miPacienciente.setTelefono(txtTelefono.getText());
                miPacienciente.setEdad(Integer.parseInt(txtEdad.getText()));
                miPacienciente.setFechadeconsulta(txtFechConsu.getText());

                crud.actualizarPaciente(miPacienciente);
                JOptionPane.showMessageDialog(miPanel, "Paciente actualizado correctamente.");

                dispose();
                String[] tipoUsuario={"admin"};
                ventanaCitaa.main(tipoUsuario);
            }
        });


        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                metodoPaciente crud = new metodoPaciente();
                String numeroDeSeguridadSocial = txtNSS.getText();
                int respuesta = JOptionPane.showConfirmDialog(
                        miPanel,
                        "¿Está seguro de que desea eliminar este paciente?",
                        "Eliminar Paciente",
                        JOptionPane.YES_NO_OPTION
                );
                if (respuesta == JOptionPane.YES_OPTION) {
                    crud.eliminarPaciente(numeroDeSeguridadSocial);
                    JOptionPane.showMessageDialog(miPanel, "Paciente eliminado correctamente.");

                    // Limpiar formulario
                    txtNSS.setText("");
                    txtNombre.setText("");
                    txtApPaterno.setText("");
                    txtApMaterno.setText("");
                    txtTelefono.setText("");
                    txtEdad.setText("");
                    txtFechConsu.setText("");
                    btnGuardar.setEnabled(false);
                    btnEliminar.setEnabled(false);
                }
            }
        });
    }

    public static void main(String[] args) {
        ventanaPaciente v = new ventanaPaciente();
        v.setContentPane(v.miPanel);
        v.setSize(500,500);
        v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        v.setVisible(true);
    }
}
