package factory;

public class AddStock {
    private int id_add_stock;
    private String nama_coklat;
    private int jumlah;
    private String status;

    public AddStock(int id_add_stock, String nama_coklat, int jumlah, String status){
        this.id_add_stock = id_add_stock;
        this.nama_coklat = nama_coklat;
        this.jumlah = jumlah;
        this.status = status;
    }

    public int getIDAddStock(){
        return this.id_add_stock;
    }

    public String getNamaCoklat(){
        return this.nama_coklat;
    }

    public int getJumlah(){
        return this.jumlah;
    }

    public String getStatus(){
        return this.status;
    }

}
