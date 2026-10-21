

public class Main {
    public static void main(String[] args){
        DiemHP Hp1 = new HPLyThuyet("Toan", 3, 5, 7, 9);
        DiemHP Hp2 = new HPThucHanh("Van", 1, 2, 4, 10);
        SinhVien sv1 = new SinhVien("Nguyen Van A", Hp1, Hp2);
        QuanLySinhVien list = new QuanLySinhVien(3);
        list.Them(sv1);
        list.lietKe();
    }
}
