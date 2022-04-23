/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.qhuy.oubus;

import com.mycompany.conf.JdbcUtils;
import com.mycompany.pojo.VeXe;
import com.mycompany.services.VeXeService;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Qhuy
 */
public class FXMLChinhSuaController implements Initializable {
    @FXML
    private TextField txtMaVe;
    @FXML
    private TextField txtTenVe;
    @FXML
    private TextField txtMaChuyen;
    @FXML
    private TextField txtMaGhe;
    @FXML
    private TextField txtMaNV;
    @FXML
    private TextField txtTenKH;
    @FXML
    private TextField txtSdt;
    @FXML
    private DatePicker txtNgayDat;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void chinhSua(ActionEvent event){
        try (Connection conn = JdbcUtils.getConn()){
            
            String sql1 = "update vexe set tenVe = '"+txtTenVe.getText()+"',maChuyenXe = '"+txtMaChuyen.getText()+"',maGhe = '"+
                    txtMaGhe.getText()+"',maNV = '"+txtMaNV.getText()+"',tenKH = '"+txtTenKH.getText()+"', sdtKH = '"+txtSdt.getText()+"',ngayDatVe = '"+txtNgayDat.getEditor().getText()+"' where MaVe= '"+txtMaVe.getText()+"' ";
            PreparedStatement ps = conn.prepareStatement(sql1);
            ps.execute();
//            System.out.println("test");            
            VeXeService.getBox("Sua thanh cong", Alert.AlertType.INFORMATION).show(); 
        } catch (SQLException e) {
            VeXeService.getBox("Sua that bai", Alert.AlertType.WARNING).show();
        }
    }
    
    
}
