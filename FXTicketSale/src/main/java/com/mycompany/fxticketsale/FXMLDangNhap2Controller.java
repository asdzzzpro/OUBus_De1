/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.fxticketsale;

import com.mycompany.conf.Utils;
import com.mycompany.services.DangNhapService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author XGEAR
 */
public class FXMLDangNhap2Controller implements Initializable {
    @FXML private TextField username;
    @FXML private TextField password;
    
    
    @FXML
    public void handle (ActionEvent event) throws SQLException {
        String us = username.getText(); // lấy giá trị trong text field
        String pw = password.getText();
        DangNhapService d = new DangNhapService();
        int kq = d.dangNhapAdmin(us, pw); // truyền 2 tham số
         if (username.getText().isEmpty()) {
            Utils.getBox("Chưa nhập username!", Alert.AlertType.INFORMATION).show();
            return;
        }
         if (password.getText().isEmpty()) {
            Utils.getBox("Chưa nhập password!", Alert.AlertType.INFORMATION).show();
            return;
        }
        if(kq!=1)
            Utils.getBox("fail!", Alert.AlertType.ERROR).show(); //hiện ra box thông báo "Đăng nhập k thành công"
        
        
         try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLAdmin.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLWelcomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void exit (ActionEvent event) throws SQLException {
        Platform.exit();
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
