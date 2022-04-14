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
public class Xe {
    private int maXe;
    private String tenXe;
    private int bienSo;
    private int soGhe;
    private String loaiXe;

    public Xe() {
    }

    public Xe(int maXe, String tenXe, int bienSo, int soGhe, String loaiXe) {
        this.maXe = maXe;
        this.tenXe = tenXe;
        this.bienSo = bienSo;
        this.soGhe = soGhe;
        this.loaiXe = loaiXe;
    }
    
    

    /**
     * @return the maXe
     */
    public int getMaXe() {
        return maXe;
    }

    /**
     * @param maXe the maXe to set
     */
    public void setMaXe(int maXe) {
        this.maXe = maXe;
    }

    /**
     * @return the tenXe
     */
    public String getTenXe() {
        return tenXe;
    }

    /**
     * @param tenXe the tenXe to set
     */
    public void setTenXe(String tenXe) {
        this.tenXe = tenXe;
    }

    /**
     * @return the bienSo
     */
    public int getBienSo() {
        return bienSo;
    }

    /**
     * @param bienSo the bienSo to set
     */
    public void setBienSo(int bienSo) {
        this.bienSo = bienSo;
    }

    /**
     * @return the soGhe
     */
    public int getSoGhe() {
        return soGhe;
    }

    /**
     * @param soGhe the soGhe to set
     */
    public void setSoGhe(int soGhe) {
        this.soGhe = soGhe;
    }

    /**
     * @return the loaiXe
     */
    public String getLoaiXe() {
        return loaiXe;
    }

    /**
     * @param loaiXe the loaiXe to set
     */
    public void setLoaiXe(String loaiXe) {
        this.loaiXe = loaiXe;
    }
    
    
}
