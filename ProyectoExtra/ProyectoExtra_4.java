/*
 *  El usuario puede agregar eventos con nombre, fecha y hora. 
 *  El programa lista los eventos.
 *  Extras: Mostrar los eventos ordenados por fecha.
 */

package ProyectoExtra;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

class Evento {
    private String nombre;
    private LocalDate fecha;
    private LocalTime hora;

    public Evento(String nombre, LocalDate fecha, LocalTime hora) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.hora = hora;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public String toString() {
        return "Evento [nombre= " + nombre + ", fecha= " + fecha.format(DateTimeFormatter.ofPattern("E/MMM/yyyy")) + ", hora= " + hora + "]";
    }
}

public class ProyectoExtra_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Evento> eventoList = new ArrayList<>();
        LocalDate fechaEvento;
        LocalTime horaEvento;
        String nombre;

        boolean flag = true;
        while (flag) {

            try {
                menu();
                int option = sc.nextInt();
                sc.nextLine(); // limpiar buffer
                switch (option) {

                    case 1 -> {
                        System.out.println("Ingrese el nombre del evento: ");
                        nombre = sc.nextLine();

                        System.out.println("Ingrese la fecha del evento (dd/mm/aaaa)");
                        fechaEvento = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                        LocalDate fechaActual = LocalDate.now();

                        if (fechaEvento.isBefore(fechaActual)) {
                            System.out.println("Error: La fecha del evento no puede ser anterior a la fecha actual: "
                                    + fechaActual.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                        } else {
                            System.out.println("Ingrese la hora del Evento (H:m)");
                            horaEvento = LocalTime.parse(sc.nextLine(), DateTimeFormatter.ofPattern("H:m"));
                            Evento evento = new Evento(nombre, fechaEvento, horaEvento);
                            eventoList.add(evento);
                            System.out.println("Evento agregado exitosamente.");

                        }
                    }
                    case 2 -> {
                        if (eventoList.isEmpty()) {
                            System.out.println("No hay eventos para mostrar.");
                        } else {
                            System.out.println("Lista de eventos.");
                            Collections.sort(eventoList,
                                    Comparator.comparing(Evento::getFecha).thenComparing(Evento::getHora));
                            for (Evento e : eventoList) {
                                System.out.println(e.toString());
                            }
                        }
                    }

                    case 3 -> {
                        System.out.println("\nSaliendo del programa....");
                        sc.close();
                        flag = false;
                    }
                    default -> System.out.println("Error: " + "Valor no válido");
                }

            } catch (InputMismatchException e) {
                System.out.println("Error: Valor no válido");
                sc.nextLine();
            } catch (NumberFormatException e) {
                System.out.println("Error: Tipo de dato no válido");
                sc.nextLine();
            } catch (DateTimeParseException e) {
                System.out.println("Error: Formato de fecha/hora no válido");
            }
        }
    }

    private static void menu() {
        System.out.println("1. Agregar evento");
        System.out.println("2. Listar eventos");
        System.out.println("3. Salir");
    }
}