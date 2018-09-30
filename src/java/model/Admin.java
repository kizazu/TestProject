/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Bui Thanh Tung
 */
public class Admin {
    private String username;
    private String password;
    private int status;
    public Admin(String username,String password,int status)
    {
        this.username=username;
        this.password=password;
        this.status=status;
    }
    public Admin(String username,int status)
    {
        this.username=username;
        this.status=status;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getStatus() {
        return status;
    }
}
