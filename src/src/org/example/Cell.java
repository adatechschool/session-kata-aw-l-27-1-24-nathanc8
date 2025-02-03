package org.example;

public class Cell {
    private int seedNb;
    private String letter;

    public Cell(int seedNb, String letter) {
        this.seedNb = seedNb;
        this.letter = letter;
    }

    public int getSeedNb() {
        return seedNb;
    }

    public void setSeedNb(int seedNb) {
        this.seedNb = seedNb;
    }

    public int addSeed() {
        return ++ this.seedNb;
    }

    public int removeSeed() {
        return -- this.seedNb;
    }

    public String getLetter() {
        return letter;
    }
}
