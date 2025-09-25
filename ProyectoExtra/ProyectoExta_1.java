/*
 *  El usuario ingresa un monto en dólares y el programa lo convierte a 
 *  guaraníes, euros o pesos (elige la moneda).
 *  Extras: Usar un switch para elegir la moneda.
 */

package ProyectoExtra;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ProyectoExta_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;

        final float guarani = 6970,
                euro = 0.85f,
                peso = 1337.49f;

        while (flag) {
            try {
                System.out.println("Ingrese el tipo de moneda a se convertido su dolar: ");
                String typeMoney = sc.next();
                float moneyUser;

                switch (typeMoney) {
                    case "guarani":
                        System.out.println("Ingrese el monto en dolares a convertir: ");
                        moneyUser = sc.nextFloat();
                        System.out.println("El valor en " + typeMoney + " es: " + moneyUser * guarani + " Gs.");
                        System.out.println(
                                "Ingrese la palabra 'salir' para finalizar el programa o cualquier otra tecla para continuar.");
                        break;
                    case "euro":
                        System.out.println("Ingrese el monto en dolares a convertir: ");
                        moneyUser = sc.nextFloat();
                        System.out.println("El valor en " + typeMoney + " es: " + moneyUser * euro + " €");
                        System.out.println(
                                "Ingrese la palabra 'salir' para finalizar el programa o cualquier otra tecla para continuar.");

                        break;
                    case "peso":
                        System.out.println("Ingrese el monto en dolares a convertir: ");
                        moneyUser = sc.nextFloat();
                        System.out.println("El valor en " + typeMoney + " es: " + moneyUser * peso + " $");
                        System.out.println(
                                "Ingrese la palabra 'salir' para finalizar el programa o cualquier otra tecla para continuar.");
                        break;
                    case "salir":
                        flag = false;
                        sc.close();
                        break;
                    default:
                        System.out.println("Moneda no valida.");
                        break;
                }
                System.out.println("Gracias por usar el conversor de monedas.");

            } catch (InputMismatchException e) {
                System.out.println("Ingrese un monto valido porfavor.");
                sc.next(); // Limpiar el buffer
            }
        }
    }
}