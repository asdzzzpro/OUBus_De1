module com.mycompany.qhuy.oubus {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;

    opens com.mycompany.qhuy.oubus to javafx.fxml;
    exports com.mycompany.qhuy.oubus;
    exports com.mycompany.pojo;
}
