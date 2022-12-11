module com.example.se_project {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.graphics;


    opens diem.unisa.softwareengineering.app to javafx.fxml;
    exports diem.unisa.softwareengineering.app;
    exports diem.unisa.softwareengineering.tools;
    opens diem.unisa.softwareengineering.tools to javafx.fxml;
    exports diem.unisa.softwareengineering.commands;
    opens diem.unisa.softwareengineering.commands to javafx.fxml;
    exports diem.unisa.softwareengineering.shapes;
    opens diem.unisa.softwareengineering.shapes to javafx.fxml;
}