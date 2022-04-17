/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.fxticketsale;

import com.mycompany.pojo.ChuyenDi;
import com.mycompany.services.ChuyenDiService;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author XGEAR
 */
public class FXMLAdminController implements Initializable {
    @FXML
    private TableView<ChuyenDi> tbAdmin;
//    @FXML
//    private ComboBox<ChuyenDi> cbTest;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.loadColumns();
        try {
            this.loadAdmin(null);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }    
    
    
    
    private void loadColumns() {
        TableColumn col1 = new TableColumn("Diem Di");
        col1.setCellValueFactory(new PropertyValueFactory("diemDi"));
        col1.setPrefWidth(200);
        
        TableColumn col2 = new TableColumn("diemDi");
        col2.setCellValueFactory(new PropertyValueFactory("diemDen"));
        col2.setPrefWidth(200);
        
//        TableColumn col3 = new TableColumn("diemDen");
//        col3.setCellFactory(new PropertyValueFactory("diemDen"));
//        col3.setPrefWidth(200);
        
        this.tbAdmin.getColumns().addAll(col1, col2);
    }
    
    private void loadAdmin(String kw) throws SQLException{
        ChuyenDiService s = new ChuyenDiService();
        this.tbAdmin.setItems(FXCollections.observableList(s.getChuyenDi(kw)));
    }
    
}
