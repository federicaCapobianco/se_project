module com.example.se_project {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.testng;
    requires org.junit.jupiter.api;


    opens com.example.se_project to javafx.fxml;
    exports com.example.se_project;
}