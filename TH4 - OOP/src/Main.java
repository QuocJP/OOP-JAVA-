
public class Main {
    public static void main(String[] args) {
        SinhVien sv1 = new SinhVien(); SinhVien sv2 = new SinhVien(); SinhVien sv3 = new SinhVien();
        sv1.setHoTen("Nguyen Van A");
        sv1.setNgaySinh(LocalDate.of(2007, 10, 10));
        sv1.setdTB(8.6f);
        sv2.setHoTen("Nguyen Van B");
        sv2.setNgaySinh(LocalDate.of(2007, 07, 07));
        sv2.setdTB(6.5f);
        sv3.setHoTen("Nguyen Van C");
        sv3.setNgaySinh(LocalDate.of(2009, 09, 09));
        sv3.setdTB(5.5f);
        QuanLySinhVien list = new QuanLySinhVien(5);
        list.Them(sv1);
        list.Them(sv2);
        list.Them(sv3);
        list.lietke();
        System.out.println("---------------------");
        System.out.println("Diem trung binh cua cac hoc sinh: " + list.TinhTuoiTB());
        System.out.println("---------------------");
        list.sapxep();
        list.lietke();
        System.out.println("---------------------");
        list.lietke("B");
        System.out.println("---------------------");
        list.xoaTen("C");
        list.lietke();
    }
}
