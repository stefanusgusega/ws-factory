package factory;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
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
	public boolean addNewChocolate( Resep r) throws SQLException {
		boolean added = false;
		
		try {
			Bahan[] listBahan = r.getBahan();
			for(int i = 0;i < listBahan.length ; i++) {
				db.addNewResep(r.getChocoID(), listBahan[i].getNama(), listBahan[i].getJumlah());
			}
			added=true;
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
	public boolean setSaldo(int saldo) throws SQLException{
		boolean valid =false;
		try {
			db.setSaldo(saldo);
			valid = true;
		}
		catch (Exception e) {
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
	public boolean addBahan(@WebParam(name= "bahan") Bahan[] arrayBahan) throws SQLException {
		boolean valid = false;
		try {
			int i;
			for (i= 0; i<arrayBahan.length; i++) {
				if (db.isBahanThere(arrayBahan[i].getIDBahan())) {
					db.updateStockBahan(arrayBahan[i].getIDBahan(), arrayBahan[i].getJumlah());;
				} else {
					db.addBahan(arrayBahan[i].getIDBahan(), arrayBahan[i].getNama(), arrayBahan[i].getJumlah());
				}	
			}
			
			valid = true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return valid;
	}
	
	@WebMethod
	public Bahan[] getBahan() throws SQLException {
		Bahan[] result = null;
		try {
			result = db.getBahan();
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
 
	@WebMethod
	public Resep[] getResep() throws SQLException {
		Resep[] result = null;
		try {
			result = db.getAllResep();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@WebMethod
	public AddStock[] getAddStock() throws SQLException{
		AddStock[] result = null;
		try {
			result = db.getAddStock();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	@WebMethod
	public boolean canChangeStatus(int idAddStock) throws SQLException{
		boolean valid = false;
		try {
			valid = db.canChangeStatus(idAddStock);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return valid;
	}
	
	@WebMethod
	public boolean removeBahan(int idAddStock) throws SQLException{
		boolean valid = false;
		try {
			db.removeBahanList(idAddStock);
			valid = true;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return valid;
	}
	@WebMethod 
	public boolean addCoklat(int idAddStock) throws SQLException{
		boolean done = false;
		try {
			db.addCokelat(idAddStock);
			done= true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return done;
	}
	
	@WebMethod
	public Gudang[] getChocos() throws SQLException{
		Gudang[] chocos = null;
		try {
			chocos = db.getListOfCoklat();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return chocos;
	}
	
	@WebMethod 
	public boolean addGudang(int idcokelat, String nama, int jumlah) throws SQLException{
		boolean valid = false;
		try {
			db.addCokelatToGudang(idcokelat, nama, jumlah);
			valid = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return valid;
	}
	@WebMethod
	public String getAddStockStatus(int idAddStock) throws SQLException{
		String status = "";
		try {
			status = db.returnStatusAddStock(idAddStock);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	
}
