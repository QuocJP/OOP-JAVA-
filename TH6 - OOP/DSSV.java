import java.util.ArrayList;

public class DSSV {
    private ArrayList<SV> ds;

    public DSSV() {
        ds = new ArrayList<>();
    }

    public void them(SV s) {
        if (!ds.contains(s)) {
            ds.add(s);
            System.out.println("Đã thêm: " + s.layHoTen());
        } else {
            System.out.println("Trùng lặp! Sinh viên " + s.layHoTen() + " đã tồn tại.");
        }
    }

    public SV tim(String ht) {
        for (int i = 0; i < ds.size(); i++) {
            if (ds.get(i).layHoTen().equals(ht)) {
                return ds.get(i);
            }
        }
        return null;
    }

    public void xoa(String ht) {
        for (int i = 0; i < ds.size(); i++) {
            if (ds.get(i).layHoTen().equals(ht)) {
                ds.remove(i);
                System.out.println("Đã xóa sinh viên: " + ht);
                return;
            }
        }
        System.out.println("Không tìm thấy sinh viên " + ht + " để xóa.");
    }

    public void inDanhSach() {
        System.out.println("DANH SÁCH TẤT CẢ SINH VIÊN");
        for (SV s : ds) {
            System.out.println(s.toString());
        }
    }

    public void inTheoLoai(Class<?> loai) {
        System.out.println("--- DANH SÁCH " + loai.getSimpleName() + " ---");
        for (SV s : ds) {
            if (loai.isInstance(s)) {
                System.out.println(s.toString());
            }
        }
    }
}