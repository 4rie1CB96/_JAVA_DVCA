// 2. **Calculadora de Notas (Java + lógica)**

//Qué practican:** arreglos, ciclos, funciones.
//**Descripción:** Pidan al usuario ingresar las notas de 5 materias, guárdenlas en un arreglo y calculen: promedio, nota más alta y más baja.
//**Extras:** Decir si aprobó o reprobó (ejemplo: nota ≥ 60 = aprobado).

import java.util.Scanner;

public class Proyecto2_Calc_Notas {
	public static void main(String arg[]){

		//Declarar variables
		Scanner scanner = new Scanner(System.in);

		double[] notas = new double[5];
		double suma = 0;
		double mayor, menor;

		//Pedimos las notas
		for (int i=0; i<notas.length; i++){
			System.out.println("Ingrese la nota de la materia " + (i+1) + ": ");
			notas[i]=scanner.nextDouble();
			suma += notas[i];
		}

		//iniciar mayor y menor
		mayor = notas[0];
		menor = notas[0];

		//buscamos el mayor y el menor
		for (int i=1; i<notas.length; i++){
			if (notas[i]>mayor){
				mayor=notas[i];
			}else{
				menor=notas[i];
			}
		}

		//Calcular promedio
		double promedio = suma/notas.length;


		//imprimir
		System.out.println("Resultados \n");
		System.out.println("Promedio: " + promedio);
		System.out.println("Nota mas alta: " + mayor);
		System.out.println("Nota mas baja: " + menor);


		//Aprobado o reprobado

		if (promedio>=6){
			System.out.println("Estado: Aprobado");
		}else{
			System.out.println("Estado: Repobrado");
		}

		scanner.close();

	}
}