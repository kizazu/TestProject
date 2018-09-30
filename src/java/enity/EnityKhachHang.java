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
public class EnityKhachHang {
      private int cID;
    private String cName;
    private String address;
    private String phone;
    private String userName;
    private String password;
    private int status;

    public EnityKhachHang() {
    }
    public EnityKhachHang(int id,String cName, String address, String phone,String username, int status) {
        this.cID=id;
        this.cName = cName;
        this.address = address;
        this.phone = phone;
        this.status=status;
        this.userName=username;
    }
    
    public EnityKhachHang(String cName, String address, String phone, String userName, String password) {
        this.cName = cName;
        this.address = address;
        this.phone = phone;
        this.userName = userName;
        this.password = password;
    }
    
    public EnityKhachHang(int id,String cName, String address, String phone, int status) {
        this.cID=id;
        this.cName = cName;
        this.address = address;
        this.phone = phone;
        this.status=status;
    }

    public int getcID() {
        return cID;
    }

    public void setcID(int cID) {
        this.cID = cID;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "KhachHang{" + "cID=" + cID + ", cName=" + cName + ", address=" + address + ", phone=" + phone + ", userName=" + userName + ", password=" + password + ", status=" + status + '}';
    }
    
            
}
