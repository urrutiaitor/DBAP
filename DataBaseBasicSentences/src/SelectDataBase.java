import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


public class SelectDataBase {
	
	Connection connection;

	public SelectDataBase(Connection connection) {
		super();
		this.connection = connection;
	}

	public ArrayList<String> showTables(){
		
		ResultSet result;
		
		try {
			result = connection.getMetaData().getCatalogs();
		} catch (SQLException e) {
			System.out.println("Could not get the dataBases");
			System.out.println("Error: " + e.getMessage());
			return null;
		}
		
		ArrayList<String> tableNames = new ArrayList<String>();
		
		try {
			while(result.next()){
				tableNames.add(result.getString("TABLE_CAT"));
			}
		} catch (SQLException e) {
			System.out.println("Could not get names of dataBases");
			System.out.println("Error: " + e.getMessage());
			return null;
		}
		
		return tableNames;
	}

	public void printTables(ArrayList<String> showTables) {
		for(int i = 0; i < showTables.size(); i++){
			System.out.println((i + 1) + ".- " + showTables.get(i));
		}
		System.out.println();
	}

	public String getSelectedDataBaseName(ArrayList<String> tableNames) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("> ");
		return tableNames.get(keyboard.nextInt() - 1);
	}
}
