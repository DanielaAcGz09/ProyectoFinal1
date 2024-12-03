import Metodos.metodoDoctor;
import entidades.Doctor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ventanaDoctor extends JFrame{
    private JPanel miPanel;
    private JTextField txtNombre;
    private JTextField txtPaterno;
    private JTextField txtEspecialidad;
    private JTextField txtTelefono;
    private JTextField txtDisponibilidad;
    private JTextField txtCedulaProf;
    private JButton btnBuscar;
    private JButton btnAgregar;
    private JButton btnGuardar;
    private JButton btnEliminar;

    public ventanaDoctor() {
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                metodoDoctor crud = new metodoDoctor();
                String cedulaProfesional = txtCedulaProf.getText();
                Doctor a = null;
                a = crud.getInfoDoctorporCedulaProfesional(cedulaProfesional);

                if (a == null) {
                    int respuesta = JOptionPane.showConfirmDialog(
                            miPanel,
                            "No se encuentra este Doctor " + cedulaProfesional + ". ¿Desea ingresarlo?",
                            "Doctor",
                            JOptionPane.YES_NO_OPTION
                    );
                    if (respuesta == 0) {
                        //dar de alta a un Doctor inexistente
                        btnAgregar.setEnabled(true);
                        txtNombre.requestFocus();
                    } else if (respuesta == 1) {
                        //No quiere dar de alta, limpiar formulario

                    }
                } else {
                    //Se encontro al Doctor
                    txtNombre.setText(a.getNombre());
                    txtPaterno.setText(a.getApellidoPat());
                    txtCedulaProf.setText(a.getCedulaProfesional());
                    txtTelefono.setText(a.getTelefono());
                    txtDisponibilidad.setText(String.valueOf(a.getDisponibilidad()));
                    txtEspecialidad.setText(a.getEspecialidad());
                    btnGuardar.setEnabled(true);
                    btnEliminar.setEnabled(true);
                }
            }
        });
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //instanciar un obejcto de la clase Paciente
                Doctor miDoctor = new Doctor();
                miDoctor.setCedulaProfesional(txtCedulaProf.getText());
                miDoctor.setNombre(txtNombre.getText());
                miDoctor.setApellidoPat(txtPaterno.getText());
                miDoctor.setTelefono(txtTelefono.getText());
                miDoctor.setDisponibilidad(txtDisponibilidad.getText());
                miDoctor.setEspecialidad(txtEspecialidad.getText());

                //invocar metodo para agregar Paciente
                metodoDoctor crud = new metodoDoctor();
                crud.agregarDoctor(miDoctor);

            }
        });
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                metodoDoctor crud = new metodoDoctor();
                Doctor miDoctor = new Doctor();
                miDoctor.setCedulaProfesional(txtCedulaProf.getText());
                miDoctor.setNombre(txtNombre.getText());
                miDoctor.setApellidoPat(txtPaterno.getText());
                miDoctor.setTelefono(txtTelefono.getText());
                miDoctor.setDisponibilidad(txtDisponibilidad.getText());
                miDoctor.setEspecialidad(txtEspecialidad.getText());

                crud.actualizarDoctor(miDoctor);
                JOptionPane.showMessageDialog(miPanel, "Doctor actualizado correctamente.");

            }
        });


        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                metodoDoctor crud = new metodoDoctor();
                String cedulaProfesional = txtCedulaProf.getText();
                int respuesta = JOptionPane.showConfirmDialog(
                        miPanel,
                        "¿Está seguro de que desea eliminar este Doctor?",
                        "Eliminar Doctor",
                        JOptionPane.YES_NO_OPTION
                );
                if (respuesta == JOptionPane.YES_OPTION) {
                    crud.eliminarDoctor(cedulaProfesional);
                    JOptionPane.showMessageDialog(miPanel, "Doctor eliminado correctamente.");

                    // Limpiar formulario
                    txtCedulaProf.setText("");
                    txtNombre.setText("");
                    txtPaterno.setText("");
                    txtEspecialidad.setText("");
                    txtTelefono.setText("");
                    txtDisponibilidad.setText("");
                    btnGuardar.setEnabled(false);
                    btnEliminar.setEnabled(false);
                }
            }
        });
    }

    public static void main(String[] args) {
        ventanaDoctor v = new ventanaDoctor();
        v.setContentPane(v.miPanel);
        v.setSize(500,500);
        v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        v.setVisible(true);
    }
}