public class BuuKien extends BuuPham{
    private double tien;

    public BuuKien(){
        super();
        this.tien = 5000.0;
    }

    public BuuKien(String maBuuPham, double tien){
        super(maBuuPham);
        this.tien = tien;
    }

    @Override
    public double Tinhtien() {
        return tien;
    }

    @Override
    public String loaiBuuPham() {
        return "Buu Kien";
    }
}
