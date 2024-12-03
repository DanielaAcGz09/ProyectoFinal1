package operaciones;

import entidades.Doctor;
import java.io.*;
import java.util.ArrayList;

public class validacionesDoctor {
    // Validar si un doctor con la misma cédula ya existe
    public static boolean existeDoctor(String cedula, ArrayList<Doctor> lista) {
        for (Doctor doctor : lista) {
            if (doctor.getCedulaProfesional().equals(cedula)) {
                return true; // Existe un doctor con esta cédula
            }
        }
        return false;
    }

    // Validar cédula profesional
    public static boolean validarFormatoCedula(String cedula) {
        return cedula.matches("[A-Za-z0-9]+");
    }

    // Validar que el teléfono tenga solo 10 dígitos
    public static boolean validarTelefono(String telefono) {
        return telefono.matches("\\d{10}");
    }

    // Validar que los campos no estén vacíos
    public static boolean validarCamposDoctor(Doctor doctor) {
        return doctor.getCedulaProfesional() != null && !doctor.getCedulaProfesional().isEmpty()
                && doctor.getNombre() != null && !doctor.getNombre().isEmpty()
                && doctor.getApellidoPat() != null && !doctor.getApellidoPat().isEmpty()
                && doctor.getEspecialidad() != null && !doctor.getEspecialidad().isEmpty()
                && doctor.getTelefono() != null && !doctor.getTelefono().isEmpty()
                && doctor.getDisponibilidad() != null && !doctor.getDisponibilidad().isEmpty();

    }
}
