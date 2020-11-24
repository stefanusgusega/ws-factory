package factory;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import java.sql.SQLException;

@WebService
@SOAPBinding(style = Style.RPC)
public class Server {
	
	private Database db = new Database();
	
	// ini cuma contoh
	@WebMethod
	public String bonjour(String id) throws SQLException{
		String res = "";
		try {
			res = db.getName(id);
			return res;
		}
		catch (Exception e) {
			return "Errornya di bonjour: "+e.toString();
		}
	}
	
	@WebMethod
	public void addNewChocolate() {
		
	}
	
	@WebMethod
	public boolean insertNewAddStockRequest(int chocId, int amountChoc) throws SQLException {
		boolean inserted = false;
		try {
			db.insertToAddStock(chocId, amountChoc, "pending");
			inserted = true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return inserted;
	}
	
	@WebMethod
	public boolean login(String email, String password) throws SQLException {
		boolean valid = false;
		try {
			valid = db.login(email,password);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return valid;
		
	}
	@WebMethod
	public boolean changeStatusAddStock(int idAddStock) throws SQLException {
		boolean valid = false;
		
		try {
			db.changeStatusAddStock(idAddStock);
			valid = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return valid;
	}
	
	@WebMethod
	public boolean addSaldo(int saldo) throws SQLException{
		boolean valid = false;
		try {
			db.addSaldo(saldo);
			valid = true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return valid;
	}
	
	@WebMethod
	public int getSaldo() throws SQLException{
		int saldo = -1;
		try {
			saldo = db.getSaldo();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return saldo;
	}
	@WebMethod
	public boolean addBahan(int idBahan, String namaBahan,int jumlah) throws SQLException {
		boolean valid = false;
		try {
			int i;
//			for (i= 0; i< idBahan.length; i++) {
				db.addBahan(idBahan, namaBahan, jumlah);
					
//			}
			
			valid = true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return valid;
	}
	
	@WebMethod
	public Bahan[] getBahan() {
		Bahan[] result = null;
		try {
			result = db.getBahan();
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
