/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services;

import com.mycompany.conf.JdbcUtils;
import com.mycompany.pojo.VeXe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Qhuy
 */
public class VeXeService {
    public static ObservableList<VeXe> getListVeXe() throws SQLException {
        Connection conn = JdbcUtils.getConn();
        ObservableList<VeXe> listVX = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from vexe");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                listVX.add(new VeXe(rs.getInt("maVe"), rs.getString("tenXe"), rs.getString("maChuyenXe"), rs.getInt("maGhe"), rs.getInt("maKH"), rs.getInt("maNV")));
            }
        } catch (Exception e) {
            System.out.println("Cannot Connect" + e.getMessage());
        }
        return listVX;
    }
}
