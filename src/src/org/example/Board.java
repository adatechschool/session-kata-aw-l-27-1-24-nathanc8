package org.example;

import java.util.ArrayList;

public class Board {
    private SemiBoard semiBoardPlayer1;
    private SemiBoard semiBoardPlayer2;

    public SemiBoard getSemiBoardPlayer1() {
        return semiBoardPlayer1;
    }

    public void setSemiBoardPlayer1(SemiBoard semiBoardPlayer1) {
        this.semiBoardPlayer1 = semiBoardPlayer1;
    }

    public SemiBoard getSemiBoardPlayer2() {
        return semiBoardPlayer2;
    }

    public void setSemiBoardPlayer2(SemiBoard semiBoardPlayer2) {
        this.semiBoardPlayer2 = semiBoardPlayer2;
    }

    //Trouve la prochaine cellule dans le sens horaire
    private Cell getNextCell(int index, SemiBoard semiBoard) {
        ArrayList<Cell> cells = semiBoard.getCells();
        return cells.get((index + 1) % cells.size());
    }

    // Trouver la prochaine cellule dans le sens antihoraire
    private Cell getPreviousCell(int index, SemiBoard semiBoard) {
        ArrayList<Cell> cells = semiBoard.getCells();
        return cells.get((index - 1 + cells.size()) % cells.size());
    }

    public void saw(SemiBoard semiBoard, int cellIndex) {
        //Récupération des seeds d'une cellule
        ArrayList<Cell> cells = semiBoard.getCells();
        Cell currentCell = cells.get(cellIndex);
        int seedsToDistribute = currentCell.getSeedNb();

        //Vérification que currentCell n'est pas vide
        if (seedsToDistribute == 0) {
            System.out.println("La cellule est vide, rien à semer.");
            return;
        }

        currentCell.setSeedNb(0);

        // Distribution des graines
        int index = cellIndex;
        while (seedsToDistribute > 0) {
            index = (index + 1) % cells.size();
            cells.get(index).addSeed();
            seedsToDistribute--;
        }
    }

    public String displayBoard() {
        StringBuilder sb = new StringBuilder();

        //SemiBoardUp
        sb.append(" ");
        for (Cell cell : semiBoardPlayer1.getCells()) {
            sb.append(" ").append(cell.getLetter()).append(" ");
        }
        sb.append("\n");

        sb.append(" ");
        for (Cell cell : semiBoardPlayer1.getCells()) {
            sb.append("(").append(cell.getSeedNb()).append(")");
        }
        sb.append("\n");

        //SemiBoardDown
        sb.append(" ");
        for (Cell cell : semiBoardPlayer2.getCells()) {
            sb.append("(").append(cell.getSeedNb()).append(")");
        }
        sb.append("\n");

        sb.append(" ");
        for (Cell cell : semiBoardPlayer2.getCells()) {
            sb.append(" ").append(cell.getLetter()).append(" ");
        }
        sb.append("\n");

        return sb.toString();
    }
}
