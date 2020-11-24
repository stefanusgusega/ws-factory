package factory;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name="ListBahan")
public class ListBahan {
	@XmlElementWrapper(name="ListBahan")
	@XmlElement(name="Bahan")
	private List<Bahan> listBahan;
	
	
	public ListBahan() {
		this.listBahan = new ArrayList<Bahan>();
	}
	public List<Bahan> getList() {
		return this.listBahan;
	}
	
	public void setList(List<Bahan> bahanList) {
		this.listBahan = bahanList;
	}
	
}
