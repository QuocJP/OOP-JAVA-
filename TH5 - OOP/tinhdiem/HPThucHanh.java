package Thuchanh5.TinhDiemHP.Entities;

public class HPThucHanh extends DiemHP{
    private int db1, db2, db3;
    public HPThucHanh(){
        super();
    }
    public HPThucHanh(String tenHP, int soTinChi, int db1, int db2, int db3){
        super(tenHP, soTinChi);
        this.db1 = db1;
        this.db2 = db2;
        this.db3 = db3;
    }
    @Override
    public double tinhDiem() {
        return (db1 + db2 + db3)/3.0;
    }
}
