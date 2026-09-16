import java.util.Scanner;

public class Th1bai4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 1. Khai báo và nhập mảng
        System.out.print("Nhap so luong phan tu cua mang: ");
        int n = scanner.nextInt();
        
        int[] arr = new int[n];
        System.out.println("Nhap cac phan tu cho mang:");
        for (int i = 0; i < n; i++) {
            System.out.print("Phan tu thu " + (i + 1) + ": ");
            arr[i] = scanner.nextInt();
        }
        
        // 2. Thuật toán đổi chỗ trực tiếp (Exchange Sort) sắp xếp tăng dần
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                // Nếu phần tử đứng trước lớn hơn phần tử đứng sau thì đổi chỗ
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        
        // 3. Hiển thị mảng sau khi sắp xếp
        System.out.println("\n--- MANG SAU KHI SAP XEP TANG DAN ---");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        
        scanner.close();
    }
}
