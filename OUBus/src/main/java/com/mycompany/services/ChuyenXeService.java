/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services;

import com.mycompany.conf.JdbcUtils;
import com.mycompany.pojo.ChuyenXe;
//import com.mycompany.pojo.Ghe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author Qhuy
 */
public class ChuyenXeService {
    
//    public void addChuyenXe(ChuyenXe cd) throws SQLException{
//        try (Connection conn = JdbcUtils.getConn()){
//            PreparedStatement stm1 = conn.prepareStatement("INSERT INTO chuyendi(id, diemDi, diemDen) VALUES(?, ?, ?) ");
////            stm1.setInt(1, cd.getId());
////            stm1.setString(2, cd.getDiemDi());
////            stm1.setString(3, cd.getDiemDen());
//            
//            stm1.executeUpdate();
//        } 
//    }
    
    public List<ChuyenXe> getChuyenXe(String kw) throws SQLException {
        List<ChuyenXe> chuyendi = new ArrayList<>();
        
       try (Connection conn = JdbcUtils.getConn()){
           String sql = " SELECT * FROM chuyenxe";
           if (kw != null && !kw.isEmpty())
               sql += " WHERE diemDi like concat('%', ?, '%')";
           PreparedStatement stm = conn.prepareStatement(sql);
           if(kw != null && !kw.isEmpty())
               stm.setString(1, kw);
           ResultSet rs = stm.executeQuery();
           while (rs.next()){
               ChuyenXe c = new ChuyenXe(rs.getInt("maChuyenXe"),rs.getInt("maXe"), rs.getString("ngayXuatPhat"),rs.getInt("giaVe"), rs.getString("diemDi"),rs.getString("diemDen"));
               chuyendi.add(c);
           }        
       }
       
        return chuyendi;
        
    }
    

}
