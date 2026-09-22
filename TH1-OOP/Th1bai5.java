import java.util.Scanner;

public class Th1bai5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 1. Khai báo và nhập mảng
        System.out.print("Nhap so luong phan tu cua mang: ");
        int n = scanner.nextInt();
        
        if (n <= 0) {
            System.out.println("So luong phan tu khong hop le!");
            scanner.close();
            return;
        }
        
        int[] arr = new int[n];
        System.out.println("Nhap cac phan tu cho mang:");
        for (int i = 0; i < n; i++) {
            System.out.print("Phan tu thu " + (i + 1) + ": ");
            arr[i] = scanner.nextInt();
        }
        
        // 2. Giả định phần tử đầu tiên (chỉ số 0) vừa là max vừa là min
        int max = arr[0];
        int maxIndex = 0;
        
        int min = arr[0];
        int minIndex = 0;
        
        // 3. Duyệt mảng từ phần tử thứ 2 (chỉ số 1) để tìm max, min
        for (int i = 1; i < n; i++) {
            // Nếu tìm thấy phần tử lớn hơn max hiện tại
            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
            
            // Nếu tìm thấy phần tử nhỏ hơn min hiện tại
            if (arr[i] < min) {
                min = arr[i];
                minIndex = i;
            }
        }
        
        // 4. Hiển thị kết quả
        System.out.println("\nKET QUA");
        System.out.println("MMang da nhap: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        
        System.out.println("Giá trị lớn nhất (Max) = " + max + " tại chỉ số (index): " + maxIndex);
        System.out.println("Giá trị nhỏ nhất (Min) = " + min + " tại chỉ số (index): " + minIndex);
        
        scanner.close();
    }
}