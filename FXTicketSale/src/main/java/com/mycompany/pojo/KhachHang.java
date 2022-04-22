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
public class KhachHang {
    private int maKH;
    private String tenKh;
    private String sdt;

    public KhachHang() {
    }

    public KhachHang(int maKH, String tenKh, String sdt) {
        this.maKH = maKH;
        this.tenKh = tenKh;
        this.sdt = sdt;
    }
    
    

    /**
     * @return the maKH
     */
    public int getMaKH() {
        return maKH;
    }

    /**
     * @param maKH the maKH to set
     */
    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    /**
     * @return the tenKh
     */
    public String getTenKh() {
        return tenKh;
    }

    /**
     * @param tenKh the tenKh to set
     */
    public void setTenKh(String tenKh) {
        this.tenKh = tenKh;
    }

    /**
     * @return the sdt
     */
    public String getSdt() {
        return sdt;
    }

    /**
     * @param sdt the sdt to set
     */
    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    
    
}
