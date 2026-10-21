package Thuchanh5.ThuVaBK.Client;
import Thuchanh5.ThuVaBK.Entities.*;
import Thuchanh5.ThuVaBK.Management.ThungThu;

public class Main {
    public static void main(String[] args){
        BuuPham bp1 = new Thu("BP001", 1, 0);
        BuuPham bp3 = new Thu("BP003", 2, 0);
        BuuPham bp2 = new BuuKien("BP002", 0);
        bp1.Tinhtien();
        bp2.Tinhtien();
        bp3.Tinhtien();
        ThungThu list = new ThungThu(100);
        list.Them(bp1);
        list.Them(bp2);
        list.Them(bp3);
        list.lietKe();
        System.out.println("Tong tien: " + list.tongTien());
    }
}
