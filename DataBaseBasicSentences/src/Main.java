import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		DataBaseConnection dbConnection = new DataBaseConnection("scott");
		Connection connection = null;
		
		try {
			connection = dbConnection.getConnection();
		} catch (SQLException e) {
			System.out.println("Could not connect to the server");
			System.out.println("Error: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("Could not put the Class");
			System.out.println("Error: " + e.getMessage());
		}
		
		menu(connection);
		
	}

	private static void menu(Connection connection) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Choose an option:");
		System.out.println("1.- Open terminal");
		System.out.println("------------------");
		System.out.println("2.- Create database");
		System.out.println("3.- Modify database");
		System.out.println("4.- Drop database");
		System.out.println("------------------");
		System.out.println("5.- Insert values");
		System.out.println("6.- Update values");
		System.out.println("7.- Delete values");
		System.out.println("------------------");
		System.out.println("Others for exit");
		
		switch(keyboard.nextInt()){
		case 1:
			KeyBoardTerminal terminal = new KeyBoardTerminal(connection);
			terminal.connect();
			break;
		case 2:
			System.out.println("Inoperative in the moment");
			break;
		case 3:
			System.out.println("Inoperative in the moment");
			break;
		case 4:
			System.out.println("Inoperative in the moment");
			break;
		case 5:
			System.out.println("Inoperative in the moment");
			break;
		case 6:
			System.out.println("Inoperative in the moment");
			break;
		case 7:
			System.out.println("Inoperative in the moment");
			break;
		}
		keyboard.nextLine();
		
	}

}
