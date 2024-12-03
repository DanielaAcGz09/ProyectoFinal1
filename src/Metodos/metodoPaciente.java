package Metodos;
import entidades.Paciente;
import java.io.*;
import java.util.ArrayList;

public class metodoPaciente {

    public void agregarPaciente(Paciente p) {
        //leer lista desde el archivo
        try {
            FileInputStream leer =
                    new FileInputStream("C:\\Users\\danie\\IdeaProjects\\ProyectoFinal1\\pacientes.txt");
            ObjectInputStream lectorObjetos = new ObjectInputStream(leer);
            Object o = lectorObjetos.readObject();
            ArrayList<Paciente> lista = (ArrayList<Paciente>) o;
            //Agregar Paciente
            lista.add(p);
            lectorObjetos.close();
            leer.close();
            //Escribir lista en el archivo
            FileOutputStream escribir =
                    new FileOutputStream("C:\\Users\\danie\\IdeaProjects\\ProyectoFinal1\\pacientes.txt");
            ObjectOutputStream escritorObjetos = new ObjectOutputStream(escribir);
            escritorObjetos.writeObject(lista);

            escritorObjetos.flush();
            escritorObjetos.close();
            escribir.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error al leer el archivo");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public Paciente getInfoPacientePornumeroDeSeguridadSocial(String numeroDeSeguridadSocial) throws IOException, ClassNotFoundException {
        //leer el archivo y traer la lista de pacientes
        FileInputStream leer;
        try {
            leer = new FileInputStream("C:\\Users\\danie\\IdeaProjects\\ProyectoFinal1\\pacientes.txt");
            ObjectInputStream miStream2 = new ObjectInputStream(leer);
            Object miLista = miStream2.readObject();
            ArrayList<Paciente> listaPaciente = (ArrayList<Paciente>) miLista;
            Paciente H;
            for (int i = 0; i < listaPaciente.size(); i++) {
                H = listaPaciente.get(i);
                if (numeroDeSeguridadSocial.equals(H.getNumeroDeSeguridadSocial())) {

                    leer.close();
                    return H;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void actualizarPaciente(Paciente p) {
        try {
            // Leer lista desde el archivo
            FileInputStream leer = new FileInputStream("C:\\Users\\danie\\IdeaProjects\\ProyectoFinal1\\pacientes.txt");
            ObjectInputStream lectorObjetos = new ObjectInputStream(leer);
            ArrayList<Paciente> lista = (ArrayList<Paciente>) lectorObjetos.readObject();

            // Buscar y actualizar al paciente
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getNumeroDeSeguridadSocial().equals(p.getNumeroDeSeguridadSocial())) {
                    lista.set(i, p); // Actualiza el paciente
                    break;
                }
            }

            lectorObjetos.close();
            leer.close();

            // Escribir lista actualizada en el archivo
            FileOutputStream escribir = new FileOutputStream("C:\\Users\\danie\\IdeaProjects\\ProyectoFinal1\\pacientes.txt");
            ObjectOutputStream escritorObjetos = new ObjectOutputStream(escribir);
            escritorObjetos.writeObject(lista);

            escritorObjetos.flush();
            escritorObjetos.close();
            escribir.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error al leer el archivo");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void eliminarPaciente(String numeroDeSeguridadSocial) {
        try {
            // Leer lista desde el archivo
            FileInputStream leer = new FileInputStream("C:\\Users\\danie\\IdeaProjects\\ProyectoFinal1\\pacientes.txt");
            ObjectInputStream lectorObjetos = new ObjectInputStream(leer);
            ArrayList<Paciente> lista = (ArrayList<Paciente>) lectorObjetos.readObject();

            // Buscar y eliminar al paciente
            lista.removeIf(p -> p.getNumeroDeSeguridadSocial().equals(numeroDeSeguridadSocial));

            lectorObjetos.close();
            leer.close();

            // Escribir lista actualizada en el archivo
            FileOutputStream escribir = new FileOutputStream("C:\\Users\\danie\\IdeaProjects\\ProyectoFinal1\\pacientes.txt");
            ObjectOutputStream escritorObjetos = new ObjectOutputStream(escribir);
            escritorObjetos.writeObject(lista);

            escritorObjetos.flush();
            escritorObjetos.close();
            escribir.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error al leer el archivo");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        //leer y mostrar el contenido del archivo
        final String FILE_PATH = ("C:\\Users\\danie\\IdeaProjects\\ProyectoFinal1\\pacientes.txt");
        {
            File archivo = new File(FILE_PATH);
            if (!archivo.exists()) {
                System.out.println("El archivo no existe.");
                return;
            }

            try (FileReader fr = new FileReader(archivo);
                 BufferedReader br = new BufferedReader(fr)) {

                String linea;
                System.out.println("Contenido del archivo:");
                while ((linea = br.readLine()) != null) {
                    System.out.println(linea);
                }

            } catch (IOException e) {
                throw new RuntimeException("Error al leer el archivo: " + e.getMessage(), e);
            }
        }
    }
}
