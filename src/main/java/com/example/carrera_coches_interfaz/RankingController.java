package com.example.carrera_coches_interfaz;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class RankingController {
    //
    @FXML private VBox rankingBox;

    // Recibe la lista de coches en orden de llegada
    public void rankingCoches(List<String> ranking) {
        rankingBox.getChildren().clear();
        for (int i = 0; i < ranking.size(); i++) {
            Label label = new Label((i + 1) + "º: " + ranking.get(i));
            label.setStyle("-fx-font-size: 16px;");
            rankingBox.getChildren().add(label);
        }
    }
    //boton de cerrar, cierra la ventana del modal
    @FXML
    private void cerrar() {
        Stage stage = (Stage) rankingBox.getScene().getWindow();
        stage.close();
    }
}
