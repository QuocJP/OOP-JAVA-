import java.util.Scanner;

public class PhuongTrinhBac2 {
    private double a, b, c;

    public PhuongTrinhBac2(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void giaiPT() {
        if (a == 0) {
            if (b == 0) {
                System.out.println((c == 0) ? "Phương trình vô số nghiệm." : "Phương trình vô nghiệm.");
            } else {
                System.out.println("Phương trình có 1 nghiệm: x = " + (-c / b));
            }
            return;
        }

        double delta = b * b - 4 * a * c;
        if (delta < 0) {
            System.out.println("Phương trình vô nghiệm.");
        } else if (delta == 0) {
            System.out.println("Phương trình có nghiệm kép: x1 = x2 = " + (-b / (2 * a)));
        } else {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            System.out.println("Phương trình có 2 nghiệm phân biệt:");
            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập a, b, c cho PT (ax^2 + bx + c = 0): ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();

        PhuongTrinhBac2 pt = new PhuongTrinhBac2(a, b, c);
        pt.giaiPT();
        sc.close();
    }
}