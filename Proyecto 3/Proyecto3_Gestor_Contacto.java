//Crear dos archivos
//Uno que seria la clase de contactos con: getters y setters y el metodo toString()
//Clase GestorContactos: Con un ArrayList
//Con las opciones para: Editar, eliminar y agregar contactos. Buscar nombre y salir

//--Notas de Notion--
//## 3. **Gestor de Contactos (Java POO)**

//- **Qué practican:** Programación orientada a objetos (clases, objetos, listas).
//- **Descripción:** Crear un programa que permita:
//    - Agregar un contacto (nombre, teléfono, correo).
//  - Listar contactos.
//    - Buscar contacto por nombre.
// **Extras:** Usar `ArrayList` para almacenar contactos.

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Proyecto3_Gestor_Contacto {

    private static ArrayList<Contacto> contactos = new ArrayList<>();
	private static final String ARCHIVO = "contactos.txt";

	//Cargar contactos desde el archivo
	public static void cargarContactos(){
		try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO))){
			String linea;
			while ((linea = br.readLine()) !=null){
				String[] datos = linea.split(",");
				if (datos.length==3){
					contactos.add(new Contacto(datos[0], datos[1], datos[2]));
				}
			}
		}catch (IOException e){
			System.out.println("No se encontraron contactos previos");
		}
	}

	//guardar contacto en archivo
	public static void guardarContacto(Contacto c){
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO, true))){
			bw.write(c.toString());
			bw.newLine();
		}catch (IOException e){
			System.out.println("Error al guardar le contacto: " + e.getMessage());
		}
	}


	public static void main(String arg[]){
		Scanner scanner = new Scanner(System.in);
		cargarContactos();

		int opcion;

		do{
			System.out.println("Elija una opcion\n");
			System.out.println("1. Agregar Contacto");
			System.out.println("2. Listar Contactos");
			System.out.println("3. Buscar Contacto");
			System.out.println("4. Salir");

			System.out.println("Elige una opcion");

			opcion = scanner.nextInt();
			scanner.nextLine();

			switch (opcion){
			case 1:
				System.out.println("Ingrese nombre: ");
				String nombre = scanner.nextLine();

				System.out.println("Ingrese telefono: ");
				String telefono = scanner.nextLine();

				System.out.println("Ingrese un correo: ");
				String correo = scanner.nextLine();

				Contacto nuevoContacto = new Contacto(nombre, telefono, correo);
				contactos.add(nuevoContacto);
				guardarContacto(nuevoContacto);
				System.out.println("Contacto agregado exitosamente.");

				break;

			case 2:
				System.out.println("Lista de contactos");
				if (contactos.isEmpty()){
					System.out.println("No hay contactos registrados");
				}else{
					for (Contacto c : contactos){
						System.out.println(c.mostrar());
					}
				}
				break;

			case 3:
				System.out.println("Ingrese el nombe a buscar: ");
				String buscar = scanner.nextLine();
				boolean encontrado = false;

				for (Contacto c : contactos){
					if (c.getNombre().equalsIgnoreCase(buscar)){
						System.out.println("Contacto encontrado: " + c.mostrar());
						encontrado = true;
						break;
					}

				}
				if (!encontrado){
					System.out.println("No se encontro el contacto.");
				}
				break;

			case 4:
				System.out.println("Saliendo del programa...");
				break;

			default:
				System.out.println("Opcion invalida, intente de nuevo.");
			}

		}while (opcion != 4);

		scanner.close();
	}
}