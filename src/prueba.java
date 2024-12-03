import entidades.Doctor;
import Metodos.metodoDoctor;

public class prueba {

    public static void main(String[] args) {
        metodoDoctor aluCRUD = new metodoDoctor();
        Doctor resultado = aluCRUD.getInfoDoctorporCedulaProfesional("AE010665");
        if(resultado==null)
        {
            System.out.println("No se encuentra esa cedula profesional");
        }else{
            System.out.println(resultado.getCedulaProfesional());
            System.out.println(resultado.getNombre());
            System.out.println(resultado.getApellidoPat());
            System.out.println(resultado.getEspecialidad());
            System.out.println(resultado.getTelefono());
            System.out.println(resultado.getDisponibilidad());
        }

    }
}
