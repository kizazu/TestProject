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
public class EnitySanPham {
    private String sid;
    private String sname;
    private int soluong;
    private int gia;
    private String picture;
    private String dacta;
    private int status;
    private int hid;
    public EnitySanPham(String sid,String sname,int soluong,int gia,String picture,String dacta,int status,int hid)
    {
        this.sid=sid;
        this.sname=sname;
        this.soluong=soluong;
        this.picture=picture;
        this.dacta=dacta;
        this.status=status;
        this.hid=hid;
        this.gia=gia;
        
    }
    public void setSid(String sid) {
        this.sid = sid;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setDacta(String dacta) {
        this.dacta = dacta;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setHid(int hid) {
        this.hid = hid;
    }
 public int getGia() {
        return gia;
    }
    public String getSid() {
        return sid;
    }

    public String getSname() {
        return sname;
    }

    public int getSoluong() {
        return soluong;
    }

    public String getPicture() {
        return picture;
    }

    public String getDacta() {
        return dacta;
    }

    public int getStatus() {
        return status;
    }

    public int getHid() {
        return hid;
    }
    
}
