package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Cette classe permer d'interagir avec la base de donnée

public class PizzaDao {
	
	private String dbUrl = "jdbc:sqlserver://localhost:1433;databaseName=PizzeriaBD";
	private String user = "sa";
	private String pwd = "Soleil123";
	
	private Connection connection;
	
	public PizzaDao() {
		try {
			connection = DriverManager.getConnection(dbUrl, user, pwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Statement getStatement() throws SQLException {
		
		return connection.createStatement();
	}
	
	public ResultSet ExecuteQuery(String request)
	{
		try {
			return this.getStatement().executeQuery(request);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
