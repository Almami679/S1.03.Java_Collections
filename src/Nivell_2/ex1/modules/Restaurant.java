package Nivell_2.ex1.modules;

import java.util.Objects;

public class Restaurant {

    private String name;
    private int score;

    public Restaurant(String name, int score) {
        this.name = name;
        this.score = score;
    }

    //GETTERS

    public String getName() {
        return this.name;
    }

    public double getScore() {
        return score;
    }

    //SETTERS

    public void setScore(int newScore) {
        this.score = newScore;
    }

    public String toString() {
        return "Restaurante : " + this.name + (" puntuacion: " + this.score + "/10");
    }

    //Metodos propios
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public boolean equals(Object r) {//si lo hago directamente con Restaurant, no me acepta el equals
        boolean check = false;
        // hay que asegurar que obj es de la clase Restaurante
        if (r instanceof Restaurant) {
            // se comparan los nombres del mes
            Restaurant otro = (Restaurant) r;
            if(this.name.equalsIgnoreCase(otro.name)){
                check = true;
            }
        }
        return check;
        }
}



