package Thuchanh2.PhanSo;

public class PhanSo {
    private int tuSo;
    private int mauSo;

    public PhanSo(){
        tuSo = 0;
        mauSo = 1;
    }//Khởi tạo mặc định
    
    public PhanSo(int n){
        tuSo = n;
        mauSo = 1;
    }//Khởi tạo với 1 tham số
    
    public PhanSo(int t, int m){
        tuSo = t;
        mauSo = m;
    }//Khởi tạo với 2 tham số
    
    public PhanSo(PhanSo p){
        tuSo = p.tuSo;
        mauSo = p.mauSo;
    }//Khởi tạo với 1 đối tượng phân số
    
    public void ganTu(int t){
        this.tuSo = t;
    }

    public int layTu(){
        return tuSo;
    }

    public void ganMau(int m){
        this.mauSo = m;
    }

    public int layMau(){
        return mauSo;
    }

    public void HienThi(){
        System.out.print(tuSo + "/" + mauSo);
    }
    
    private int USCLN(int a, int b){
        a = Math.abs(a);
        b = Math.abs(b);
        while(b != 0){
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
    
    private void rutgon(){
        int a = this.tuSo;
        int b = this.mauSo;
        this.tuSo = this.tuSo / USCLN(a, b);
        this.mauSo = this.mauSo / USCLN(a, b);
    }
    
    public void tang(int n){
        if(n > 0){
            tuSo = tuSo + n;
            mauSo = mauSo + n;
        }System.out.println("Phan so sau khi tang: " + tuSo + "/" + mauSo);
    }
    
    public void gap(int n){
        if(n > 0){
            tuSo = tuSo * n;
            mauSo = mauSo * n;
        }System.out.println("Phan so sau khi gap: " + tuSo + "/" + mauSo);
    }
    
    public PhanSo cong(int n){
        int tu, mau;
        n = n * mauSo;
        tu = tuSo + n;
        mau = mauSo;
        PhanSo ketqua = new PhanSo(tu, mau);
        ketqua.rutgon();
        return ketqua;
    }
    
    public PhanSo cong(PhanSo p){
        int tu, mau;
        tu = tuSo * p.mauSo + p.tuSo * mauSo;
        mau = p.mauSo * mauSo;
        PhanSo ketqua = new PhanSo(tu, mau);
        ketqua.rutgon();
        return ketqua;
    }
    
    public PhanSo tru(int n){
        int tu, mau;
        n = n * mauSo;
        tu = tuSo - n;
        mau = mauSo;
        PhanSo ketqua = new PhanSo(tu, mau);
        ketqua.rutgon();
        return ketqua;
    }
    
    public PhanSo tru(PhanSo p){
        int tu, mau;
        tu = tuSo * p.mauSo - p.tuSo * mauSo;
        mau = p.mauSo * mauSo;
        PhanSo ketqua = new PhanSo(tu, mau);
        ketqua.rutgon();
        return ketqua;
    }
    
    public PhanSo nhan(int n){
        int tu, mau;
        tu = tuSo * n;
        mau = mauSo;
        PhanSo ketqua = new PhanSo(tu, mau);
        ketqua.rutgon();
        return ketqua;
    }
    
    public PhanSo nhan(PhanSo p){
        int tu, mau;
        tu = tuSo * p.tuSo;
        mau = mauSo * p.mauSo;
        PhanSo ketqua = new PhanSo(tu, mau);
        ketqua.rutgon();
        return ketqua;
    }
    
    public PhanSo chia(int n){
        int tu, mau;
        if(n == 0){
            System.out.println("Khong the chia cho 0");
            return this;
        }else{
            mau = mauSo * n;
            tu = tuSo;
            PhanSo ketqua = new PhanSo(tu, mau);
            ketqua.rutgon();
            return ketqua;
        }
    }
    
    public PhanSo chia(PhanSo p){
        int tu, mau;
        if(p.tuSo == 0){
            System.out.println("Khong the chia");
            return this;
        }else{
            mau = mauSo * p.tuSo;
            tu = tuSo * p.mauSo;
            PhanSo ketqua = new PhanSo(tu, mau);
            ketqua.rutgon();
            return ketqua;
        }
    }
    
    @Override//là một annotation trong java dùng để báo cho complier biết
    public String toString(){
        return(tuSo + "/" + mauSo);
    }
    
    public int soSanh(PhanSo p){
        long vt = (long)tuSo * p.mauSo;
        long vp = (long)mauSo * p.tuSo;
        if(tuSo * p.mauSo < 0)
            vt = -vt;
        if(p.tuSo * mauSo < 0)
            vp = -vp;
        if(vt > vp){
            return 1;
        }else if(vp > vt){
            return -1;
        }else
            return 0;
    }
}