import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.Statement;

public class DataBaseConnection {

	String dataBase;
	String dbUrl = "jdbc:mysql://localhost:3306/";
	
	String userName = "aitor";
	String password = "79115136";
	
	String driver = "com.mysql.jdbc.Driver";
	
	java.sql.Connection conn = null;
	
	public DataBaseConnection(String dataBase, String dbUrl, String userName,
			String password) {
		super();
		this.dataBase = dataBase;
		this.dbUrl = dbUrl;
		this.userName = userName;
		this.password = password;
		
		this.dbUrl = this.dbUrl.concat(this.dataBase);
	}

	public DataBaseConnection(String dataBase, String userName, String password) {
		super();
		this.dataBase = dataBase;
		this.userName = userName;
		this.password = password;
		
		this.dbUrl = this.dbUrl.concat(this.dataBase);
	}

	public DataBaseConnection(String dataBase) {
		super();
		this.dataBase = dataBase;
	}
	
	public DataBaseConnection() {
		super();
	}
	
	public Connection getConnection() throws SQLException, ClassNotFoundException{
		Class.forName(driver);
		
		Properties connectionProps = new Properties();
		connectionProps.put("user", this.userName);
		connectionProps.put("password", this.password);
		
		conn = DriverManager.getConnection(dbUrl, connectionProps);
		return conn;
	}
	
}
