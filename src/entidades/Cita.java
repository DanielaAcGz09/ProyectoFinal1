package entidades;

public class Cita {
    private String idDoctor;

    public String getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(String idDoctor) {
        this.idDoctor = idDoctor;
    }

    public String getNombrePaciente() {
        return NombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        NombrePaciente = nombrePaciente;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String hora) {
        Hora = hora;
    }

    public String getMotivo() {
        return Motivo;
    }

    public void setMotivo(String motivo) {
        Motivo = motivo;
    }

    private String NombrePaciente;
    private String Fecha;
    private String Hora;
    private String Motivo;

}
