/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pojo;

/**
 *
 * @author XGEAR
 */
public class NhanVien {
    private int id;
    private String hoTen;
    private String sDT;

    public NhanVien() {
    }

    public NhanVien(int id, String hoTen, String sDT) {
        this.id = id;
        this.hoTen = hoTen;
        this.sDT = sDT;
    }
    
    

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the hoTen
     */
    public String getHoTen() {
        return hoTen;
    }

    /**
     * @param hoTen the hoTen to set
     */
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    /**
     * @return the sDT
     */
    public String getsDT() {
        return sDT;
    }

    /**
     * @param sDT the sDT to set
     */
    public void setsDT(String sDT) {
        this.sDT = sDT;
    }
}
