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
	
	private final String dbDriver = "com.mysql.cj.jdbc.Driver";
	
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
	public Connection getOldConnection() throws SQLException{
		this.loadDriver();
		Connection conn = null;
		Properties connectionProps = new Properties();
		connectionProps.put("user", this.userName);
		connectionProps.put("password", this.password);

		conn = DriverManager.getConnection("jdbc:mysql://"
				+ this.serverName + ":" + this.portNumber + "/wbd",
				connectionProps);

		return conn;
	}
	
	public void addNewResep(int idCokelat,String namaBahan,int jumlah) throws SQLException{
		Connection conn = getConnection();
		String query = "INSERT INTO resep (id_coklat, nama_bahan, jumlah) VALUES (?,?,?)";
		PreparedStatement preparedStmt = conn.prepareStatement(query);
		preparedStmt.setInt(1, idCokelat);
		preparedStmt.setString(2, namaBahan);
		preparedStmt.setInt(3, jumlah);
		preparedStmt.execute();
		conn.close();
		
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

	public String returnStatusAddStock(int idAddStock) throws SQLException {
		String res = "";
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		String command = "SELECT status FROM add_stock WHERE id_add_stock = " + idAddStock;
		ResultSet rs = stmt.executeQuery(command);
		if (rs.next()) {
			res = rs.getString("status");
		}
		return res;
	}
	
	public void addSaldo(int saldo) throws SQLException{
		Connection conn = getConnection();
		String command = "UPDATE saldo SET uang = uang + ?";
		PreparedStatement preparedStmt = conn.prepareStatement(command);
		preparedStmt.setInt(1, saldo);
		preparedStmt.execute();
		conn.close();
	}
	public void setSaldo( int saldo) throws SQLException {
		Connection conn = getConnection();
		String command = "UPDATE saldo SET uang =  ?";
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
	public boolean isBahanThere(int idBahan) throws SQLException {
		Connection conn = getConnection();
		String command =  "SELECT * FROM bahan WHERE id_bahan =" +idBahan+" and tanggal_kadaluwarsa = '2020-12-12'";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(command);
		if (rs.next()) {
			return true;
		} else { 
			return false;
		}
	}
	
	public void updateStockBahan(int idBahan,int jumlah) throws SQLException {
		Connection conn = getConnection();
		String command = "UPDATE bahan SET jumlah = jumlah + ? WHERE id_bahan = ? and tanggal_kadaluwarsa = '2020-12-12'";
		PreparedStatement preparedStmt = conn.prepareStatement(command);
		preparedStmt.setInt(1, jumlah);
		preparedStmt.setInt(2, idBahan);
		preparedStmt.execute();
		conn.close();
		
	}
	
	public void addBahan(int idBahan, String namaBahan,int jumlah) throws SQLException{
		Connection conn = getConnection();
		String command =  "INSERT INTO bahan (id_bahan, nama_bahan, jumlah, tanggal_kadaluwarsa) VALUES (?,?,?,?)";
		PreparedStatement preparedStmt = conn.prepareStatement(command);
		preparedStmt.setInt(1, idBahan);
		preparedStmt.setString(2, namaBahan);
		preparedStmt.setInt(3, jumlah);
		preparedStmt.setString(4, "2020-12-12");
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

	public Bahan getInfoBahan(String nama_bahan) throws SQLException {
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		String command = "SELECT * FROM bahan WHERE nama_bahan = \"" + nama_bahan + "\"";

		ResultSet rs = stmt.executeQuery(command);
		// Bahan bahan = new Bahan();
		if (rs.next()){
			Bahan bahan = new Bahan(rs.getInt("id_bahan"), rs.getString("nama_bahan"), rs.getInt("jumlah"), rs.getString("tanggal_kadaluwarsa"));
			return bahan;
		} else {
			Bahan bahan = new Bahan();
			return bahan;
		}
	}


	public int getRowAddStock() throws SQLException{
		int row = -1;
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		String count = "SELECT count(*) as total FROM add_stock";
		ResultSet ct = stmt.executeQuery(count);
		if (ct.next()) {
			row = ct.getInt("total");
		}
		
		return row;
	}
	public int getStockBahan(String nama_bahan) throws SQLException {
		int res = 0;
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		String command = "SELECT jumlah FROM bahan WHERE nama_bahan = \"" + nama_bahan + "\"";

		ResultSet rs = stmt.executeQuery(command);

		if (rs.next()) {
			res = rs.getInt("jumlah");
		}
		return res;
	}



	public void substractBahan(Bahan bahan, int substracted_bahan) throws SQLException {		
		Connection conn = getConnection();
		String command = "UPDATE bahan SET jumlah = jumlah - " + substracted_bahan + " WHERE nama_bahan = ?";
		PreparedStatement preparedStmt = conn.prepareStatement(command);
		preparedStmt.setString(1, bahan.getNama());
		preparedStmt.execute();
		conn.close();
	}


	public int countGetResep(int id_coklat) throws SQLException {
		int count = 0;
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		String command = "SELECT count(*) AS jml_resep FROM resep WHERE id_coklat = " + id_coklat;
		
		ResultSet rs = stmt.executeQuery(command);

		if (rs.next()){
			count = rs.getInt("jml_resep");
		}

		return count;

	}

	public Resep getResep(int id_coklat) throws SQLException {
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		String command = "SELECT * FROM resep WHERE id_coklat = " + id_coklat;
		
		ResultSet rs = stmt.executeQuery(command);
		
		Bahan[] arrayOfBahan = new Bahan[this.countGetResep(id_coklat)];
		int i = 0;
		while(rs.next()) {
			Bahan bahan = this.getInfoBahan(rs.getString("nama_bahan"));
			arrayOfBahan[i] = new Bahan(bahan.getIDBahan(), rs.getString("nama_bahan"), rs.getInt("jumlah"), bahan.getTanggalExp());
			i++;
		}
		Resep resep = new Resep(id_coklat, arrayOfBahan);
		return resep;
	}



	public void makeCoklat(int id_coklat, int jumlah) throws SQLException {
		boolean succ = true;
		Resep resep = this.getResep(id_coklat);
		
		for (int i = 0; i < resep.getBahan().length; i++){
			int substracted_coklat = resep.getBahan()[i].getJumlah() * jumlah;
			int stock_bahan = this.getStockBahan(resep.getBahan()[i].getNama());
			if (substracted_coklat > stock_bahan){
				succ = false;
				break;
			}
		}
				
		//jika semua bahan cukup, baru dilakukan pengurangan bahan dan penambahan coklat ke gudang
		if (succ) {
			for (int i = 0; i < resep.getBahan().length; i++){
				try {
					this.substractBahan(resep.getBahan()[i], jumlah*resep.getBahan()[i].getJumlah());
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
				
	
	public AddStock[] getAddStock() throws SQLException {
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		String command = "SELECT * FROM add_stock";
		
		
		int row = this.getRowAddStock();
		ResultSet rs = stmt.executeQuery(command);
		
		AddStock[] arrayOfaddStock = new AddStock[row];
		int i = 0;
		while(rs.next()) {
			String name = this.getChocoName(rs.getInt("id_cokelat"));
			arrayOfaddStock[i] =  new AddStock(rs.getInt("id_add_stock"),name,rs.getInt("id_cokelat"),rs.getInt("jumlah"),rs.getString("status"));
			i++;
		}
		return arrayOfaddStock;
	}
	public String getChocoName(int chocoid) throws SQLException {
		Connection conn1 = getOldConnection();
		Statement stmt1 = conn1.createStatement();
		String cmd = "SELECT name FROM product WHERE id="+chocoid;
		ResultSet rst = stmt1.executeQuery(cmd);
		rst.next();
		String nama = rst.getString("name");
		return nama;
	}
	public boolean canChangeStatus(int id) throws SQLException{
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		String command = "SELECT id_cokelat,jumlah FROM add_stock WHERE id_add_stock ="+id;
		ResultSet rs = stmt.executeQuery(command);
		int idcokelat = -1;
		int jumlah = -1;
		if(rs.next()) {
			idcokelat = rs.getInt("id_cokelat");
			jumlah = rs.getInt("jumlah");
		}
		Resep r = this.getResep(idcokelat);
		boolean canchange = true;
		Bahan[] bahan = r.getBahan();
		int i = 0;
		while (canchange && i < bahan.length) {
			Bahan bhn = bahan[i];
			canchange = this.checkBahan(bhn.getNama(), bhn.getJumlah() * jumlah);
			i ++;
		}
		return canchange;
		
		
	}
	
	public boolean checkBahan(String namabahan, int jumlah) throws SQLException{
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		String command = "SELECT * FROM bahan WHERE nama_bahan ='"+namabahan+"' and tanggal_kadaluwarsa >= CURRENT_DATE ";
		ResultSet rs = stmt.executeQuery(command);
		int total = 0;
		while(rs.next()) {
			total+= rs.getInt("jumlah");
		} 
		if (total>=jumlah) {
			return true;
		} else {
			return false;
		}
		
	}
	public int getJumlahBahan(int idcokelat) throws SQLException{
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		String command = "SELECT count(*) as total FROM resep WHERE id_coklat ="+idcokelat;
		ResultSet rs = stmt.executeQuery(command);
		if (rs.next()) {
			return rs.getInt("total");
		} else {
			return -1;
		}
		
	}

	public void removeBahanList(int id) throws SQLException {
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		String command = "SELECT id_cokelat,jumlah FROM add_stock WHERE id_add_stock ="+id;
		ResultSet rs = stmt.executeQuery(command);
		int idcokelat = -1;
		int jumlah = -1;
		if(rs.next()) {
			idcokelat = rs.getInt("id_cokelat");
			jumlah = rs.getInt("jumlah");
		}
		Resep r = this.getResep(idcokelat);
		Bahan[] bahanlist = r.getBahan();
		for(int i=0;i<bahanlist.length;i++) {
			this.removeBahan(bahanlist[i].getNama(), bahanlist[i].getJumlah() * jumlah);
		}
		
	}
	public void removeBahan(String namabahan, int jumlah) throws SQLException {
		Connection conn = getConnection();
		int[] newjumlah = this.getJumlahBahan(namabahan, jumlah);
		String[] tgl = this.getTanggal(namabahan);
		for(int i =0;i< newjumlah.length; i++){
			if (newjumlah[i] == 0) {
				String cmd = "DELETE FROM bahan where nama_bahan = ? and tanggal_kadaluwarsa = ?";
				PreparedStatement prepared = conn.prepareStatement(cmd);
				prepared.setString(1, namabahan);
				prepared.setString(2,tgl[i]);
				prepared.execute();
			}else {
				String command = "UPDATE bahan SET jumlah = ? WHERE nama_bahan = ? and tanggal_kadaluwarsa = ?";
				PreparedStatement preparedStmt = conn.prepareStatement(command);
				preparedStmt.setInt(1, newjumlah[i]);
				preparedStmt.setString(2,namabahan);
				preparedStmt.setString(3,tgl[i]);
				preparedStmt.execute();
			}
		}
		conn.close();
		
	}
	public String[] getTanggal(String namabahan) throws SQLException{
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		Statement stmt1 = conn.createStatement();
		String count = "SELECT count(*) as total FROM bahan WHERE nama_bahan ='"+namabahan+"' and tanggal_kadaluwarsa >= CURRENT_DATE";
		String command = "SELECT tanggal_kadaluwarsa FROM bahan WHERE nama_bahan ='"+namabahan+"' and tanggal_kadaluwarsa >= CURRENT_DATE";
		ResultSet rs = stmt.executeQuery(command);
		ResultSet ct = stmt1.executeQuery(count);
		ct.next();
		String[] tgl = new String[ct.getInt("total")];
		int i =0;
		while(rs.next()) {
			tgl[i] = rs.getString("tanggal_kadaluwarsa");
			i++;
		}
		return tgl;
	}
	public int[] getJumlahBahan(String namabahan,int total) throws SQLException{
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		Statement stmt1 = conn.createStatement();
		String count = "SELECT count(*) as total FROM bahan WHERE nama_bahan ='"+namabahan+"' and tanggal_kadaluwarsa >= CURRENT_DATE";
		String command = "SELECT jumlah FROM bahan WHERE nama_bahan ='"+namabahan+"' and tanggal_kadaluwarsa >= CURRENT_DATE";
		ResultSet rs = stmt.executeQuery(command);
		ResultSet ct = stmt1.executeQuery(count);
		ct.next();
		int[] newJumlah = new int[ct.getInt("total")];
		int jml = total;
		int i = 0;
		while(rs.next()) {
			int jumlah = rs.getInt("jumlah");
			if (jml == 0) {
				newJumlah[i] = jumlah;
			} else {
				if (jumlah >= jml) {
					newJumlah[i] = jumlah-jml;
					jml = 0;
				} else {
					newJumlah[i] = 0;
					jml -= jumlah;
				}
			}
			i+=1;
		}
		return newJumlah;
	}
	public void addCokelat(int addstockid) throws SQLException{
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		String command = "SELECT id_cokelat,jumlah FROM add_stock WHERE id_add_stock ="+addstockid;
		ResultSet rs = stmt.executeQuery(command);
		int idcokelat = -1;
		int jumlah = -1;
		if(rs.next()) {
			idcokelat = rs.getInt("id_cokelat");
			jumlah = rs.getInt("jumlah");
		}
		String nama = this.getChocoName(idcokelat);
		Connection conn2 = getConnection();
		if(doesCoklatExist(idcokelat)) {
			String update = "UPDATE gudang SET jumlah = jumlah+? WHERE id_coklat = ?";
			PreparedStatement preparedStmt = conn2.prepareStatement(update);
			preparedStmt.setInt(1, jumlah);
			preparedStmt.setInt(2,idcokelat);
			preparedStmt.execute();
		} else {
			String update= "INSERT INTO gudang (id_coklat, nama_coklat, jumlah) VALUES (?,?,?)";
			PreparedStatement preparedStmt = conn2.prepareStatement(update);
			preparedStmt.setInt(1, idcokelat);
			preparedStmt.setString(2, nama);
			preparedStmt.setInt(3, jumlah);
			preparedStmt.setString(4, "2020-12-12");
			preparedStmt.execute();
			
		}
		conn2.close();
	}

	public boolean doesCoklatExist(int idcoklat) throws SQLException {
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		String command = "SELECT * FROM gudang WHERE id_coklat = " +idcoklat;

		ResultSet rs = stmt.executeQuery(command);

		if(rs.next()){
			return true;
		} else {
			return false;
		}
	}

	public int countListCoklat() throws SQLException {
		int count = 0;
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		String cmd = "SELECT count(id_coklat) AS jumlah_coklat FROM gudang";
		ResultSet rs = stmt.executeQuery(cmd);
		if (rs.next()) {
			count = rs.getInt("jumlah_coklat");
		}
		return count;
	}
	
	public void addCokelatToGudang(int idcokelat,String namacokelat,int jumlah) throws SQLException{
		Connection conn = getConnection();
		String query = "INSERT INTO gudang (id_coklat, nama_coklat, jumlah) VALUES (?,?,?)";
		PreparedStatement preparedStmt = conn.prepareStatement(query);
		preparedStmt.setInt(1, idcokelat);
		preparedStmt.setString(2, namacokelat);
		preparedStmt.setInt(3, jumlah);
		preparedStmt.execute();
		conn.close();
	}

	public Gudang[] getListOfCoklat() throws SQLException{
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		String command = "SELECT * FROM gudang";
		ResultSet rs = stmt.executeQuery(command);
		Gudang[] chocs = new Gudang[this.countListCoklat()];
		int i = 0;
		while (rs.next()) {
			int id_coklat = rs.getInt("id_coklat");
			String nama_coklat = rs.getString("nama_coklat");
			int jumlah = rs.getInt("jumlah");
			Gudang choc = new Gudang(id_coklat, nama_coklat, jumlah);
			chocs[i] = choc;
			i++;
		}
		return chocs;
	}

	

	
	
}
