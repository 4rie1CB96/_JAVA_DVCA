/*
 *  El usuario puede agregar eventos con nombre, fecha y hora. 
 *  El programa lista los eventos.
 *  Extras: Mostrar los eventos ordenados por fecha.
 */

package ProyectoExtra;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

class Evento {
    private String nombre;
    private String fecha;
    private String hora;

    public Evento(String nombre, String fecha, String hora) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.hora = hora;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public String toString() {
        return "Evento [nombre=" + nombre + ", fecha=" + fecha + ", hora=" + hora + "]";
    }
}

public class ProyectoExtra_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Evento> eventoList = new ArrayList<>();
        String nombre, fecha, hora;
        String[] arrayDate = new String[3];
        String[] arrayTime = new String[2];

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
                        fecha = sc.nextLine();
                        arrayDate = fecha.split("/");

                        // convertir
                        int dia = Integer.parseInt(arrayDate[0]);
                        int mes = Integer.parseInt(arrayDate[1]);
                        int anio = Integer.parseInt(arrayDate[2]);

                        LocalDate fechaEvento = LocalDate.of(anio, mes, dia);
                        LocalDate fechaActual = LocalDate.now();
                        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                        if (fechaEvento.isBefore(fechaActual)) {
                            System.out.println("Error: La fecha del evento no puede ser anterior a la fecha actual: "
                                    + fechaActual.format(formato));
                        } else {
                            System.out.println("Ingrese la hora del Evento (hh:mm)");
                            hora = sc.nextLine();

                            arrayTime = hora.split(":");

                            int horaEvento = Integer.parseInt(arrayTime[0]);
                            int minutoEvento = Integer.parseInt(arrayTime[1]);

                            if (horaEvento < 0 || horaEvento > 23 || minutoEvento < 0 || minutoEvento > 59) {
                                System.out.println("Error: La hora ingresada no es válida.");
                            } else {
                                Evento evento = new Evento(nombre, fecha, hora);
                                eventoList.add(evento);
                                System.out.println("Evento agregado exitosamente.");
                            }
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
                                System.out.println(e);
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
                // continue;
            } catch (NumberFormatException e) {
                System.out.println("Error: Tipo de dato no válido");
                sc.nextLine();
                // continue;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Error: Fecha u hora no válida");
                sc.nextLine();
                // continue;
            }
        }
    }

    private static void menu() {
        System.out.println("1. Agregar evento");
        System.out.println("2. Listar eventos");
        System.out.println("3. Salir");
    }
}