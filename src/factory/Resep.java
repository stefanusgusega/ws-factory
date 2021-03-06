package factory;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


@XmlType(name = "resep")
@XmlAccessorType(XmlAccessType.FIELD)
public class Resep {
	private int chocoID;
	private Bahan[] bahanList;
		
	public Resep() {};
	public Resep(int chocoID, Bahan[] bahanList) {
		this.chocoID = chocoID;
		this.bahanList = bahanList;
	}
	
	public int getChocoID() {
		return this.chocoID;
	}
	
	public Bahan[] getBahan() {
		return this.bahanList;
	}
}
