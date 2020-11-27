package factory;

public class Gudang {
    private int id_coklat;
    private String nama_coklat;
    private int jumlah;

    public Gudang(int id_coklat, String nama_coklat, int jumlah){
        this.id_coklat = id_coklat;
        this.nama_coklat = nama_coklat;
        this.jumlah = jumlah;
    }

    public int getIDCoklat(){
        return this.id_coklat;
    }

    public String nama_coklat(){
        return this.nama_coklat;
    }

    public int jumlah(){
        return this.jumlah;
    }
    
}
