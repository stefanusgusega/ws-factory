package factory;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


@XmlType(name = "resep")
@XmlAccessorType(XmlAccessType.FIELD)
public class Resep {
	private int chocoID;
	private Bahan[] bahan;
	
	public Resep(int chocoID, Bahan[] bahan) {
		this.chocoID = chocoID;
		this.bahan = bahan;
	}
	
	public int getChocoID() {
		return this.chocoID;
	}
	
	public Bahan[] getBahan() {
		return this.bahan;
	}
}
