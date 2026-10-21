

public class Main {
    public static void main(String[] args){
        DiemHP Hp1 = new HPLyThuyet("Toan Roi Rac", 3, 7, 7, 7);
        DiemHP Hp2 = new HPThucHanh("Lap Rap May Tinh", 1, 10, 9, 10);
        SinhVien sv1 = new SinhVien("Tu Minh Duc", Hp1, Hp2);
        QuanLySinhVien list = new QuanLySinhVien(3);
        list.Them(sv1);
        list.lietKe();
    }
}
