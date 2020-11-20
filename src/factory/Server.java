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
	public boolean insertNewAddStockRequest(String chocName, int amountChoc) throws SQLException {
		boolean inserted = false;
		try {
			db.insertToAddStock(chocName, amountChoc, "pending");
			inserted = true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return inserted;
	}
	
}
