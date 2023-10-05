
import java.io.*;
import java.util.*;

public class AddressBook {
	private Map<String, String> contactos; // HashMap para almacenar los contactos
	
	public AddressBook() {
		contactos = new HashMap<>();
	}

// Carga los contactos del archivo csv
public void load (String Contactos) {
	try {
		BufferedReader reader = new BufferedReader(new FileReader(Contactos)); //se crea BufferReader para leer el archivo
		String line;
		
		// Se lee cada linea del archivo mediante un bucle 
		while ((line = reader.readLine()) != null) {
			String[] parts = line.split(",");
			
			// Se verifica si hay dos partes que son numero y nombre
			if (parts.length == 2) {
				contactos.put(parts[0], parts[1]); // Si hay dos partes, se agregan al hashmap contactos
			}
		}
		
		reader.close(); // Se cierra el bufferReader
		
		//En caso de un error en la lectura del archivo manda un mensaje de error
	} catch (IOException e) {
		System.err.println("Error al cargar el archivo: " + e.getMessage());
	}
	
}

// Guarda los nuevos contactos en el archivo csv
public void save (String Contactos) {
	try { 
		BufferedWriter writer = new BufferedWriter(new FileWriter(Contactos)); //Se crea BufferedWriter para escribir en el archivo
		
		// Se itera a traves de cada entrada del hashmap contactos
		for (Map.Entry<String, String> entry : contactos.entrySet()) {
			writer.write(entry.getKey() + "," + entry.getValue()); // Se escribe el numero y el nombre separados por una coma
			writer.newLine();
		}
		writer.close();		// Se cierra BufferWriter despues de escribir el contacto nuevo
		
		//Crea un mensaje de error en caso de no poder guardar la informacion
	} catch (IOException e) {
		System.err.println("Error al guardar el archivo: " + e.getMessage());
	}
	
	
}

//Crea una lista de los contactos 
public void list () {
	System.out.println("Contactos: ");
	
	//Itera a traves de cada contacto en el hashmap contactos e imprime la informacion en pantalla
	for(Map.Entry<String, String> entry : contactos.entrySet()) {
		System.out.println(entry.getKey() + " : " + entry.getValue());
	}
}

//Crea un nuevo contacto al hashmap con un numero y nombre ingresados por el usuario
public void create (String numero, String nombre) {
	contactos.put(numero, nombre);
}

// Elimina un contacto segun el numero proporcionado por el usuario
public void delete (String numero) {
	contactos.remove(numero);
}

// Crea un menu
public void menu () {
	Scanner scanner = new Scanner(System.in); //Crea un objeto scanner para leer la entrada del usuario
	
	while(true) { // El loop termina hasta que el usuario escoja la opcion 4
		System.out.println("- Menu -");
		System.out.println("1- Lista de contactos");
		System.out.println("2- Crear contacto");
		System.out.println("3- Eliminar Contacto");
		System.out.println("4- Guardar y Salir");
		
		int opcion = scanner.nextInt(); // Lee la opcion del usuario
		scanner.nextLine();
		
		switch (opcion) {
		
		case 1: // Llama al metodo list
			list();
			break;
			
		case 2: // Se le pide al usuario que ingrese un numero y un nombre y se llama al metodo create
			System.out.println("Numero: ");
			String numero = scanner.nextLine();
			System.out.println("Nombre: ");
			String nombre = scanner.nextLine();
			create(numero, nombre);
			break;
		
		case 3: // Se le pide al usuario que ingrese un numero y este se elimina llamando al metodo delete
			System.out.println("Numero a Borrar :");
			String numeroEliminado = scanner.nextLine();
			delete(numeroEliminado);
			break;
		
		case 4: // Termina el bucle 
			System.out.println("Guardar y salir");
			return;
		
		default: //Si el usuario ingresa una opcion invalida manda un mensaje de error
			System.out.println("Opcion Invalida");
		}
		
	}
}
}

