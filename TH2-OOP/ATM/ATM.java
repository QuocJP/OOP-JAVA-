package Thuchanh2.ATM;

public class ATM {
    private String soTK;
    private Double soDu;
    //Nhập số tài khoản và số dư
    public ATM(String stk, Double sd){
        this.soTK = stk;
        this.soDu = sd;
    }
    //Xuất số tài khoản
    public String laySTK(){
        return soTK;
    }
    //Xuất số dư:
    public Double laySoDu(){
        return soDu;
    }
    @Override
    public String toString(){
        return ("So tai khoan: " + soTK +" So du con lai: " + soDu);
    }
    public void napTien(Double st){
        soDu = st + soDu;
        System.out.println("So du hien tai: " + soDu);
    }public boolean rutTien(Double st){
        if(st < soDu){
            soDu = soDu - st;
            return true;
        }return false;
    }public boolean chuyenTien(ATM tk, Double st){
        if(tk == null)
            return false;
        if(st <= 0)
            return false;
        if(this.rutTien(st)){
            tk.napTien(st);
            return true;
        }return false;
    }
}