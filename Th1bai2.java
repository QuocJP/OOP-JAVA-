import java.util.Scanner;

public class Th1bai2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("giai va bien luan phuong trinh bac nhat: ax + b = 0");
        System.out.print("Nhap he so a: ");
        double a = scanner.nextDouble();
        
        System.out.print("Nhap he so b: ");
        double b = scanner.nextDouble();
        
        System.out.println("--- KET QUA BIEN LUAN ---");
        
        // Biện luận theo hệ số a và b
        if (a != 0) {
            double x = -b / a;
            System.out.printf("phuong trinh co nghiem duy nhat: x = %.2f\n", x);
        } else {
            if (b == 0) {
                System.out.println("Phuong trinh co vo so nghiem (voi moi x).");
            } else {
                System.out.println("Phuong trinh vo nghiem.");
            }
        }
        
        scanner.close();
    }
}