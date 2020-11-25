package factory;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "bahan")
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
	
	public String toString() {
		String ret = this.namaBahan + this.tanggalExp;
		return ret;
	}
	
	public int getIDBahan() {
		return this.idBahan;
	}
	
	public String getNama() {
		return this.namaBahan;
	}
	
	public int getJumlah() {
		return this.jumlah;
	}
	
	public String getTanggalExp() {
		return this.tanggalExp;
	}
}
