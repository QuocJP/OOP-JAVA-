public class Main {
    public static void main(String[] args) {
        sinhVien[] sv = new sinhVien[3];

        // Nhập điểm cho sinh viên thứ 1
        Diem dm1 = new Diem("Lập trình cơ bản", 3, 9.0, 8.0, 7.0);
        Diem dm2 = new Diem("Cơ sở dữ liệu", 3, 10.0, 7.0, 9.0);
        sv[0] = new sinhVien("Nguyễn Anh Quốc", dm1, dm2);

        // Nhập điểm cho sinh viên thứ 2 (Tái sử dụng lại biến dm1, dm2 để không bị lỗi trùng lặp)
        dm1 = new Diem("Lập trình cơ bản", 3, 10.0, 10.0, 10.0);
        dm2 = new Diem("Cơ sở dữ liệu", 3, 9.0, 9.0, 9.0);
        sv[1] = new sinhVien("Anh Ba Sỉn", dm1, dm2);

        // Nhập điểm cho sinh viên thứ 3
        dm1 = new Diem("Lập trình cơ bản", 3, 5.0, 5.0, 5.0);
        dm2 = new Diem("Cơ sở dữ liệu", 3, 5.0, 5.0, 5.0);
        sv[2] = new sinhVien("Anh Ba Khía", dm1, dm2);

        // In kết quả
        System.out.println(sv[0].getHoTen() + " có điểm trung bình là: " + sv[0].tinhDTB());
        System.out.println(sv[1].getHoTen() + " có điểm trung bình là: " + sv[1].tinhDTB());
        System.out.println(sv[2].getHoTen() + " có điểm trung bình là: " + sv[2].tinhDTB());
    }
}