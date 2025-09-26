/*## 4. **Mini Agenda de Eventos (Java + fechas)**

- **Qué practican:** `ArrayList`, manipulación de cadenas, fechas con `LocalDate`.
- **Descripción:** El usuario puede agregar eventos con nombre, fecha y hora. El programa lista los eventos.
- **Extras:** Mostrar los eventos ordenados por fecha.*/

import java.time.LocalDate;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Proyecto_Agenda {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Agenda> agendas = new ArrayList<>();

        int opcion;

        do { 
            System.out.println("1. Agregar evento");
            System.out.println("2. Listar eventos");
            System.out.println("3. Salir");
            System.out.println("Elija una opcion");

            opcion = sc.nextInt();
            sc.nextLine(); //limpiar burffer

            switch(opcion){
                case 1:
                System.out.println("Ingrese el nombre del evento");
                String nombre = sc.nextLine();
                System.out.println("Ingrese la fecha del evento (YYYY-MM-DD)");
                LocalDate fecha = LocalDate.parse(sc.nextLine());
                System.out.println("Ingrese la hora del evento (HHMM)");
                int hora = Integer.parseInt(sc.nextLine());
                Agenda evento = new Agenda(fecha, hora, nombre);
                agendas.add(evento);
                System.out.println("Evento agregado exitosamente");

                break;

                case 2:
                if (agendas.isEmpty()){
                    System.out.println("No hay eventos");
                }else{
                    Collections.sort(agendas, Comparator.comparing(Agenda::getFechas).thenComparing(Agenda::getHora));
                    System.out.println("Lista de eventos:");
                    for (Agenda a : agendas){
                        System.out.println("" + a.toString());
                    }
                }
                break;

                case 3:
                System.out.println("Saliendo...");
                break;

                default:
                System.out.println("Opcion no valida");
                break;
            }
        } while (opcion !=3);
        sc.close();
    }
}