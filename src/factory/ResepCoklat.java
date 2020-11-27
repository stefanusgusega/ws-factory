package factory;

public class ResepCoklat {
    private int id_coklat;
    private String nama_bahan;
    private int jml_bahan;

    public ResepCoklat(){}

    public ResepCoklat(int id_coklat, String nama_bahan, int jml_bahan) {
        this.id_coklat=id_coklat;
        this.nama_bahan=nama_bahan;
        this.jml_bahan=jml_bahan;
    }
    public int getIDCoklat(){
        return this.id_coklat;
    }

    public String getNamaBahan(){
        return this.nama_bahan;
    }

    public int getJmlBahan(){
        return this.jml_bahan;
    }
}
