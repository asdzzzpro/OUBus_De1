/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.tester;

import com.mycompany.conf.jdbcUtils;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 *
 * @author XGEAR
 */
public class databasetestsuite {
    private static Connection conn;
    
    @Test
    public void testEmployee() throws SQLException{
        conn = jdbcUtils.getConn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM chuyenxe");
            System.out.print("hihi");
            List<String> kq = new ArrayList<>();
            while (rs.next()) {
                String name = rs.getString("maChuyenXe");
                kq.add(name);
                System.out.println(name);
            }
        }
        catch (Exception e){
            System.out.println("hihi");
            System.out.println(e.toString());
            System.out.println("haha)");
        }
        conn.close();
    }
}
    
