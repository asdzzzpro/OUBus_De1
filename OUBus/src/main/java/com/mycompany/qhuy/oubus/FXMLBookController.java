/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.qhuy.oubus;

import com.mycompany.pojo.ChuyenXe;
import com.mycompany.services.ChuyenXeService;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Qhuy
 */
public class FXMLBookController implements Initializable {
    @FXML
    private TextField txtDiemDi;
//    @FXML
//    private TextField
    
    @FXML
    private TableView<ChuyenXe> tbChuyenXe;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.loadColumns();
        try {
            this.loadData(null);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLBookController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.txtDiemDi.textProperty().addListener(evt -> {            
            try {
                this.loadData(this.txtDiemDi.getText());
            } catch (SQLException ex) {
                Logger.getLogger(FXMLBookController.class.getName()).log(Level.SEVERE, null, ex);
            }            
        });
        
        
    }    
    private void loadColumns(){
        TableColumn col1 = new TableColumn("Diem Di");
        col1.setCellValueFactory(new PropertyValueFactory<>("diemDi"));
        col1.setPrefWidth(150);
        
        TableColumn col2 = new TableColumn("Diem Den");
        col2.setCellValueFactory(new PropertyValueFactory<>("diemDen"));
        col2.setPrefWidth(150);
        
        TableColumn col3 = new TableColumn("ma chuyen xe");
        col3.setCellFactory(new PropertyValueFactory<>("maChuyenXeString"));
        col3.setPrefWidth(200);
//        
//        TableColumn col3 = new TableColumn("Gia Ve");
//        col3.setCellFactory(new PropertyValueFactory("giaVe"));
//        col3.setPrefWidth(30);
//        TableColumn col3 = new TableColumn();
//        col3.setCellFactory((p) -> {
//            Button btn = new Button("Dat");
//            
//            
//        });
        
        this.tbChuyenXe.getColumns().addAll(col1, col2, col3);
        
        
    }
    
    public void loadData(String kw) throws SQLException{
        ChuyenXeService s = new ChuyenXeService();
        this.tbChuyenXe.setItems(FXCollections.observableList(s.getChuyenXe(kw)));
    }
    
}
