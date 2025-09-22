/*
 *  El programa genera un número aleatorio entre 1 y 100 y el 
 *  usuario tiene que adivinarlo. 
 *  Le deben dar pistas como "más alto" o "más bajo".
 *  EXTRA:
 *  Contar cuántos intentos le tomó al jugador
 */

import java.util.Scanner;
import java.util.Random;

public class Proyecto1_Juego_de_Adivinanza {
    public static void main(String arg[]){
        Random random = new Random();               // Instancias de la clase Random
        Scanner scanner = new Scanner(System.in);   // Instancias de la clase Scanner
        int count = 0;

        System.out.println("Generando numero Aleatorio");
        int nroRandom = random.nextInt(100);

        System.out.println("Ingresa un numero entre 1 y 100 (includos) para adivinar el numero aleatorio:");
        
        int nro_user = scanner.nextInt();

        while (nro_user < 1 || nro_user > 100) {
            System.out.println("Numero no valido ingresa de nuevo:");
            nro_user = scanner.nextInt();
        }

       while (nroRandom != nro_user) {
            count++;
            if (nro_user > nroRandom) {
                System.out.println("Más bajo");
                nro_user = scanner.nextInt();
            }else{
                System.out.println("Más alto");
                nro_user = scanner.nextInt();
            }
       }
       
       scanner.close();
       System.out.println("Felicidades el numero es " + nroRandom);
       System.out.println("Numero de intentos: " + count);

        
    }
}