/*## 2. **Lista de Tareas (Java + POO)**

- **Qué practican:** clases, objetos, `ArrayList`.
- **Descripción:** Crear un programa que permita:
    - Agregar tareas pendientes (con nombre y estado: pendiente/completada).
    - Mostrar todas las tareas.
    - Marcar una tarea como completada.
- **Extras:** Guardar también la fecha límite de cada tarea. */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Proyecto_ListadeTareas {
    private static ArrayList<Tareas> Tareas = new ArrayList<>();
    private static final String ARCHIVO = "tareas.txt";
    
    //cargar los archivos 
    public static void cargarTareas(){
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO))){
            String linea; //Variable linea
            while ((linea = br.readLine())!=null){ //Seguira leyendo la siguiente hasta que sea null
                String[] datos = linea.split(","); //Split divide el texto con "," (EN linea se esta almacenando la escritura)
                if (datos.length==3) {
                    Tareas.add(new Tareas(datos[1], datos[2]));
                }
            }

        } catch (Exception e) {
            System.out.println("No se encontro ningun archivo");
        }
    }
    public static void guardarTareas(Tareas t){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO, true))){
            bw.write(t.toString()); //Introduce en el archivo como le pide toString
            bw.newLine(); //Pasa a la siguiente linea
        } catch (Exception e) {
            System.out.println("No se pudo guardar el archivo");
        }
    }
    //guardar los archivos
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        cargarTareas();
        int opcion;

        do {
            System.out.println("1. Agregar tareas");
            System.out.println("2. Mostrar todas las tareas");
            System.out.println("3. Marcar una tarea como hecha");
            System.out.println("4. Salir");

            System.out.println("Escoja una opcion");
            opcion = sc.nextInt();
            sc.nextLine();

            switch(opcion){
                case 1: 
                //Agregar tareas
                System.out.println("Nombre de la tarea");
                String nombre = sc.nextLine();

                System.out.println("Ingrese la fecha limite con el siguiente formato: (25-09-2025)");
                String fechaLimite = sc.nextLine();

                Tareas.add(new Tareas(fechaLimite, nombre)); //Se colocan los nuevos datos dentro de Tareas
                guardarTareas(new Tareas(fechaLimite, nombre)); //ejecuta guardarTareas con estos nuevos datos
                System.out.println("Tarea agregada exitosamente");
                break;

                case 2:
                //Mostrar todas las tareas
                
            }
        } while (opcion!=4);
    }
}
