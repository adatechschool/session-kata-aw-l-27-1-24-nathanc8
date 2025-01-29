package org.example;

import java.util.ArrayList;

public class Board {
    private SemiBoard semiBoardUp;
    private SemiBoard semiBoardDown;

    public SemiBoard getSemiBoardUp() {
        return semiBoardUp;
    }

    public void setSemiBoardUp(SemiBoard semiBoardUp) {
        this.semiBoardUp = semiBoardUp;
    }

    public SemiBoard getSemiBoardDown() {
        return semiBoardDown;
    }

    public void setSemiBoardDown(SemiBoard semiBoardDown) {
        this.semiBoardDown = semiBoardDown;
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
        SemiBoard currentSemiBoard = semiBoardIndex == 1 ? semiBoardUp : semiBoardDown;
        ArrayList<Cell> currentCells = currentSemiBoard.getCells();
        boolean isClockWise = !(semiBoardIndex == 1);

        int seedsToDistribute = currentCells.get(cellIndex).getSeedNb();
        //Controle de la cellule en cours : est-ce qu'il y a des graines dans cette cellule ?
        if (seedsToDistribute == 0) {
            System.out.println("La cellule est vide, rien à semer.");
            return;
        }

        currentCells.get(cellIndex).setSeedNb(0);

        // Distribution des graines
        int index = cellIndex;
        while (seedsToDistribute > 0) {
            if (isClockWise) {
                index ++;
            } else {
                index --;
            }
            if (index >= currentCells.size()) {
                if (currentSemiBoard == semiBoardUp) {
                    currentSemiBoard = semiBoardDown;
                    isClockWise = true;
                } else {
                    currentSemiBoard = semiBoardUp;
                    isClockWise = false;
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
        for (Cell cell : semiBoardUp.getCells()) {
            sb.append(" ").append(cell.getLetter()).append(" ");
        }
        sb.append("\n");

        sb.append(" ");
        for (Cell cell : semiBoardUp.getCells()) {
            sb.append("(").append(cell.getSeedNb()).append(")");
        }
        sb.append("\n");

        //SemiBoardDown
        sb.append(" ");
        for (Cell cell : semiBoardDown.getCells()) {
            sb.append("(").append(cell.getSeedNb()).append(")");
        }
        sb.append("\n");

        sb.append(" ");
        for (Cell cell : semiBoardDown.getCells()) {
            sb.append(" ").append(cell.getLetter()).append(" ");
        }
        sb.append("\n");

        return sb.toString();
    }
}
