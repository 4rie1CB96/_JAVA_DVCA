/*
 *  Crear un programa que permita:
        Agregar tareas pendientes (con nombre y estado: pendiente/completada).
        Mostrar todas las tareas.
        Marcar una tarea como completada.
    Extras:
        Guardar también la fecha límite de cada tarea.
 */

package ProyectoExtra;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

enum Estado {
    PENDIENTE,
    COMPLETADA
}

class Tarea {
    private String nombre;
    private Estado estado;
    private String fechaLimite;

    public Tarea(String nombre, String fechaLimite) {
        this.nombre = nombre;
        this.fechaLimite = fechaLimite;
        this.estado = Estado.PENDIENTE;
    }

    public void completar() {
        this.estado = Estado.COMPLETADA;
    }

    public Estado getEstado() {
        return estado;
    }

    public void mostrarTarea(int index) {
        System.out.println("[" + index + "] " +
                "Nombre: " + this.nombre +
                " | Estado: " + this.estado +
                " | Fecha límite: " + this.fechaLimite);
    }
}

public class ProyectoExtra_2 {
    public static Scanner sc = new Scanner(System.in);
    public static ArrayList<Tarea> listaTareas = new ArrayList<>();

    public static void main(String[] args) {
        boolean flag = true;

        while (flag) {
            try {
                mostrarMenu();
                int option = sc.nextInt();
                sc.nextLine();
                limpiarPantalla();

                switch (option) {
                    case 1 -> agregarTarea();
                    case 2 -> mostrarTareas();

                    case 3 -> marcarTareaCompletada();

                    case 4 -> {
                        flag = false;
                        sc.close();
                        System.out.println("Saliendo...");
                    }
                    default -> System.out.println("Opción no válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Opción no válida. Por favor, ingrese un número.");
            }
        }

    }

    private static void mostrarMenu() {
        System.out.println("\nSeleccione una opción:");
        System.out.println("1. Agregar tareas pendientes");
        System.out.println("2. Mostrar tareas");
        System.out.println("3. Marcar tareas como completado");
        System.out.println("4. Salir");
        return;
    }

    private static void agregarTarea() {
        System.out.println("Agraga la tarea Nro " + (listaTareas.size() + 1));
        System.out.println("Ingrese el nombre de la tarea: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese la fecha límite de la tarea (dd/mm/yyyy): ");
        String fechaLimite = sc.nextLine();
        listaTareas.add(new Tarea(nombre, fechaLimite));
    }

    private static void mostrarTareas() {
        if (listaTareas.isEmpty()) {
            System.out.println("\nNo hay tareas pendientes.");
            return;
        }
        for (int i = 0; i < listaTareas.size(); i++) {
            listaTareas.get(i).mostrarTarea(i + 1);
        }
    }

    private static void marcarTareaCompletada() {
        mostrarTareas();
        System.out.print("Ingrese el número de la tarea que desea marcar como completada: ");
        int index = sc.nextInt() - 1; // el usuario ve tareas desde 1, por eso restamos 1

        if (index >= 0 && index < listaTareas.size()) {
            Tarea tarea = listaTareas.get(index);

            if (tarea.getEstado() == Estado.COMPLETADA) {
                System.out.println("⚠ La tarea ya está completada, no se puede volver a marcar.");
            } else {
                tarea.completar();
                System.out.println("✅ Tarea marcada como completada.");
            }
        } else {
            System.out.println("⚠ El número de tarea no existe.");
        }

    }

    private static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
