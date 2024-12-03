package operaciones;

import entidades.Cita;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class validacionesCita {
    public static boolean validarIdDoctor(String idDoctor, ArrayList<String> listaDoctores) {
        return listaDoctores.contains(idDoctor);
    }

    // Validar fecha
    public static boolean validarFecha(String fecha) {
        try {
            LocalDate.parse(fecha);
            return true;
        } catch (Exception e) {
            return false; // la fecha no es válida
        }
    }

    public static boolean validarHora(String hora) {
        try {
            LocalTime.parse(hora);
            return true;
        } catch (Exception e) {
            return false; // hora no válida
        }
    }

    // Validar que los campos de la cita no estén vacíos
    public static boolean validarCamposCita(Cita cita) {
        return cita.getIdDoctor() != null && !cita.getIdDoctor().isEmpty()
                && cita.getNombrePaciente() != null && !cita.getNombrePaciente().isEmpty()
                && cita.getFecha() != null && !cita.getFecha().isEmpty()
                && cita.getHora() != null && !cita.getHora().isEmpty()
                && cita.getMotivo() != null && !cita.getMotivo().isEmpty();
    }
}

