package org.example;

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

    public Object setCells() {
        for (int i = 0; i < 6; i++) {
            Cell cell = new Cell(0, "A");
            cells.add(cell);
        }
        return null;
    }
}
