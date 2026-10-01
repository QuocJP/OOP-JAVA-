package Thuchanh2.PhanSo;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PhanSo ps1 = new PhanSo();

        System.out.println("Nhap tu so va mau so dau tien: ");
        ps1.ganTu(sc.nextInt());
        ps1.ganMau(sc.nextInt());
        ps1.HienThi();

        System.out.println("Nhap tu so va mau so thu hai");
        PhanSo p = new PhanSo();
        p.ganTu(sc.nextInt());
        p.ganMau(sc.nextInt());
        p.HienThi();

        System.out.println("Ket qua sau khi cong: ");
        PhanSo r = ps1.cong(p);
        r.HienThi();

        System.out.println("Ket qua sau khi tinh toan: ");
        PhanSo Ps1nhan2 = ps1.nhan(2);
        PhanSo Ps2chiap = ps1.chia(p);
        PhanSo t = Ps1nhan2.tru(Ps2chiap);
        t.HienThi();
        
        int x = ps1.soSanh(p);
        if(x == 1){
            System.out.println("ps1 lon hon p");
        }if(x == 0){
            System.out.println("Hai phan so bang nhau");
        }if(x == -1){
            System.out.println("p lon hon ps1");
        }

        PhanSo a[] = new PhanSo[5];
        System.out.println("Nhap cac phan so: ");
        for(int i = 0; i < 5; i++){
            a[i] = new PhanSo();
            System.out.println("Phan so " + (i + 1) + ": ");
            a[i].ganTu(sc.nextInt());
            a[i].ganMau(sc.nextInt());
        }
        
        for(int i = 0; i < 5; i++){
            a[i].HienThi();
            System.out.println(" ");
        }

        for(int i = 0; i < 4; i++){
            for(int j = i + 1; j < 5; j++){
                int y = a[i].soSanh(a[j]);
                if(y == -1){
                    PhanSo temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        for(int i = 0; i < 5; i++){
            a[i].HienThi();
            System.out.println(" ");
        }
    }
}
