package org.example;


import java.util.logging.Level;
import java.util.logging.Logger;

public class Player {

    private static final Logger logger = Logger.getLogger(Player.class.getName());
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
        try {
            if (this.score < scoreToRemove) {
                throw new ScoreInsuffisantException("Score insuffisant pour retirer " + scoreToRemove + " points.");
            }
            this.score -= scoreToRemove;
        } catch (ScoreInsuffisantException e) {
            logger.log(Level.WARNING, e.getMessage(), e);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Player : {\n id = ")
                .append(id)
                .append(",\n name = '")
                .append(name)
                .append("',\n score = '")
                .append(score)
                .append("'\n}");
        return sb.toString();
    }


}
