package Thuchanh2.ATM;
public class Main {
    public static void main(String[] arggs){
        ATM ds[] = new ATM[5];
        ds[0] = new ATM("1111111", 100.0);
        ds[1] = new ATM("2222222", 100.0);
        ds[2] = new ATM("3333333", 100.0);
        ds[3] = new ATM("4444444", 100.0);
        ds[4] = new ATM("5555555", 100.0);
        ds[0].napTien(1000.0);
        System.out.println("So du sau khi nap: " + ds[0]);
        ds[0].chuyenTien(ds[1], 500.0);
        System.out.println("So du sau khi chuyen: " + ds[0]);
        ds[1].rutTien(200.0);
        System.out.println("So du sau khi rut: " + ds[1]);
        System.out.println("So du trong cac tai khoan: ");
        for(int i = 0; i < 5; i++){
            System.out.println(ds[i].toString());
        }Double tong = 0.0;
        for(int i = 0; i < 5; i++){
            tong += ds[i].laySoDu();
        }System.out.println("Tong so du cua cac tai khoan: " + tong);
    }
}
