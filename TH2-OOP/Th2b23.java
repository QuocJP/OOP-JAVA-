public class ATM {
    private String soTK;
    private double soDu;

    public ATM(String stk, double sd) {
        this.soTK = stk;
        this.soDu = sd;
    }

    public String laySTK() { return soTK; }
    public double laySoDu() { return soDu; }

    @Override
    public String toString() {
        return "Tài khoản: " + soTK + " | Số dư: " + soDu;
    }

    public void napTien(double st) {
        if (st > 0) {
            this.soDu += st;
        }
    }

    public boolean rutTien(double st) {
        if (st > 0 && st <= this.soDu) {
            this.soDu -= st;
            return true;
        }
        return false;
    }

    public boolean chuyenTien(ATM tk, double st) {
        if (this.rutTien(st)) {
            tk.napTien(st);
            return true;
        }
        return false;
    }

    // hàm main
    public static void main(String[] args) {
        System.out.println("--- BÀI THỰC HÀNH ATM ---");
        // Tạo danh sách 5 tài khoản (Số tiền tối thiểu 100)
        ATM[] dsATM = {
            new ATM("1111111", 100),
            new ATM("2222222", 100),
            new ATM("3333333", 100),
            new ATM("4444444", 100),
            new ATM("5555555", 100)
        };

        // Tk 1111111 nạp 1000
        dsATM[0].napTien(1000);
        
        // Tk 1111111 chuyển cho Tk 2222222 số tiền 500
        dsATM[0].chuyenTien(dsATM[1], 500);

        // Tk 2222222 rút 200
        dsATM[1].rutTien(200);

        // In số tiền hiện có và tính tổng
        double tongTien = 0;
        System.out.println("Danh sách tài khoản:");
        for (ATM atm : dsATM) {
            System.out.println(atm.toString());
            tongTien += atm.laySoDu();
        }

        System.out.println("-> Tổng số tiền của tất cả tài khoản: " + tongTien);
    }
}
