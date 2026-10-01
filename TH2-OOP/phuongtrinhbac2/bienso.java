package Thuchanh2.phuongtrinhbac2;
import java.math.*;
public class bienso {
    private int a;
    private int b;
    private int c;

    public bienso(){
        this.a = 0;
        this.b = 0;
        this.c = 0;
    }

    public void ganBSa(int d){
        this.a = d;
    }

    public void ganBSb(int e){
        this.b = e;
    }

    public void ganBSc(int f){
        this.c = f;
    }

    public double[] tinhtoan(int a, int b, int c){
        if(a == 0){
            if(b == 0){
                if(c == 0)
                    System.out.println("Phuong trinh vo so nghiem");
                else
                    System.out.println("Phuong trinh vo nghiem");
                    return null;
            }else{
                double kq = ((double)(-c)/b);
                return new double[]{kq};
            }
        }else{
            double delta =(double)(b*b - 4*a*c);
            if(delta > 0){
                double kq1 = (double)(((-b) + Math.sqrt(delta))/(2*a));
                double kq2 = (double)(((-b) - Math.sqrt(delta))/(2*a));
                return new double []{kq1, kq2} ; 
            }else if(delta == 0){
                double kq = (double)((-b)/(2*a));
                return new double[]{kq};
            }else{
                System.out.println("Phuong trinh vo nghiem");
                return null;
            }
        }
    }
}