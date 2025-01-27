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

    public void saw(int semiBoardIndex, int cellIndex) {
        SemiBoard currentSemiBoard = semiBoardIndex == 1 ? semiBoardPlayer1 : semiBoardPlayer2;
        ArrayList<Cell> currentCells = currentSemiBoard.getCells();

        int seedsToDistribute = currentCells.get(cellIndex).getSeedNb();
        //Controle de la cellule en cours : est-ce qu'il y a des graines dans cette cellule ?
        if (seedsToDistribute == 0) {
            System.out.println("La cellule est vide, rien à semer.");
            return;
        }

        currentCells.get(cellIndex).setSeedNb(0);

        // Distribution des graines
        int index = cellIndex;
        boolean isClockWise = true;
        while (seedsToDistribute > 0) {
            if (isClockWise) {
                index ++;
            } else {
                index --;
            }
            if (index >= currentCells.size()) {
                if (currentSemiBoard == semiBoardPlayer1) {
                    currentSemiBoard = semiBoardPlayer2;
                    isClockWise = false;
                } else {
                    currentSemiBoard = semiBoardPlayer1;
                    isClockWise = true;
                }
                currentCells = currentSemiBoard.getCells();
                index = currentCells.size() - 1;
            }

            // Ajouter une graine
            currentCells.get(index).addSeed();
            seedsToDistribute--;

        }
    }

    //Fonctionnalité harvest à ajouter : assez similaire à saw, mais prendrait en paramètre également un joueur, et
    // incrémenterais son score en fonction du nombre de graines qui ont été récoltées ?


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
