import Metodos.metodoDoctor;
import Metodos.metodoPaciente;
import entidades.Doctor;
import entidades.Paciente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ventanaCitaa extends JFrame {
    private JPanel miPanel;
    private JComboBox cmbPaciente;
    private JComboBox cmbDoctor;
    private JTextArea txtMotv;
    private JButton btnIngresarC;
    private JButton btnCancelar;
    private JButton btnLimpiar;
    private JTextField txtPaciente;
    private JComboBox cmbDia;
    private JComboBox cmbMes;
    private JComboBox cmbAnio;
    private JTextField txtEspecialidad;
    ArrayList<Paciente> lista;

    public boolean validaFecha(String fecha){
        SimpleDateFormat formatoFecha =
                new SimpleDateFormat("dd/MM/yyyy");
        try {
            formatoFecha.setLenient(false);
            formatoFecha.parse(fecha);
            return true;
        } catch (ParseException e) {
            return false;
        }

    }

    //Metodo Constructor
    public ventanaCitaa(){
        //Conctarse a la lista
        try{
            FileInputStream leer =
                    new FileInputStream("C:\\Users\\danie\\IdeaProjects\\ProyectoFinal1\\pacientes.txt");
            ObjectInputStream lectorObejtos = new ObjectInputStream(leer);
            Object o = lectorObejtos.readObject();
            lista = (ArrayList<Paciente>) o;

            for (Paciente p: lista)
            {
                cmbPaciente.addItem( p.getNumeroDeSeguridadSocial());
            }
            lectorObejtos.close();
            leer.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try{
            FileInputStream leer =
                    new FileInputStream("C:\\Users\\danie\\IdeaProjects\\ProyectoFinal1\\doctoress.txt");
            ObjectInputStream lectorObejtos = new ObjectInputStream(leer);
            Object o = lectorObejtos.readObject();
            ArrayList<Doctor> lista =(ArrayList<Doctor>) o;

            for (Doctor d: lista)
            {
                cmbDoctor.addItem( d.getApellidoPat());
            }
            lectorObejtos.close();
            leer.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        cmbPaciente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                metodoPaciente crud = new metodoPaciente();
                String numero = cmbPaciente.getSelectedItem().toString();
                String nombreCompleto;
                try {
                    Paciente a = crud.getInfoPacientePornumeroDeSeguridadSocial(numero);
                    nombreCompleto = a.getNombre() + " " + a.getApellidoPat();
                    txtPaciente.setText(nombreCompleto);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        cmbDoctor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                metodoDoctor crudDoctor = new metodoDoctor(); // Clase que maneja los doctores
                String nombreDoctor = cmbDoctor.getSelectedItem().toString(); // Obtiene el doctor seleccionado
                String especialidad;

                // Busca la información del doctor seleccionado
                Doctor doctor = null;
                try {
                    doctor = crudDoctor.getInfoDoctorPorNombre(nombreDoctor);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }

                // Obtiene la especialidad del doctor
                especialidad = doctor.getEspecialidad();

                // Actualiza el campo de texto con la especialidad
                txtEspecialidad.setText(especialidad);
            }
        });


        btnIngresarC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fecha = cmbDia.getSelectedItem().toString() + "/" + cmbMes.getSelectedItem().toString() + "/" + cmbAnio.getSelectedItem().toString() ;

                boolean resultado = validaFecha(fecha);
                if(resultado==true)
                {
                    JOptionPane.showMessageDialog(miPanel,"Fecha correcta");
                }
                else {
                    JOptionPane.showMessageDialog(miPanel,"Error en la fecha");
                }

                dispose();
                String[] tipoUsuario={"admin"};
                ventanaDoctor.main(tipoUsuario);
            }
        });


        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(miPanel,
                        "¿Estás seguro de que deseas salir?", "Confirmación", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cmbPaciente.setSelectedIndex(0);
                cmbDoctor.setSelectedIndex(0);
                cmbDia.setSelectedIndex(0);
                cmbMes.setSelectedIndex(0);
                cmbAnio.setSelectedIndex(0);
                txtMotv.setText("");
            }
        });
    }

    public static void main(String[] args) {
        ventanaCitaa c = new ventanaCitaa();
        c.setContentPane(c.miPanel);
        c.setSize(500, 500);
        c.setTitle("Altas de Citas");
        c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c.setVisible(true);
    }
}