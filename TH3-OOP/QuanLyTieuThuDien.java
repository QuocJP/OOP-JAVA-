import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ChiSoCongTo {
    private double chiSoCu;
    private double chiSoMoi;

    public ChiSoCongTo(double chiSoCu, double chiSoMoi) {
        this.chiSoCu = chiSoCu;
        this.chiSoMoi = chiSoMoi;
    }

    public double tinhDienTieuThu() {
        return this.chiSoMoi - this.chiSoCu;
    }
}

class HoGiaDinh {
    private String maHo;
    private String tenChuHo;
    private String loaiHo; // "Sinh hoạt" hoặc "Kinh doanh"
    private ChiSoCongTo congTo;

    public HoGiaDinh(String maHo, String tenChuHo, String loaiHo, ChiSoCongTo congTo) {
        this.maHo = maHo;
        this.tenChuHo = tenChuHo;
        this.loaiHo = loaiHo;
        this.congTo = congTo;
    }

    public double getDienTieuThu() {
        return congTo.tinhDienTieuThu();
    }

    public double tinhTienDienChuaThue() {
        double dienTieuThu = getDienTieuThu();
        if (loaiHo.equalsIgnoreCase("Kinh doanh")) {
            return dienTieuThu * 3200;
        } else {
            return dienTieuThu * 2500; // Sinh hoạt
        }
    }

    public double tinhThueVAT() {
        return tinhTienDienChuaThue() * 0.08;
    }

    public double tinhTongTien() {
        return tinhTienDienChuaThue() + tinhThueVAT();
    }

    public String getMaHo() { return maHo; }
    public String getTenChuHo() { return tenChuHo; }
    public String getLoaiHo() { return loaiHo; }

    public static HoGiaDinh nhapHoGiaDinh(Scanner scanner) {
        System.out.print("Nhap ma ho gia dinh: ");
        String ma = scanner.nextLine();
        System.out.print("Nhap ten chu ho: ");
        String ten = scanner.nextLine();
        System.out.print("Nhap loai ho (sinh hoat / kinh doanh): ");
        String loai = scanner.nextLine();
        System.out.print("Nhap chi so cu (dau thang): ");
        double cu = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhap chi so moi (cuoi thang): ");
        double moi = Double.parseDouble(scanner.nextLine());

        return new HoGiaDinh(ma, ten, loai, new ChiSoCongTo(cu, moi));
    }
}

public class QuanLyTieuThuDien {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so luong ho gia dinh: ");
        int n = Integer.parseInt(scanner.nextLine());

        List<HoGiaDinh> danhSachHo = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Nhap thong tin cho ho gia dinh thu " + (i + 1) + " ---");
            danhSachHo.add(HoGiaDinh.nhapHoGiaDinh(scanner));
        }

        // Hiển thị bảng kê chi tiết
        System.out.println("\nBANG KE CHI TIET DIEN NANG TIEU THU TRONG THANG:");
        System.out.printf("%-10s %-20s %-15s %-18s %-20s %-12s %-15s\n", 
                "Ma ho", "Ten chu ho", "Loai ho", "Dien tieu thu", "Tien chua thue", "Thue VAT", "Tong tien");

        int maxIndex = 0;
        for (int i = 0; i < danhSachHo.size(); i++) {
            HoGiaDinh ho = danhSachHo.get(i);
            System.out.printf("%-10s %-20s %-15s %-18.1f %-20.0f %-12.0f %-15.0f\n",
                    ho.getMaHo(), ho.getTenChuHo(), ho.getLoaiHo(),
                    ho.getDienTieuThu(), ho.tinhTienDienChuaThue(), ho.tinhThueVAT(), ho.tinhTongTien());

            if (ho.getDienTieuThu() > danhSachHo.get(maxIndex).getDienTieuThu()) {
                maxIndex = i;
            }
        }
        System.out.println("===============================================================================================================");

 //in thông tin hộ gia đình tiêu thụ điện nhiều nhất
        HoGiaDinh hoMax = danhSachHo.get(maxIndex);
        System.out.println("\n=> HO GIA DINH TIEU THU DIEN NHIEU NHAT TRONG THANG:");
        System.out.println("- Ma ho: " + hoMax.getMaHo());
        System.out.println("- Ten chu ho: " + hoMax.getTenChuHo());
        System.out.println("- Loai ho: " + hoMax.getLoaiHo());
        System.out.printf("- Luong dien tieu thu: %.1f kWh\n", hoMax.getDienTieuThu());
        System.out.printf("- Tong tien phai tra: %.0f VNĐ\n", hoMax.tinhTongTien());
    }
}