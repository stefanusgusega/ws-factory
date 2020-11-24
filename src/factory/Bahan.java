package factory;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Bahan {
	private int idBahan;
	private String namaBahan;
	private int jumlah;
	private String tanggalExp;
	
	public Bahan(int idBahan, String nama, int jumlah, String tgl) {
		this.idBahan = idBahan;
		this.namaBahan = nama;
		this.jumlah = jumlah;
		this.tanggalExp = tgl;
	}
	
}
