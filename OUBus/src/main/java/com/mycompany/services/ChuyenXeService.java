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
        ArrayList<ChuyenXe> cd = new ArrayList<>();
        
        try (Connection conn = JdbcUtils.getConn()) {

           PreparedStatement stm = conn.prepareStatement("SELECT * FROM chuyenxe WHERE diemDi like concat('%', ?, '%') OR diemDen like concat('%', ?, '%')");
//           PreparedStatement stm2 = conn.prepareStatement("SELECT ");
           
           if (kw == null)
               kw = "";
           stm.setString(1, kw);
           stm.setString(2, kw);
           ResultSet rs = stm.executeQuery();
                                        
            while (rs.next()) {
//                System.out.println(rs.getString(5));
//                System.out.println(strn); 
//                ChuyenXe c = new ChuyenXe(rs.getString("maChuyenXe"), rs.getInt("maXe"), rs.getDate("ngayXuatPhat"), rs.getint("giaVe"), rs.getString("diemDi"), rs.getString("diemDen"));
//                ChuyenXe c = new ChuyenXe(rs.getInt(1),rs.getString(5), rs.getString(6));
                ChuyenXe c = new ChuyenXe(rs.getString(1), rs.getInt(2), rs.getDate(3), rs.getInt(4), rs.getString(5), rs.getString(6));
                
//                ChuyenXe d = new ChuyenXe(rs.getInt("id"), rs.getString("diemDi"), rs.getString("diemDen"));
//                System.out.println("111");
                cd.add(c);
                
            }
        }
        
        return cd;
        
    }
    

}
