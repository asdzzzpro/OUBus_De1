/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pojo;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Qhuy
 */
public class ChiTietVeXe {
    private int maCTVX;
    private int maVe;
    private Date dayDatVe;
    private Time timeDatVe;

    public ChiTietVeXe() {
    }

    public ChiTietVeXe(int maCTVX, int maVe, Date dayDatVe, Time timeDatVe) {
        this.maCTVX = maCTVX;
        this.maVe = maVe;
        this.dayDatVe = dayDatVe;
        this.timeDatVe = timeDatVe;
    }

    
    /**
     * @return the maCTVX
     */
    public int getMaCTVX() {
        return maCTVX;
    }

    /**
     * @param maCTVX the maCTVX to set
     */
    public void setMaCTVX(int maCTVX) {
        this.maCTVX = maCTVX;
    }

    /**
     * @return the maVe
     */
    public int getMaVe() {
        return maVe;
    }

    /**
     * @param maVe the maVe to set
     */
    public void setMaVe(int maVe) {
        this.maVe = maVe;
    }

    /**
     * @return the dayDatVe
     */
    public Date getDayDatVe() {
        return dayDatVe;
    }

    /**
     * @param dayDatVe the dayDatVe to set
     */
    public void setDayDatVe(Date dayDatVe) {
        this.dayDatVe = dayDatVe;
    }

    /**
     * @return the timeDatVe
     */
    public Time getTimeDatVe() {
        return timeDatVe;
    }

    /**
     * @param timeDatVe the timeDatVe to set
     */
    public void setTimeDatVe(Time timeDatVe) {
        this.timeDatVe = timeDatVe;
    }
    
    
}
