/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.qhuy.oubus;

import com.mycompany.conf.JdbcUtils;
import com.mycompany.pojo.ChuyenXe;
import com.mycompany.pojo.VeXe;
import com.mycompany.services.ChuyenXeService;
import com.mycompany.services.VeXeService;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Qhuy
 */
public class FXMLBookController implements Initializable {
    @FXML
    private TextField txtTimKiem;
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
    @FXML
    private TableView<VeXe> tbVeXe;
    @FXML
    private Text txtTenKHText;
    public static int id = 0;
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
        this.txtTimKiem.textProperty().addListener(evt -> {            
            try {
                this.loadData(this.txtTimKiem.getText());
            } catch (SQLException ex) {
                Logger.getLogger(FXMLBookController.class.getName()).log(Level.SEVERE, null, ex);
            }            
        });
        this.tbVeXe.setRowFactory(et -> {
            TableRow row = new TableRow();
            row.setOnMouseClicked(r -> {
                VeXe d = (VeXe) this.tbVeXe.getSelectionModel().getSelectedItem();
                 this.txtTenVe.setText(String.valueOf(d.getTenVe()));
                 this.txtMaChuyen.setText(String.valueOf(d.getMaChuyenXe()));
                 this.txtMaGhe.setText(String.valueOf(d.getMaGhe()));
                 this.txtMaNV.setText(String.valueOf(d.getMaNV()));
                 this.txtTenKH.setText(String.valueOf(d.getTenKH()));
                 this.txtSdt.setText(String.valueOf(d.getSdtKH()));
                 id = d.getMaVe();
            });
            return row;
        });
//        this.tbVeXe.setRowFactory(et -> {
//            TableRow row = new TableRow();
//            row.setOnMouseClicked(r -> {
//                VeXe d = (VeXe) this.tbVeXe.getSelectionModel().getSelectedItem();
//                 this.txtTenKHText.setText(String.valueOf(d.getTenKH()));
//                 
//            });
//        return row;
//        });
    }    
    
    public void xuatVe(ActionEvent event) throws IOException{
        FXMLLoader fXMLLoader = new FXMLLoader(App.class.getResource("FXMLXuat.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fXMLLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    
    public void themVe(ActionEvent event) throws SQLException{
        
        String sql = "INSERT INTO vexe (tenVe,maChuyenXe,maGhe,maNV,tenKH,sdtKH,ngayDatVe) values(?,?,?,?,?,?,?)";
        try(Connection conn = JdbcUtils.getConn()){
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, txtTenVe.getText());
            ps.setString(2, txtMaChuyen.getText());
            ps.setString(3, txtMaGhe.getText());
            ps.setString(4, txtMaNV.getText());
            ps.setString(5, txtTenKH.getText());
            ps.setString(6, txtSdt.getText());
            ps.setString(7, txtNgayDat.getEditor().getText());
            ps.executeUpdate();
            conn.commit();
            loadData(sql);
//            this.loadColumns();
            VeXeService.getBox("Them ve thanh cong", Alert.AlertType.INFORMATION);
        }catch(SQLException e){
            this.loadData(null);
        }catch(Exception ex){
            VeXeService.getBox("Khong the them ve moi", Alert.AlertType.WARNING);
        }
    }
    
    public void suaVe(ActionEvent event) throws IOException{
        FXMLLoader fXMLLoader = new FXMLLoader(App.class.getResource("FXMLChinhSua.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fXMLLoader.load());
        stage.setScene(scene);
        stage.show();
            
    }
    
    
    
    private void loadColumns(){
//        tbVeXe.setEditable(true);
        TableColumn col1 = new TableColumn("Ten Ve");
        col1.setCellValueFactory(new PropertyValueFactory<>("tenVe"));
        
        TableColumn col2 = new TableColumn("Ma Chuyen Xe");
        col2.setCellValueFactory(new PropertyValueFactory<>("maChuyenXe"));
        
        TableColumn col3 = new TableColumn("Ma Ghe");
        col3.setCellValueFactory(new PropertyValueFactory<>("maGhe"));
        
        TableColumn col4 = new TableColumn("Ten KH");
        col4.setCellValueFactory(new PropertyValueFactory<>("tenKH"));
        
        TableColumn col5 = new TableColumn("SDT");
        col5.setCellValueFactory(new PropertyValueFactory<>("sdtKH"));
        
        TableColumn col6 = new TableColumn("Ngay Dat");
        col6.setCellValueFactory(new PropertyValueFactory<>("ngayDatVe"));
        
        TableColumn col7 = new TableColumn();
//        col7.setPrefWidth(50);
        col7.setCellFactory(p -> {
            
            Button btn = new Button("Xoa");
            btn.setOnAction((ac ->{
                Alert confirm = VeXeService.getBox("Huy ve xe nay ?", Alert.AlertType.CONFIRMATION);
                confirm.setContentText("Ban co chac muon huy ve xe nay?");
                confirm.showAndWait().ifPresent(ch -> {
                    if(ch == ButtonType.OK){
                        TableCell tc = (TableCell)((Button)ac.getSource()).getParent();
                        
                        VeXe v = (VeXe)tc.getTableRow().getItem();
//                        System.out.println("test");
                        
                        try {
                            VeXeService.xoaVe(v.getMaVe());
//                            System.out.println("test");
                            this.tbVeXe.getItems().clear();
                            this.tbVeXe.setItems(FXCollections.observableList(VeXeService.getListVeXe("")));
                            VeXeService.getBox("Xoa thanh cong", Alert.AlertType.INFORMATION).show();
                        } catch (SQLException ex) {
                            VeXeService.getBox("Xoa that bai", Alert.AlertType.ERROR).show();
                        }
                            
                            
                        
                    }
                });
            }));
            TableCell cell = new TableCell();
            cell.setGraphic(btn);
            return cell;
        });
        
//        TableColumn col8 = new TableColumn();
//        col8.setCellFactory(p -> {
//            Button btn1 = new Button("Xuat");
//            
//            return null;
//        });
        //        this.btnUpdate.setVisible(false);
//             // Select row on Tableview
//        this.tbdepartm.setRowFactory(et -> {
//            TableRow row = new TableRow();
//            row.setOnMouseClicked(r -> {
//                this.btnUpdate. setVisible(true);
//                Department d = (Department) this.tbdepartm.getSelectionModel().getSelectedItem();
//                 this.txtid.setText(String.valueOf(d.getId()));
//                 this.txtname.setText(String.valueOf(d.getName()));
//                 this.txtaddress.setText(String.valueOf(d.getAddress()));
//                 this.txtphone.setText(String.valueOf(d.getPhone()));
//            });
//        return row;
//        });
        

               
        this.tbVeXe.getColumns().addAll(col1, col2, col3, col4, col5, col6, col7);
        
        
    }
    
    public void loadData(String kw) throws SQLException{
        VeXeService s = new VeXeService();
        this.tbVeXe.setItems(FXCollections.observableList(s.getListVeXe(kw)));
    }
//    public void loadData1(String kw) throws SQLException{
//        VeXeService s = new VeXeService();
//        this.tbVeXe.setItems(FXCollections.observableList(s.getListVeXe()));
//    }
}
