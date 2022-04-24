/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.services;

import com.mycompany.conf.Utils;
import com.mycompany.conf.jdbcUtils;
import com.mycompany.fxticketsale.FXMLWelcomeController;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 *
 * @author XGEAR
 */
public class DangNhapNhanVienService {
    public Integer dangNhapAdmin(String us, String pw) throws SQLException {
         try (Connection conn = jdbcUtils.getConn()) { // kết nối đến csdl
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM nhanvien");// tạo 1 câu lệnh và sử dụng đối tượng kết nối
            ResultSet rs = stm.executeQuery();
            while (rs.next()) { //
               if(us.equals(rs.getString("username")) && rs.getString("password").equals(pw))
               {
                    try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLAdmin.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLWelcomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
                   Utils.getBox("successful!", Alert.AlertType.INFORMATION).show(); // đúng thì show ra box t.báo thành công
               
                   return 1;
               }
            }   
        }
        catch(Exception e) { // ngoại lệ
            Utils.getBox("ngoại lệ", Alert.AlertType.ERROR).show(); // xuất hiện hộp box ngoại lệ
        }
        return -1;// do k vô dc dòng if, trường hợp đăng nhập k thành công thì sẽ chạy ra dòng này
    }
}
