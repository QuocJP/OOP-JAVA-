public class PS {
    private int tu;
    private int mau;
    // Các hàm khởi tạo
    public PS() {
        this.tu = 0;
        this.mau = 1;
    }

    public PS(int n) {
        this.tu = n;
        this.mau = 1;
    }

    public PS(int t, int m) {
        this.tu = t;
        this.mau = (m != 0) ? m : 1; // Tránh mẫu số bằng 0
        rutGon();
    }

    public PS(PS p) {
        this.tu = p.tu;
        this.mau = p.mau;
    }

    // Getter, Setter
    
    public void ganTu(int t) { this.tu = t; rutGon(); }
    
    public int layTu() { return this.tu; }
    
    public void ganMau(int m) { 
        if(m != 0) { this.mau = m; rutGon(); } 
    }
    public int layMau() { return this.mau; }

    public void hienThi() {
        System.out.println(tu + "/" + mau);
    }

    // Hàm tìm ước chung lớn nhất để rút gọn
    private int ucln(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (a != b) {
            if (a > b) a -= b;
            else b -= a;
        }
        return a;
    }

    private void rutGon() {
        if (tu == 0) {
            mau = 1;
            return;
        }
        int uc = ucln(tu, mau);
        tu /= uc;
        mau /= uc;
        // Đảm bảo mẫu luôn dương
        if (mau < 0) {
            tu = -tu;
            mau = -mau;
        }
    }

    public void tang(int n) {
        this.tu = this.tu + n * this.mau;
        rutGon();
    }

    public void gap(int n) {
        this.tu = this.tu * n;
        rutGon();
    }

    // Các phép toán cộng, trừ, nhân, chia (trả về đối tượng PS mới)
    public PS cong(int n) {
        return new PS(this.tu + n * this.mau, this.mau);
    }

    public PS cong(PS p) {
        return new PS(this.tu * p.mau + p.tu * this.mau, this.mau * p.mau);
    }

    public PS tru(int n) {
        return new PS(this.tu - n * this.mau, this.mau);
    }

    public PS tru(PS p) {
        return new PS(this.tu * p.mau - p.tu * this.mau, this.mau * p.mau);
    }

    public PS nhan(int n) {
        return new PS(this.tu * n, this.mau);
    }

    public PS nhan(PS p) {
        return new PS(this.tu * p.tu, this.mau * p.mau);
    }

    public PS chia(int n) {
        return new PS(this.tu, this.mau * n);
    }

    public PS chia(PS p) {
        return new PS(this.tu * p.mau, this.mau * p.tu);
    }

    @Override
    public String toString() {
        if (mau == 1) return String.valueOf(tu);
        return tu + "/" + mau;
    }

    // So sánh: 1 (Lớn hơn), -1 (Nhỏ hơn), 0 (Bằng nhau)
    public int soSanh(PS p) {
        int a = this.tu * p.mau;
        int b = p.tu * this.mau;
        return Integer.compare(a, b);
    }

    // HÀM MAIN ĐỂ CHẠY CHƯƠNG TRÌNH 
    public static void main(String[] args) {
        System.out.println("BÀI THỰC HÀNH PHÂN SỐ");
        PS p = new PS(1, 2);
        PS q = new PS(5, 7);

        PS r = p.cong(q);
        System.out.println("r = p + q = " + r.toString());

        // t = 2*p - p/q  => t = p.nhan(2).tru(p.chia(q))
        PS t = p.nhan(2).tru(p.chia(q));
        System.out.println("t = 2*p - p/q = " + t.toString());

        int ss = p.soSanh(q);
        if (ss > 0) System.out.println("p > q");
        else if (ss < 0) System.out.println("p < q");
        else System.out.println("p = q");

        // Tạo mảng phân số và sắp xếp
        PS[] mangPS = {
            new PS(1, 2), new PS(13, 2), new PS(5, 7),
            new PS(6, 9), new PS(30, 23)
        };

        // Sắp xếp mảng (Bubble Sort)
        for (int i = 0; i < mangPS.length - 1; i++) {
            for (int j = i + 1; j < mangPS.length; j++) {
                if (mangPS[i].soSanh(mangPS[j]) > 0) {
                    PS temp = mangPS[i];
                    mangPS[i] = mangPS[j];
                    mangPS[j] = temp;
                }
            }
        }

        System.out.print("Mảng phân số tăng dần: ");
        for (PS ps : mangPS) {
            System.out.print(ps.toString() + "  ");
        }
    }
}