import entidades.Doctor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            ArrayList<Doctor> listaDoctor = new ArrayList<Doctor>();

            Doctor d1 = new Doctor();
            d1.setCedulaProfesional("PA2737891267");
            d1.setNombre("Jose");
            d1.setApellidoPat("Villa");
            d1.setEspecialidad("Medicina Interna ");
            d1.setTelefono("556734920");
            d1.setDisponibilidad("Lunes/Miercoles/Viernes/Domingo");

            Doctor d2 = new Doctor();
            d2.setCedulaProfesional("AE010665");
            d2.setNombre("Luciana");
            d2.setApellidoPat("Rodriguez");
            d2.setEspecialidad("Cardiología");
            d2.setTelefono("558010238");
            d2.setDisponibilidad("Martes/Jueves/Sabado");

            Doctor d3 = new Doctor();
            d3.setCedulaProfesional("AE011266");
            d3.setNombre("Santiago");
            d3.setApellidoPat("Garcia");
            d3.setEspecialidad("Cirugía General");
            d3.setTelefono("5545219263");
            d3.setDisponibilidad("Martes/Mierloscles/Juves/Domingo");

            listaDoctor.add(d1);
            listaDoctor.add(d2);
            listaDoctor.add(d3);

            FileOutputStream escribir = new FileOutputStream("C:\\Users\\danie\\IdeaProjects\\ProyectoFinal1\\doctoress.txt");
            ObjectOutputStream miStream = new ObjectOutputStream(escribir);
            miStream.writeObject(listaDoctor);
            miStream.flush();
            miStream.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

