/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.fxticketsale;

import com.mycompany.conf.Utils;
import com.mycompany.conf.jdbcUtils;
import com.mycompany.pojo.ChuyenXe;
import com.mycompany.services.ChuyenDiService;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author XGEAR
 */
public class FXMLAdminController implements Initializable {
    @FXML private TableView<ChuyenXe> tbcacChuyenDi;
    @FXML private TableColumn<ChuyenXe, Integer> idColumn;
    @FXML private TableColumn<ChuyenXe, String> diemDiColumn;
    @FXML private TableColumn<ChuyenXe, String> diemDenColumn;
    @FXML private TextField keywords;
   
    ObservableList<ChuyenXe> oblist = FXCollections.observableArrayList();
    
    
     @FXML
    void themchuyendi(ActionEvent event){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLThemChuyenDi.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLWelcomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
             
        try {
            this.loadTableData(null);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
        try {
            this.loadTableView();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }       

    private void loadTableView() throws SQLException{
        
            TableColumn colMaChuyenXe = new TableColumn("Mã Chuyến Đi");
            colMaChuyenXe.setCellValueFactory(new PropertyValueFactory("maChuyenXe"));
            colMaChuyenXe.setPrefWidth(80);
            
            TableColumn colMaXe = new TableColumn("Mã Xe");
            colMaXe.setCellValueFactory(new PropertyValueFactory("maXe"));
            colMaXe.setPrefWidth(80);
            
            TableColumn colNgayXuatPhat = new TableColumn("Ngày Xuất Phát");
            colNgayXuatPhat.setCellValueFactory(new PropertyValueFactory("ngayXuatPhat"));
            colNgayXuatPhat.setPrefWidth(80);
            
            TableColumn colGiaVe = new TableColumn("Giá Vé");
            colGiaVe.setCellValueFactory(new PropertyValueFactory("giaVe"));
            colGiaVe.setPrefWidth(80);
            
            TableColumn colDiemDi = new TableColumn("Điểm Đi");
            colDiemDi.setCellValueFactory(new PropertyValueFactory("diemDi"));
            colDiemDi.setPrefWidth(80);

            TableColumn colDiemDen = new TableColumn("Điểm Đến");
            colDiemDen.setCellValueFactory(new PropertyValueFactory("diemDen"));
            colDiemDen.setPrefWidth(80);
            
            TableColumn coldelete = new TableColumn();
            coldelete.setPrefWidth(80);
            coldelete.setCellFactory(p -> {
                
                Button btn = new Button("Xóa");
              
                btn.setOnAction(et ->{
                    Alert confirm = ChuyenDiService.getAlertInfo("Bạn Có Muốn Xóa Chuyến Đi Này Không?", Alert.AlertType.CONFIRMATION);
                    confirm.setContentText("Bạn có muốn xóa chuyến đi này không?");
                    confirm.showAndWait().ifPresent(res ->{
                       if(res == ButtonType.OK){
                           TableCell cl = (TableCell)((Button)et.getSource()).getParent();
                           ChuyenXe c = (ChuyenXe)cl.getTableRow().getItem();
                           try {
                               ChuyenDiService.deleteChuyenDi(c.getMaChuyenXe());
                               this.tbcacChuyenDi.getItems().clear();
                                this.tbcacChuyenDi.setItems(FXCollections.observableArrayList(ChuyenDiService.getChuyenXe("")));     
                              ChuyenDiService.getAlertInfo("Xóa Chuyến Đi Thành Công ", Alert.AlertType.INFORMATION).show();
                           } catch (SQLException ex) {
                                ChuyenDiService.getAlertInfo("Xóa Chuyến Đi Thất Bại  " +ex.getMessage(), Alert.AlertType.INFORMATION).show();
                               
                           }
                       
                       
                       }
                    });
                    
                
                });
                TableCell cell = new TableCell();
                cell.setGraphic(btn);
                return cell;
            });
            
                
            this.tbcacChuyenDi.getColumns().addAll(colMaChuyenXe,colMaXe,colNgayXuatPhat, colGiaVe, colDiemDi, colDiemDen, coldelete); 
           
         }   
    
    private void loadTableData(String kw) throws SQLException{
        ChuyenDiService s = new ChuyenDiService();
        this.tbcacChuyenDi.setItems(FXCollections.observableArrayList(s.getChuyenDis(kw) ));
    }
    
//    public void deleteChuyenDi(ActionEvent event){
//            ChuyenDiService s = new ChuyenDiService();
//             this.xoa.setOnAction((evt) -> {
//             TableCell c = (TableCell)((Button)evt.getSource()).getParent();
//             ChuyenDi q = (ChuyenDi) c.getTableRow().getItem();
//              try {
//                    if (s.deleteChuyenDi(Integer.toString(q.getId())) == true) {
//                        Utils.getBox("Delete successful!", Alert.AlertType.INFORMATION).show();
//                        this.loadTableData(null);
//                    } else {
//                        Utils.getBox("Delete failed!", Alert.AlertType.ERROR).show();
//                    }
//                } catch (SQLException ex) {
//                    Logger.getLogger(FXMLAdminController.class.getName()).log(Level.SEVERE, null, ex);
//                }
//         });

       
     
        
        
//    }
  
}
