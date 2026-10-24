import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<HoGiaDinh> dsHo = new ArrayList<>();

        System.out.print("Nhập số lượng hộ gia đình: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin hộ thứ " + (i + 1) + ":");
            System.out.print("Mã hộ: ");
            String maHo = sc.nextLine();
            
            System.out.print("Tên chủ hộ: ");
            String tenChuHo = sc.nextLine();
            
         
            String loaiHo = "";
            while (true) {
                System.out.print("Loại hộ (1. Sinh hoạt / 2. Kinh doanh): ");
                String nhapLoai = sc.nextLine();
                
                if (nhapLoai.equals("1")) {
                    loaiHo = "Sinh hoạt";
                    break; 
                } else if (nhapLoai.equals("2")) {
                    loaiHo = "Kinh doanh";
                    break; 
                } else {
                    System.out.println("Vui lòng chọn 1 hoặc 2!");
                }
            }
            
            System.out.print("Chỉ số công tơ cũ: ");
            int chiSoCu = sc.nextInt();
            
            System.out.print("Chỉ số công tơ mới: ");
            int chiSoMoi = sc.nextInt();
            sc.nextLine(); // Dọn bộ đệm

            ChiSoCongTo ct = new ChiSoCongTo(chiSoCu, chiSoMoi);
            HoGiaDinh ho = new HoGiaDinh(maHo, tenChuHo, loaiHo, ct);
            
            dsHo.add(ho);
            System.out.println();
        }

        System.out.println("Danh sách thông tin tiền điện:");
        for (HoGiaDinh ho : dsHo) {
            ho.xuatThongTin();
        }

        if (dsHo.size() > 0) {
            HoGiaDinh hoMax = dsHo.get(0);
            
            for (int i = 1; i < dsHo.size(); i++) {
                if (dsHo.get(i).getCongTo().tinhDienTieuThu() > hoMax.getCongTo().tinhDienTieuThu()) {
                    hoMax = dsHo.get(i);
                }
            }

            System.out.println("Hộ gia đình tiêu thụ điện nhiều nhất:");
            hoMax.xuatThongTin();
        }
        
        sc.close();
    }
}