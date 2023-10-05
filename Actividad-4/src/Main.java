
public class Main{
	public static void main(String[] args) {
		AddressBook addressBook = new AddressBook(); // Crea una instancia de la clase AdressBook 
		addressBook.load("Contactos.csv"); // Carga los contactos del archivo Contactos.csv
		addressBook.menu(); // Inicia el menu
		addressBook.save("Contactos.csv"); // Guarda los contactos creados en el archivo Contactos.csv
	}
}
