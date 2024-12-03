package operaciones;

import entidades.Paciente;
import java.io.*;
import java.util.ArrayList;

public class validacionesPaciente {

    // Validar si un doctor con la misma cédula ya existe
    public static boolean existePaciente(String NSS, ArrayList<Paciente> lista) {
        for (Paciente paciente : lista) {
            if (paciente.getNumeroDeSeguridadSocial().equals(NSS)) {
                return true; // Existe un doctor con esta cédula
            }
        }
        return false;
    }

    // Validar numero de seguridad social
    public static boolean validarFormatoNSS(String NSS) {
        return NSS.matches("\\d{11}");
    }

    // Validar que el teléfono tenga solo 10 dígitos
    public static boolean validarTelefono(String telefono) {
        return telefono.matches("\\d{10}");
    }
    // Validar que los campos no estén vacíos
    public static boolean validarCamposPaciente(Paciente paciente) {
        return paciente.getNumeroDeSeguridadSocial() != null && !paciente.getNumeroDeSeguridadSocial().isEmpty()
                && paciente.getNombre() != null && !paciente.getNombre().isEmpty()
                && paciente.getApellidoPat() != null && !paciente.getApellidoPat().isEmpty()
                && paciente.getApellidoMat() != null && !paciente.getApellidoMat().isEmpty()
                && paciente.getTelefono() != null && !paciente.getTelefono().isEmpty()
                && paciente.getFechadeconsulta() != null && !paciente.getFechadeconsulta().isEmpty();
    }

}
