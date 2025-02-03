package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class SemiBoard {
    private ArrayList<Cell> cells = new ArrayList<>();
    private Player player;

    public SemiBoard(Player player) {
        this.player = player;
    }

    public ArrayList<Cell> getCells() {
        return cells;
    }

    public void setCells() {
        char letter = player.getId() == 1 ? 'A' : 'G'; // Lettres A-F pour le joueur 1, G-L pour le joueur 2
        for (int i = 0; i < 6; i++) {
            Cell cell = new Cell(0, String.valueOf(letter));
            cells.add(cell);
            letter++;
        }
    }

}
