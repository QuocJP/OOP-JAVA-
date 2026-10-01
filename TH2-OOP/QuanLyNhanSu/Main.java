package Thuchanh2.QuanLyNhanSu;
import java.time.LocalDate;
public class Main {
    public static void main(String[] arggs){
        QuanLyNhanSu[] a = new QuanLyNhanSu[5];
        a[0] = new GiamDoc("Nguyen Van A ", LocalDate.of(1999, 1, 1), " Giam Doc ", 1f, 100000000f);
        a[1] = new PhoGiamDoc("Nguyen Thi B ", LocalDate.of(1969, 2, 1), " Pho Giam Doc ", 0.8f, 50000000f);
        a[2] = new TruongPhong("Do Thi C ", LocalDate.of(1972, 1, 2), " Truong Phong ", 0.6f, 25000000f);
        a[3] = new PhoPhong("To Van D ", LocalDate.of(1979, 4, 3), " Pho Phong ", 0.5f, 12500000f);
        a[4] = new PhoPhong("Tran Van E ", LocalDate.of(2000, 6, 30), " Pho Phong ", 0.5f, 12500000f);
        for(int i = 0; i < 5; i++){
            System.out.println(a[i].toString() + "Bao hiem xa hoi: " + a[i].baohiemxahoi() + " Bao hiem that nghiep: " + a[i].baohiemthatnghiep());
        }
        double tong = 0;
        for(int i = 0; i < 5; i++){
            tong = tong + a[i].tienluong();
        }
        System.out.println("Tong tien luong nhan vien: " + tong);
        QuanLyNhanSu b = a[0];
        for(int i = 1; i < 5; i++){
            if(a[i].sosanhtuoi(b))
                b = a[i];
        }
        System.out.println("Nhan vien co tuoi lon nhat: " + b.gethoten() + " Ngay sinh: " + b.getngaysinh());
        double tb = tong / 5;
        System.out.println("Tien luong trung binh cua nhan vien: " + tb);
    }
}