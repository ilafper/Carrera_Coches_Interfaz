package com.example.carrera_coches_interfaz;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class FinalCarrera {
    //lista de los nombre de los coches que llegan
    private final List<String> ranking = new ArrayList<>();
    //añadimos a la funcion sincronize para que solo se ejecute cada vez con un hilo y no se solapen.
    public synchronized void mostrarRanking(String nombre) {
        ranking.add(nombre);

        if (ranking.size() == 4) {
            Platform.runLater(() -> {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("ranking-modal.fxml"));
                    VBox root = loader.load();

                    RankingController controller = loader.getController();
                    controller.rankingCoches(ranking);

                    Stage stage = new Stage();
                    stage.setTitle("🏁 Ranking Final 🏁");
                    stage.setScene(new Scene(root));
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.showAndWait();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
