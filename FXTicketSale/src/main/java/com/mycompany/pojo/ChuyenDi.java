/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pojo;

//import java.time.LocalDateTime;

/**
 *
 * @author XGEAR
 */
public class ChuyenDi {
    private int id;
    private String diemDi;
    private String diemDen;
//    private LocalDateTime ngayKhoiHanh;  

    public ChuyenDi() {
    }

    public ChuyenDi(int id, String diemDi, String diemDen) {
        this.id = id;
        this.diemDi = diemDi;
        this.diemDen = diemDen;
//        this.ngayKhoiHanh = ngayKhoiHanh;
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
     * @return the diemDi
     */
    public String getDiemDi() {
        return diemDi;
    }

    /**
     * @param diemDi the diemDi to set
     */
    public void setDiemDi(String diemDi) {
        this.diemDi = diemDi;
    }

    /**
     * @return the diemDen
     */
    public String getDiemDen() {
        return diemDen;
    }

    /**
     * @param diemDen the diemDen to set
     */
    public void setDiemDen(String diemDen) {
        this.diemDen = diemDen;
    }

    /**
     * @return the ngayKhoiHanh
     */

    
}
