package factory;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


@XmlType(name = "resep")
@XmlAccessorType(XmlAccessType.FIELD)
public class Resep {
	private int chocoID;
	private int[] bahanList;
		
	public Resep() {};
	public Resep(int chocoID, int[] bahanList) {
		this.chocoID = chocoID;
		this.bahanList = bahanList;
	}
	
	public int getChocoID() {
		return this.chocoID;
	}
	
	public int[] getBahan() {
		return this.bahanList;
	}
}
