/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enity;

/**
 *
 * @author Bui Thanh Tung
 */
public class EnityHoaDon {
    private String hoadon;
    private String date;
    private int makh;
    private String hoten;
    private String diachi;
    private String phone;
    private int tongtien;
    private int status;
    public EnityHoaDon(String hoadon, String date, int makh, String hoten, String diachi, String phone, int tongtien) {
        this.hoadon = hoadon;
        this.date = date;
        this.makh = makh;
        this.hoten = hoten;
        this.diachi = diachi;
        this.phone = phone;
        this.tongtien = tongtien;

    }
    public EnityHoaDon(String hoadon, String date, int makh, String hoten, String diachi, String phone, int tongtien,int status) {
        this.hoadon = hoadon;
        this.date = date;
        this.makh = makh;
        this.hoten = hoten;
        this.diachi = diachi;
        this.phone = phone;
        this.tongtien = tongtien;
        this.status=status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
    public String getHoadon() {
        return hoadon;
    }

    public String getDate() {
        return date;
    }

    public int getMakh() {
        return makh;
    }

    public String getHoten() {
        return hoten;
    }

    public String getDiachi() {
        return diachi;
    }

    public String getPhone() {
        return phone;
    }

    public int getTongtien() {
        return tongtien;
    }

    public void setHoadon(String hoadon) {
        this.hoadon = hoadon;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setMakh(int makh) {
        this.makh = makh;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }
    
            
}
