/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services;

import com.mycompany.conf.jdbcUtils;
import com.mycompany.pojo.ChuyenDi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author Qhuy
 */
public class ChuyenDiService {
    public List<ChuyenDi> getChuyenDi(String kw) throws SQLException {
        List<ChuyenDi> cd = new ArrayList<>();
        
        try (Connection conn = jdbcUtils.getConn()) {
            String sql = "Select * from chuyendi";
            if (kw!=null && kw.isEmpty())
                sql += "Where diemDi like concat('%', ?, '%')";
//            Statement stm = conn.createStatement();
//            ResultSet rs = stm.executeQuery("SELECT * FROM chuyendi");
            PreparedStatement stm = conn.prepareStatement(sql);
            if (kw!=null && kw.isEmpty())
                stm.setString(1, kw);
            ResultSet rs = stm.executeQuery();
                                        
            while (rs.next()) {
                ChuyenDi d = new ChuyenDi(rs.getInt("id"), rs.getString("diemDi"), rs.getString("diemDen"));
                cd.add(d);
                
            }
        }
        
        return cd;
        
    }
}
