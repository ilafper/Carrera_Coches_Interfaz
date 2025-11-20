package com.example.carrera_coches_interfaz;

import javafx.application.Platform;

import java.util.function.Consumer;

public class Coche extends Thread {

    private String nombre;
    private int distanciaRecorrida;
    private int velocidadMax;
    private int distanciaMeta;
    private FinalCarrera carrera;

    // Callback para actualizar la UI
    private Consumer<Double> updatePosition;

    public Coche(String nombre, int velocidadMax, int distanciaMeta, FinalCarrera carrera, Consumer<Double> updatePosition) {
        this.nombre = nombre;
        this.velocidadMax = velocidadMax;
        this.distanciaMeta = distanciaMeta;
        this.carrera = carrera;
        this.updatePosition = updatePosition;
        this.distanciaRecorrida = 0;
    }
    
    @Override
    public void run() {
        while (distanciaRecorrida < distanciaMeta) {
            int velocidadVariable = (int) (Math.random() * (velocidadMax + 1));
            distanciaRecorrida += velocidadVariable;

            if (distanciaRecorrida > distanciaMeta) {
                distanciaRecorrida = distanciaMeta;
            }
            System.out.println(nombre + " lleva " + distanciaRecorrida +" metros " +"de " + distanciaMeta + " metros ");
            double progreso = (double) distanciaRecorrida / distanciaMeta; // 0 a 1

            // Actualizar posición en la UI
            Platform.runLater(() -> updatePosition.accept(progreso));

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println( nombre + " ha llegado a la meta!");
        carrera.mostrarRanking(nombre);
    }
}
