package factory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * This class demonstrates how to connect to MySQL and run some basic commands.
 * 
 * In order to use this, you have to download the Connector/J driver and add
 * its .jar file to your build path.  You can find it here:
 * 
 * http://dev.mysql.com/downloads/connector/j/
 * 
 * You will see the following exception if it's not in your class path:
 * 
 * java.sql.SQLException: No suitable driver found for jdbc:mysql://localhost:3306/
 * 
 * To add it to your class path:
 * 1. Right click on your project
 * 2. Go to Build Path -> Add External Archives...
 * 3. Select the file mysql-connector-java-5.1.24-bin.jar
 *    NOTE: If you have a different version of the .jar file, the name may be
 *    a little different.
 *    
 * The user name and password are both "root", which should be correct if you followed
 * the advice in the MySQL tutorial. If you want to use different credentials, you can
 * change them below. 
 * 
 * You will get the following exception if the credentials are wrong:
 * 
 * java.sql.SQLException: Access denied for user 'userName'@'localhost' (using password: YES)
 * 
 * You will instead get the following exception if MySQL isn't installed, isn't
 * running, or if your serverName or portNumber are wrong:
 * 
 * java.net.ConnectException: Connection refused
 */
public class Database {

	/** The name of the MySQL account to use (or empty for anonymous) */
	private final String userName = "root";

	/** The password for the MySQL account (or empty for anonymous) */
	private final String password = "";

	/** The name of the computer running MySQL */
	private final String serverName = "localhost";

	/** The port of the MySQL server (default is 3306) */
	private final int portNumber = 3306;

	/** The name of the database we are testing with (this default is installed with MySQL) */
	private final String dbName = "factory";
	
	/** The name of the table we are testing with */
	private final String tableName = "JDBC_TEST";
	private final String dbDriver = "com.mysql.jdbc.Driver";
	
	public void loadDriver() {
		try {
			Class.forName(dbDriver);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Get a new database connection
	 * 
	 * @return
	 * @throws SQLException
	 */
	public Connection getConnection() throws SQLException {
		this.loadDriver();
		Connection conn = null;
		Properties connectionProps = new Properties();
		connectionProps.put("user", this.userName);
		connectionProps.put("password", this.password);

		conn = DriverManager.getConnection("jdbc:mysql://"
				+ this.serverName + ":" + this.portNumber + "/" + this.dbName,
				connectionProps);

		return conn;
	}
	
	// method coba-coba
	public String getName(String id) throws SQLException{
		String res = "";
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		String command = "SELECT nama_bahan from bahan WHERE id_bahan = "+id;
		ResultSet rs = stmt.executeQuery(command);
		if (rs.next()) {
			res = rs.getString("nama_bahan");
		}
//		res = rs.getString("Name");
		return res;
	}
	
	public void insertToAddStock(int chocId, int amount, String status) throws SQLException {
		Connection conn = getConnection();
		String query = "INSERT INTO add_stock (id_cokelat, jumlah, status) VALUES (?,?,?)";
		PreparedStatement preparedStmt = conn.prepareStatement(query);
		preparedStmt.setInt(1, chocId);
		preparedStmt.setInt(2, amount);
		preparedStmt.setString(3, status);
		preparedStmt.execute();
		conn.close();
			
	}
	public boolean login(String email,String password) throws SQLException{
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		String command = "SELECT * FROM user WHERE email ='"+email+"' and password = '"+password +"'";
		ResultSet rs = stmt.executeQuery(command);
		if (rs.next()) {
			return true;
		} else {
			return false;
		}
	}
	public void changeStatusAddStock(int idAddStock) throws SQLException {
		Connection conn = getConnection();
		String command = "UPDATE add_stock SET status = 'delivered' WHERE id_add_stock = ?";
		PreparedStatement preparedStmt = conn.prepareStatement(command);
		preparedStmt.setInt(1, idAddStock);
		preparedStmt.execute();
		conn.close();
	}

	public void returnStatusAddStock(int idAddStock) throws SQLException {
		Connection conn = getConnection();
		String command = "SELECT status FROM add_stock WHERE id_add_stock = ?";
		PreparedStatement preparedStmt = conn.prepareStatement(command);
		preparedStmt.setInt(1, idAddStock);
		preparedStmt.execute();
		conn.close();
	}
	
	public void addSaldo(int saldo) throws SQLException{
		Connection conn = getConnection();
		String command = "UPDATE saldo SET uang = uang + ?";
		PreparedStatement preparedStmt = conn.prepareStatement(command);
		preparedStmt.setInt(1, saldo);
		preparedStmt.execute();
		conn.close();
	}
	
	public int getSaldo()throws SQLException{
		int res = 0;
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		String command = "SELECT uang FROM saldo";
		ResultSet rs = stmt.executeQuery(command);
		if (rs.next()) {
			res = rs.getInt("uang");
		}
		return res;
		
	}
	
	public void addBahan(int idBahan, String namaBahan,int jumlah) throws SQLException{
		Connection conn = getConnection();
		String command =  "INSERT INTO bahan (id_bahan, nama_bahan, jumlah, tanggal_kadaluwarsa) VALUES (?,?,?,?)";
		PreparedStatement preparedStmt = conn.prepareStatement(command);
		preparedStmt.setInt(1, idBahan);
		preparedStmt.setString(2, namaBahan);
		preparedStmt.setInt(3, jumlah);
		preparedStmt.setString(4, "2020-02-02");
		preparedStmt.execute();
		conn.close();
	}
	
	public int getRowBahan() throws SQLException{
		int row = -1;
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		String count = "SELECT count(*) as total FROM bahan";
		ResultSet ct = stmt.executeQuery(count);
		if (ct.next()) {
			row = ct.getInt("total");
		}
		
		return row;
	}
	public Bahan[] getBahan() throws SQLException {
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		String command = "SELECT * FROM bahan";
		
		
		int row = this.getRowBahan();
		ResultSet rs = stmt.executeQuery(command);
		
		Bahan[ ] arrayOfBahan = new Bahan[row];
		int i = 0;
		while(rs.next()) {
			arrayOfBahan[i] =  new Bahan(rs.getInt("id_bahan"),rs.getString("nama_bahan"),rs.getInt("jumlah"),rs.getString("tanggal_kadaluwarsa"));
			
			i++;
		}
		return arrayOfBahan;
	}
	
	/**
	 * method coba2
	 * Run a SQL command which does not return a recordset:
	 * CREATE/INSERT/UPDATE/DELETE/DROP/etc.
	 * 
	 * @throws SQLException If something goes wrong
	 */
	public boolean executeUpdate(Connection conn, String command) throws SQLException {
	    Statement stmt = null;
	    try {
	        stmt = conn.createStatement();
	        stmt.executeUpdate(command); // This will throw a SQLException if it fails
	        return true;
	    } finally {

	    	// This will run whether we throw an exception or not
	        if (stmt != null) { stmt.close(); }
	    }
	}
	
	/**
	 * method coba2
	 * Connect to MySQL and do some stuff.
	 */
	public void run() {

		// Connect to MySQL
		Connection conn = null;
		try {
			conn = this.getConnection();
			System.out.println("Connected to database");
		} catch (SQLException e) {
			System.out.println("ERROR: Could not connect to the database");
			e.printStackTrace();
			return;
		}

		// Create a table
		try {
		    String createString =
			        "CREATE TABLE " + this.tableName + " ( " +
			        "ID INTEGER NOT NULL, " +
			        "NAME varchar(40) NOT NULL, " +
			        "STREET varchar(40) NOT NULL, " +
			        "CITY varchar(20) NOT NULL, " +
			        "STATE char(2) NOT NULL, " +
			        "ZIP char(5), " +
			        "PRIMARY KEY (ID))";
			this.executeUpdate(conn, createString);
			System.out.println("Created a table");
	    } catch (SQLException e) {
			System.out.println("ERROR: Could not create the table");
			e.printStackTrace();
			return;
		}
		
		// Drop the table
		try {
		    String dropString = "DROP TABLE " + this.tableName;
			this.executeUpdate(conn, dropString);
			System.out.println("Dropped the table");
	    } catch (SQLException e) {
			System.out.println("ERROR: Could not drop the table");
			e.printStackTrace();
			return;
		}
	}
	
	
}
