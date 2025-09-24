package Proyecto_2;

/*
 *  Pidan al usuario ingresar las notas 
 *  de 5 materias, guárdenlas en un arreglo y 
 *  calculen: promedio, nota más alta y más baja.
 *  Extra:
 *  Decir si aprobó o reprobó (ejemplo: nota ≥ 60 = aprobado).
 */

//import java.util.Arrays;
import java.util.Scanner;

public class Proyecto2_Calculadora_de_Notas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float sum = 0, maxNote, minNote;
        byte count = 0;


        String[] materias = {
            "Matematica", 
            "Fisica", 
            "Geometria",
            "Ingles",
            "Programacion" 
        };

        float[] notas = new float[5];

        for(int i = 0; i<5 ; i++ ){
            System.out.print("Ingrese las notas de las materiarias de " + materias[i] + ": ");
            notas[i] = scanner.nextFloat();
            sum += notas[i];
            count++;
        }
        
        scanner.close();

        maxNote = notas[0];
        minNote = notas[0];
        for(int i = 1; i<5 ; i++){
            if (maxNote < notas[i] ) {
                maxNote = notas[i];
            }else if (minNote > notas[i]) {
                minNote = notas[i];
            }
        };

        float prom = sum/count;

        System.out.println("Promedio es: " + prom);
        System.out.println("Nota más alta es: " + maxNote);
        System.out.println("Nota más baja es: " + minNote);

        if (prom >= 60) {
            System.out.println("Has aprobado");
        }else{
            System.out.println("No has aprobado");
        }
    }
    
}
