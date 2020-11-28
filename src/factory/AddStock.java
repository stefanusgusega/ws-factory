package factory;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "addstock")
@XmlAccessorType(XmlAccessType.FIELD)
public class AddStock {
	public int addStockID;
	public int chocoID;
	public int jumlah;
	public String status;
	
	public AddStock() {};
	
	public AddStock(int addstockid, int chocoid, int jumlah, String stat) {
		this.addStockID = addstockid;
		this.chocoID = chocoid;
		this.jumlah = jumlah;
		this.status = stat;
	}
	public int getaddStockID() {
		return this.addStockID;
	}
	public int getchocoID() {
		return this.chocoID;
	}
	public int getJumlah() {
		return this.jumlah;
	}
	public String getStatus() {
		return this.status;
	}
	
	
}
