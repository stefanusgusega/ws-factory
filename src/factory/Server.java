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
	public String bonjour() throws SQLException{
//		int[] x = {2,3,4,5};
		Bahan bahan = new Bahan(21,"Testing",29,"11/24/2020");
		String html = "<h3>"+bahan.getIDBahan()+"</h3>"
					+"<h3>"+bahan.getNama()+"</h3>"
					+"<h3>"+bahan.getJumlah()+"</h3>"
					+"<h3>"+bahan.getTanggalExp()+"</h3>";
//		return bahan;
		return html;
	}
	
	@WebMethod
	public boolean addNewChocolate(Resep r) throws SQLException{
		boolean added = false;
		try {
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return added;
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
