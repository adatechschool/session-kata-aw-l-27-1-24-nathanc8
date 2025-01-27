package org.example;

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

    public String display() {
        StringBuilder sb = new StringBuilder();

        //SemiBoardUp
        // Rangée supérieure avec les lettres
        sb.append(" ");
        for (Cell cell : semiBoardPlayer1.getCells()) {
            sb.append(" ").append(cell.getLetter()).append(" ");
        }
        sb.append("\n");

        // Rangée supérieure avec les graines
        sb.append(" ");
        for (Cell cell : semiBoardPlayer1.getCells()) {
            sb.append("(").append(cell.getSeedNb()).append(")");
        }
        sb.append("\n");

        //SemiBoardDown
        // Rangée inférieure avec les graines
        sb.append(" ");
        for (Cell cell : semiBoardPlayer2.getCells()) {
            sb.append("(").append(cell.getSeedNb()).append(")");
        }
        sb.append("\n");

        // Rangée inférieure avec les lettres
        sb.append(" ");
        for (Cell cell : semiBoardPlayer2.getCells()) {
            sb.append(" ").append(cell.getLetter()).append(" ");
        }
        sb.append("\n");

        return sb.toString();
    }
}
