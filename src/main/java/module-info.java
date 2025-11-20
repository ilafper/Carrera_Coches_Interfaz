module com.example.carrera_coches_interfaz {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.carrera_coches_interfaz to javafx.fxml;
    exports com.example.carrera_coches_interfaz;
}