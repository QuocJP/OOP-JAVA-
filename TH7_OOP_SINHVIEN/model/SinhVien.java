package model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SinhVien {
    private String hoTen;
    private int namSinh;
    private double dtb;

    public SinhVien() {
    }

    public SinhVien(String hoTen, int namSinh, double dtb) {
        this.hoTen = hoTen;
        this.namSinh = namSinh;
        this.dtb = dtb;
    }

    public void hienThi() {
        System.out.println("Họ tên: " + hoTen + " | Năm sinh: " + namSinh + " | ĐTB: " + dtb);
    }

    @Override
    public String toString() {
        return hoTen + "-" + namSinh + "-" + dtb;
    }

    public void ghiTep(String tenTep) {
        try {
            FileOutputStream f = new FileOutputStream(tenTep);
            PrintWriter pw = new PrintWriter(f);
            pw.println(this.toString());
            pw.close();
        } catch (IOException e) {
            System.out.println("Lỗi ghi tệp: " + e.getMessage());
        }
    }

    public void docTep(String tenTep) {
        try {
            FileInputStream f = new FileInputStream(tenTep);
            BufferedReader br = new BufferedReader(new InputStreamReader(f));
            
            String s = br.readLine();
            if (s != null) {
                StringTokenizer st = new StringTokenizer(s, "-");
                if (st.countTokens() >= 3) {
                    this.hoTen = st.nextToken();
                    this.namSinh = Integer.parseInt(st.nextToken());
                    this.dtb = Double.parseDouble(st.nextToken());
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Lỗi đọc tệp: " + e.getMessage());
        }
    }
}