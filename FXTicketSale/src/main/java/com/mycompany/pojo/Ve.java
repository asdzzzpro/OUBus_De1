/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pojo;

import java.math.BigDecimal;

/**
 *
 * @author XGEAR
 */
public class Ve {
    private int id;
    private String soGhe;
    private boolean trangThai;
    private int maChuyenDi;
    private int maNhanvien;
    private BigDecimal giaVe;
    private String tenKhachHang;

    public Ve() {
    }

    public Ve(int id, String soGhe, boolean trangThai, int maChuyenDi, int maNhanvien, BigDecimal giaVe, String tenKhachHang) {
        this.id = id;
        this.soGhe = soGhe;
        this.trangThai = trangThai;
        this.maChuyenDi = maChuyenDi;
        this.maNhanvien = maNhanvien;
        this.giaVe = giaVe;
        this.tenKhachHang = tenKhachHang;
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
     * @return the soGhe
     */
    public String getSoGhe() {
        return soGhe;
    }

    /**
     * @param soGhe the soGhe to set
     */
    public void setSoGhe(String soGhe) {
        this.soGhe = soGhe;
    }

    /**
     * @return the trangThai
     */
    public boolean isTrangThai() {
        return trangThai;
    }

    /**
     * @param trangThai the trangThai to set
     */
    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    /**
     * @return the maChuyenDi
     */
    public int getMaChuyenDi() {
        return maChuyenDi;
    }

    /**
     * @param maChuyenDi the maChuyenDi to set
     */
    public void setMaChuyenDi(int maChuyenDi) {
        this.maChuyenDi = maChuyenDi;
    }

    /**
     * @return the maNhanvien
     */
    public int getMaNhanvien() {
        return maNhanvien;
    }

    /**
     * @param maNhanvien the maNhanvien to set
     */
    public void setMaNhanvien(int maNhanvien) {
        this.maNhanvien = maNhanvien;
    }

    /**
     * @return the giaVe
     */
    public BigDecimal getGiaVe() {
        return giaVe;
    }

    /**
     * @param giaVe the giaVe to set
     */
    public void setGiaVe(BigDecimal giaVe) {
        this.giaVe = giaVe;
    }

    /**
     * @return the tenKhachHang
     */
    public String getTenKhachHang() {
        return tenKhachHang;
    }

    /**
     * @param tenKhachHang the tenKhachHang to set
     */
    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }
}


