/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pojo;

import java.sql.Date;

/**
 *
 * @author Qhuy
 */
public class ChuyenXe {
    private String maChuyenXeString;
    private int maXe;
    private Date ngayXuatPhat;
    private int giaVe;
    private String diemDi;
    private String diemDen;

    public ChuyenXe() {
    }

    public ChuyenXe(String maChuyenXeString, int maXe, Date ngayXuatPhat, int giaVe, String diemDi, String diemDen) {
        this.maChuyenXeString = maChuyenXeString;
        this.maXe = maXe;
        this.ngayXuatPhat = ngayXuatPhat;
        this.giaVe = giaVe;
        this.diemDi = diemDi;
        this.diemDen = diemDen;
    }

    public ChuyenXe(int maXe, String diemDi, String diemDen){
        this.maXe = maXe;
        this.diemDi = diemDi;
        this.diemDen = diemDen;
    }
    
    public ChuyenXe(String maChuyenXeString){
        this.maChuyenXeString = maChuyenXeString;
    }
    
    /**
     * @return the maChuyenXeString
     */
    public String getMaChuyenXeString() {
        return maChuyenXeString;
    }

    /**
     * @param maChuyenXeString the maChuyenXeString to set
     */
    public void setMaChuyenXeString(String maChuyenXeString) {
        this.maChuyenXeString = maChuyenXeString;
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
     * @return the ngayXuatPhat
     */
    public Date getNgayXuatPhat() {
        return ngayXuatPhat;
    }

    /**
     * @param ngayXuatPhat the ngayXuatPhat to set
     */
    public void setNgayXuatPhat(Date ngayXuatPhat) {
        this.ngayXuatPhat = ngayXuatPhat;
    }

    /**
     * @return the giaVe
     */
    public int getGiaVe() {
        return giaVe;
    }

    /**
     * @param giaVe the giaVe to set
     */
    public void setGiaVe(int giaVe) {
        this.giaVe = giaVe;
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

    
    
}
