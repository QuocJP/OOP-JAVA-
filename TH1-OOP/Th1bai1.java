import java.util.Scanner;

public class Th1bai1 {
    public static void main(String[] args) {
        // Khởi tạo đối tượng Scanner để nhận dữ liệu từ người dùng
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Nhap ban kinh hinh tron (r): ");
        double banKinh = scanner.nextDouble();
        
        // Kiểm tra điều kiện bán kính hợp lệ
        if (banKinh < 0) {
            System.out.println("ban kinh khong the la so am!");
        } else {
            // Tính chu vi và diện tích
            double chuVi = 2 * Math.PI * banKinh;
            double dienTich = Math.PI * Math.pow(banKinh, 2);
            
            // Hiển thị kết quả 
            System.out.println("ket qua");
            System.out.printf("chu vi hinh tron la: %.2f\n", chuVi);
            System.out.printf("dien tich hinh tron la: %.2f\n", dienTich);
        }
        
        // Đóng scanner
        scanner.close();
    }
}
