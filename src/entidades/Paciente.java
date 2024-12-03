package entidades;

import java.io.Serializable;

public class Paciente implements Serializable {

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPat() {
        return apellidoPat;
    }

    public void setApellidoPat(String apellidoPat) {
        this.apellidoPat = apellidoPat;
    }

    public String getApellidoMat() {
        return apellidoMat;
    }

    public void setApellidoMat(String apellidoMat) {
        this.apellidoMat = apellidoMat;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNumeroDeSeguridadSocial() {
        return numeroDeSeguridadSocial;
    }

    public void setNumeroDeSeguridadSocial(String numeroDeSeguridadSocial) {
        this.numeroDeSeguridadSocial = numeroDeSeguridadSocial;
    }

    public String getFechadeconsulta() {
        return fechadeconsulta;
    }

    public void setFechadeconsulta(String fechadeconsulta) {
        this.fechadeconsulta = fechadeconsulta;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    private String nombre;
    private String apellidoPat;
    private String apellidoMat;
    private String telefono;
    private String numeroDeSeguridadSocial;
    private String fechadeconsulta;
    private int edad;

    public Paciente(){
        System.out.println("Se mando a llamar la clase");
    }
    public Paciente (String n){
        this.nombre = n;
    }

}
