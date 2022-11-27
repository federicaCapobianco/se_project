module com.example.se_project {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;



    opens com.example.se_project to javafx.fxml;
    exports com.example.se_project;
    exports diem.unisa.softwareengineering.tools;
    opens diem.unisa.softwareengineering.tools to javafx.fxml;
}