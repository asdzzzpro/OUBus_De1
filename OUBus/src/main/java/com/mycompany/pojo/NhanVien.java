/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pojo;

/**
 *
 * @author Qhuy
 */
public class NhanVien {
    private int maNV;
    private String tenNV;
    private String username;
    private String password;
    private Enum user_role;

    public NhanVien() {
    }

    public NhanVien(int maNV, String tenNV, String username, String password, Enum user_role) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.username = username;
        this.password = password;
        this.user_role = user_role;
    }
    
    

    /**
     * @return the maNV
     */
    public int getMaNV() {
        return maNV;
    }

    /**
     * @param maNV the maNV to set
     */
    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    /**
     * @return the tenNV
     */
    public String getTenNV() {
        return tenNV;
    }

    /**
     * @param tenNV the tenNV to set
     */
    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the user_role
     */
    public Enum getUser_role() {
        return user_role;
    }

    /**
     * @param user_role the user_role to set
     */
    public void setUser_role(Enum user_role) {
        this.user_role = user_role;
    }
    
}
