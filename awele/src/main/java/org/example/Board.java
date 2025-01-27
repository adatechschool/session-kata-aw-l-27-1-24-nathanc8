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
        return "";
    }
}
