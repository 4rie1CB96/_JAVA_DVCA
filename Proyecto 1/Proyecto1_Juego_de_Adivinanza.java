import java.util.Scanner;
import java.util.Random;

public class Proyecto1_Juego_de_Adivinanza {
	public static void main(String arg[]){
		Random random = new Random(); //Instancia Random
		Scanner scanner = new Scanner(System.in); //instancia scanner

		int num = 0;

		System.out.println("Generar numeros Aleatorios");
		int numRandom = random.nextInt(100);

		System.out.println("Ingrese un numero entre el 1 y el 100");

		int num_usuario = scanner.nextInt();

		//Condicional para verificar si el numero esta entre el 1 y el 100
		while (num_usuario<1 || num_usuario>100){
			System.out.println("Ingrese otro numero, este no es valido");
			num_usuario = scanner.nextInt();
		}


		//condicional para decirle al usuario si estuvo cerca o no
		while (numRandom != num_usuario){
			num++;
			if (num_usuario>numRandom){
				System.out.println("Mas bajo");
				num_usuario = scanner.nextInt();
			}else{
				System.out.println("Mas alto");
				num_usuario = scanner.nextInt();
			}
		}

		scanner.close();
		System.out.println("Felicidades, acertaste, el numero es: " + numRandom);
		System.out.println("Numero de intentos: " + num);
	}

}