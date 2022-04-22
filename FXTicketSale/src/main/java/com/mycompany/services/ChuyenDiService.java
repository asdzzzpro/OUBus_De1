/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.services;

import com.mycompany.conf.jdbcUtils;
import com.mycompany.pojo.ChuyenXe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import javafx.scene.control.Alert;

/**
 *
 * @author XGEAR
 */
public class ChuyenDiService {
    public List<ChuyenXe> getCacChuyenDi() throws SQLException{
        List<ChuyenXe> results = new ArrayList<>();
        try(Connection conn = jdbcUtils.getConn()){
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM  chuyenxe");
         
            
            while (rs.next()){
               
                ChuyenXe c = new ChuyenXe(rs.getInt("maChuyenXe"),rs.getInt("maXe"), rs.getString("ngayXuatPhat"),rs.getInt("giaVe"), rs.getString("diemDi"),rs.getString("diemDen"));
            
                results.add(c);
            }
        }
        return results;
        
        
        
        
    }

     public List<ChuyenXe> getChuyenDis(String kw) throws SQLException{
       List<ChuyenXe> chuyendis = new ArrayList<>();
        
       try (Connection conn = jdbcUtils.getConn()){
           String sql = " SELECT * FROM chuyenxe";
           if (kw != null && !kw.isEmpty())
               sql += " WHERE content like concat('%', ?, '%')";
           PreparedStatement stm = conn.prepareStatement(sql);
           if(kw != null && !kw.isEmpty())
               stm.setString(1, kw);
           ResultSet rs = stm.executeQuery();
           while (rs.next()){
               ChuyenXe c = new ChuyenXe(rs.getInt("maChuyenXe"),rs.getInt("maXe"), rs.getString("ngayXuatPhat"),rs.getInt("giaVe"), rs.getString("diemDi"),rs.getString("diemDen"));
               chuyendis.add(c);
           }        
       }
       
       
       return chuyendis;
    }
     
     
     
     public static void deleteChuyenDi(int MaChuyenXe) throws SQLException {
       String sql = "DELETE FROM chuyenxe WHERE maChuyenXe=?";
       Connection conn = jdbcUtils.getConn();
       conn.setAutoCommit(false);
       
       PreparedStatement stm = conn.prepareStatement(sql);
       stm.setInt(1, MaChuyenXe);
       stm.executeUpdate();
       
       conn.commit();
     
   }
     
     public static  Alert getAlertInfo(String content , Alert.AlertType type){
         Alert a = new Alert(type);
         a.setContentText(content);
         return a;
  
     }
     
     
     public static List<ChuyenXe> timKiemChuyenDi(String maChuyenXe) throws SQLException{
         
         String sql ="SELECT * FROM  chuyenxe WHERE maChuyenXe=?";
         
         Connection conn = jdbcUtils.getConn();
         PreparedStatement stm = conn.prepareStatement(sql);
         stm.setString(1, maChuyenXe);
         
         ResultSet rs = stm.executeQuery();
         
         List<ChuyenXe> chuyenxe = new ArrayList<>();
          while (rs.next()){
               ChuyenXe c = new ChuyenXe(rs.getInt("maChuyenXe"),rs.getInt("maXe"), rs.getString("ngayXuatPhat"),rs.getInt("giaVe"), rs.getString("diemDi"),rs.getString("diemDen"));
               chuyenxe.add(c);
          }
         return chuyenxe;
        }
     
     
     
     public static List<ChuyenXe> getChuyenXe(String keyword) throws SQLException{
         String sql = "SELECT * FROM chuyenxe";
         if(!keyword.isEmpty())
             sql+= "WHERE diemDi like ?";
                     
         Connection conn = jdbcUtils.getConn();
         PreparedStatement stm = conn.prepareStatement(sql);
         if(!keyword.isEmpty())
             stm.setString(1, String.format("%%%S%%", keyword));
             
         ResultSet rs = stm.executeQuery();
         List<ChuyenXe> chuyenxe = new ArrayList<>();
         while (rs.next()){
             ChuyenXe q = new ChuyenXe(rs.getInt("maChuyenXe"),rs.getInt("maXe"),
                     rs.getString("ngayXuatPhat"),rs.getInt("giaVe"), rs.getString("diemDi"),rs.getString("diemDen"));
             chuyenxe.add(q);
         }
         return chuyenxe;
         
     }
     
          
    
}
    

