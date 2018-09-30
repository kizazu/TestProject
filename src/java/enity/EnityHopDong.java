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
public class EnityHopDong {
    private String hid;
    private String sid;
    private int quantity;
    private int gia;

    public EnityHopDong(String hid, String sid, int quantity, int gia) {
        this.hid = hid;
        this.sid = sid;
        this.quantity = quantity;
        this.gia = gia;
    }

    public String getHid() {
        return hid;
    }

    public String getSid() {
        return sid;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getGia() {
        return gia;
    }

    public void setHid(String hid) {
        this.hid = hid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }
    
}
