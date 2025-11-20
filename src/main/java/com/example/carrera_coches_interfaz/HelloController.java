package com.example.carrera_coches_interfaz;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class HelloController {

    @FXML private ImageView RayoMcquuen;
    @FXML private ImageView Mate;
    @FXML private ImageView storm;
    @FXML private ImageView azulito;

    private final int distanciaMeta = 100; // metros de la carrera
    private final double pistaPixels = 700; // distancia horizontal máxima en px

    @FXML
    protected void iniciarCarrera() {
        //una clae de carrera
        FinalCarrera carrera = new FinalCarrera();

        // Coche1,  con los campos de nombre, vel max, la variable global de distancia maxima, la clase carrera.

        new Coche("Rayo McQueen", 10, distanciaMeta, carrera,
                progreso -> RayoMcquuen.setTranslateX(progreso * pistaPixels)).start();

        // Coche2
        new Coche("Mate", 10, distanciaMeta, carrera,
                progreso -> Mate.setTranslateX(progreso * pistaPixels)).start();

        // Coche3
        new Coche("Storm", 10, distanciaMeta, carrera,
                progreso -> storm.setTranslateX(progreso * pistaPixels)).start();

        // Coche4
        new Coche("Azulito", 10, distanciaMeta, carrera,
                progreso -> azulito.setTranslateX(progreso * pistaPixels)).start();
    }
}
