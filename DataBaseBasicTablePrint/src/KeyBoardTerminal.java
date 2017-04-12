import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class KeyBoardTerminal {

	Connection connection = null;

	public KeyBoardTerminal(Connection connection) {
		super();
		this.connection = connection;
	}

	public void connect() {
		String query = null;
		Scanner keyboard = new Scanner(System.in);
		ResultSet result = null;
		Statement statement = null;
		
		while(query != "exit"){
			System.out.print("> ");
			query = keyboard.nextLine();
			
			try {
				System.out.println("Creating statement...");
				statement = connection.createStatement();
			} catch (SQLException e) {
				System.out.println("Could not create the statement");
				System.out.println("Error: " + e.getMessage());
			}
			
			try {
				System.out.println("Creating query...");
				result = statement.executeQuery(query);
			} catch (SQLException e) {
				System.out.println("Could not insert the query");
				System.out.println("Error: " + e.getMessage());
			}
			
			if(query.substring(0, 6).toUpperCase().equals("SELECT")){
				try {
					System.out.println("Result:");
					printResult(result);
				} catch (SQLException e) {
					System.out.println("Could print the result");
					System.out.println("Error: " + e.getMessage());
				}
			}
			
			try {
				statement.close();
			} catch (SQLException e) {
				System.out.println("Could not close the statement");
				System.out.println("Error: " + e.getMessage());
			}
			
		}
		
	}

	private void printResult(ResultSet result) throws SQLException {
		ResultSetMetaData rsmd;
		
		rsmd = result.getMetaData();
		
		while(result.next()){
			for(int i = 1; i <= rsmd.getColumnCount(); i++){
				if(i>1) System.out.println(", ");
				System.out.println(result.getString(i) + " " + rsmd.getColumnName(i));
			}
			System.out.println("");
		}
	}
	
	
}
