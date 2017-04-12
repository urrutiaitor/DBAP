import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		DataBaseConnection dbConnection = new DataBaseConnection();
		Connection connection = null;
		
		try {
			connection = dbConnection.getConnection();
		} catch (SQLException e) {
			System.out.println("Could not connect to the server");
			System.out.println("Error: " + e.getMessage());
			return;
		} catch (ClassNotFoundException e) {
			System.out.println("Could not put the Class");
			System.out.println("Error: " + e.getMessage());
		}
		
		menu(connection);
		
	}

	private static void menu(Connection connection) {
		Scanner keyboard = new Scanner(System.in);
		String selDataBaseName;
		
		System.out.println("Choose an option:");
		System.out.println("1.- Open terminal");
		System.out.println("------------------");
		System.out.println("2.- Select database");
		System.out.println("3.- Create database");
		System.out.println("4.- Modify database");
		System.out.println("5.- Drop database");
		System.out.println("------------------");
		System.out.println("6.- Insert values");
		System.out.println("7.- Update values");
		System.out.println("8.- Delete values");
		System.out.println("------------------");
		System.out.println("Others for exit");
		System.out.println("------------------");
		System.out.println();
		System.out.print("> ");
		
		switch(keyboard.nextInt()){
		case 1:
			KeyBoardTerminal terminal = new KeyBoardTerminal(connection);
			terminal.connect();
			break;
		case 2:
			SelectDataBase selection = new SelectDataBase(connection);
			ArrayList<String> tableNames = selection.showTables();
			selection.printTables(tableNames);
			selDataBaseName = selection.getSelectedDataBaseName(tableNames);
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
		case 8:
			System.out.println("Inoperative in the moment");
			break;
		}
		keyboard.nextLine();
		
	}

}
