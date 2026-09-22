import java.util.Scanner;

public class Th1bai3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 1. Khai báo và nhập kích thước mảng
        System.out.print("Nhap so luong phan tu cua mang: ");
        int n = scanner.nextInt();
        
        int[] arr = new int[n];
        
        // 2. Nhập dữ liệu cho từng phần tử của mảng
        System.out.println("Nhap cac phan tu cho mang:");
        for (int i = 0; i < n; i++) {
            System.out.print("Phan tu thu " + (i + 1) + ": ");
            arr[i] = scanner.nextInt();
        }
        
        // 3. Đếm số lượng số chẵn và số lẻ
        int soChan = 0;
        int soLe = 0;
        
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 == 0) {
                soChan++;
            } else {
                soLe++;
            }
        }
        
        // 4. Hiển thị kết quả
        System.out.println("\nKET QUA");
        System.out.println("Mang ban vua nhap la: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        
        System.out.println("Tong so luong so chan: " + soChan);
        System.out.println("TTong so luong so le: " + soLe);
        
        scanner.close();
    }
}