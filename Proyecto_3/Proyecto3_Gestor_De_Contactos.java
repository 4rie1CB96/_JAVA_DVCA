package Proyecto_3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter; // Importa la clase FileWriter para escribir en archivos
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.IOException; // Importa la clase IOException para manejar excepciones de entrada/salida
// import java.io.FileNotFoundException; // Importa la clase FileNotFoundException para manejar excepciones de archivo no encontrado

class Contacto {
    String nombre;
    String apellido;
    String telefono;

    public Contacto(String nombre, String apellido, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    public void mostrarContacto() {
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Apellido: " + this.apellido);
        System.out.println("Teléfono: " + this.telefono);
    }

    public String toString() {
        return "Nombre: " + this.nombre + "\n" + "Apellido: " + this.apellido + "\n" + "Teléfono: " + this.telefono;
    }
}

public class Proyecto3_Gestor_De_Contactos {
    public static void main(String[] args) {

        ArrayList<Contacto> Contactolist = new ArrayList();
        Scanner sc = new Scanner(System.in);
        boolean control = true;

        String PATH = "./Proyecto_3/Contactos.txt";

        while (control) {
            try (BufferedReader reader = new BufferedReader(new FileReader(PATH))) {

                System.out.println("1. Agregar contacto");
                System.out.println("2. Mostrar contactos");
                System.out.println("3. Buscar Contacto");
                System.out.println("4. Salir");

                int opcion = sc.nextInt();
                sc.nextLine();

                if (opcion < 1 || opcion > 4) {
                    System.out.println("\nOpción no válida. Por favor, elija una opción del 1 al 4.");
                    continue;
                }
                int length = Contactolist.size();
                switch (opcion) {
                    case 1:
                        String nombre;
                        String apellido;
                        String telefono;

                        System.out.println("\nIngrese el nombre: ");
                        nombre = sc.nextLine();
                        System.out.println("Ingrese el apellido: ");
                        apellido = sc.nextLine();
                        System.out.println("Ingrese el teléfono: ");
                        telefono = sc.nextLine();

                        Contacto newContacto = new Contacto(nombre, apellido, telefono);
                        Contactolist.add(newContacto);
                        break;
                    case 2:
                        if (Contactolist.isEmpty()) {
                            System.out.println("\nNo hay contactos recien agregados.\n");
                        } else {
                            System.out.println("\nContactos recien agregados:\n");
                            for (int i = 0; i < length; i++) {
                                Contactolist.get(i).mostrarContacto();
                                System.out.println("-----");
                            }
                        }
                        if (reader.ready()) {
                            String line;
                            boolean hayContactos = false;
                            System.out.println("\nContactos ya existentes en el archivo:\n");
                            while ((line = reader.readLine()) != null) {
                                hayContactos = true;
                                System.out.println(line);
                            }

                            if (!hayContactos) {
                                System.out.println("No hay contactos existentes en el archivo.\n");
                            }

                        }
                        break;
                    case 3:
                        System.out.println("\nIngrese el nombre a ser buscado: ");
                        String nameSeach = sc.nextLine();
                        System.out.println("\nResultados de la búsqueda:\n");
                        for (int i = 0; i < length; i++) {
                            String validName = Contactolist.get(i).nombre.toUpperCase().trim();
                            if (validName.equals(nameSeach.toUpperCase().trim())) {
                                Contactolist.get(i).mostrarContacto();
                            }
                        }
                        break;
                    case 4:
                        control = false;
                        sc.close();
                        try (FileWriter writer = new FileWriter(PATH, true)) {
                            for (int i = 0; i < length; i++) {
                                writer.write(Contactolist.get(i).toString() + "\n-----\n");
                            }
                        }
                        System.out.println("\nSaliendo del programa. Los contactos han sido guardados en " + PATH);
                        break;
                    default:
                        break;
                }
            } catch (IOException e) {
                System.out.println("\nOcurrió un error al escribir en el archivo: " + e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("\nPor favor ingrese un numero valido");
                sc.nextLine();
            }
        }

    }
}
