public class App {
    public static void main(String[] args) {
        DSSV ds = new DSSV();

        SVSP sv1 = new SVSP("Nguyễn Anh Quốc", 2007, 8.5, "THPT Chuyen", 9.0);
        SVTH sv2 = new SVTH("Nguyen Thị Hoài Trung", 1999, 7.5, 8.0);
        
        // Tạo sinh viên trùng lặp với sv1 để kiểm tra phương thức equals
        SVSP sv3 = new SVSP("Nguyễn Anh Quốc", 2007, 8.5, "THPT Chuyen", 9.0); 

        ds.them(sv1);
        ds.them(sv2);
        ds.them(sv3); 

        System.out.println();
        ds.inDanhSach();
        
        System.out.println();
        ds.inTheoLoai(SVSP.class);
        
        System.out.println("\n..........Tìm kiếm.............");
        SV kq = ds.tim("Nguyen Thi Hoai Trung");
        if (kq != null) {
            System.out.println("Tìm thấy: " + kq.toString());
        } else {
            System.out.println("Không tìm thấy.");
        }

        System.out.println("\n..........Xóa........");
        ds.xoa("Nguyễn Anh Quốc");
        
        System.out.println();
        ds.inDanhSach();
    }
}