package org.example;

public class Player {

    private int score;
    private String name;
    private int id;

    public Player(int score, String name, int id) {
        this.score = score;
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addToScore(int scoreToAdd) {
        this.score += scoreToAdd;
    }

    public void removeFromScore(int scoreToRemove) {
        if (this.score >= scoreToRemove) {
            this.score -= scoreToRemove;
        } else {
            System.out.println("Score insuffisant pour retirer " + scoreToRemove + " points.");
        }
    }

    @Override
    public String toString() {
        return "Player{id= " + id + ", name ='" + name + "', score=" + score + "}";
    }


}
