import java.util.Scanner;

public class Proyecto_MonedaConversor{
	public static void main(String arg[]){
		Scanner sc = new Scanner(System.in);

		int opcion;

		double tasaGuaranies = 7117;
		double tasaEuro = 8359;
		double tasaPesos = 5.28;

		System.out.println("Ingrese el monto en dolares");
		double dolares = sc.nextDouble();

		do{

			System.out.println("Elija la moneda a corregir");
			System.out.println("1. Guaranies");
			System.out.println("2. Euros");
			System.out.println("3. Pesos (Argentinos)");
			System.out.println("4. Salir");

			opcion = sc.nextInt();
			
			switch(opcion){
			case 1:
				System.out.println("Monto en guaranies: " + (dolares * tasaGuaranies) + " PYG");
				break;
			case 2:
				System.out.println("Monto en Euros: " + (dolares * tasaEuro) + " EUR");
				break;
			case 3:
				System.out.println("Monto en pesos: " + (dolares * tasaPesos) + " ARS");
				break;
			default:
				System.out.println("Opcion invalida");
			}
		}while (opcion != 4);

		sc.close();
	}
}