package org.example;

public class Main {
    public static void main(String[] args) {

        //Initialisation des joueurs
        Player playerOne = new Player(0, "Player One", 1);
        Player playerTwo = new Player(0, "Player Two", 2);

        // Initialisation des semi-boards
        SemiBoard semiBoardUp = new SemiBoard(playerOne);
        semiBoardUp.setCells();

        SemiBoard semiBoardDown = new SemiBoard(playerTwo);
        semiBoardDown.setCells();

        // Initialisation du board
        Board board = new Board();
        board.setSemiBoardPlayer1(semiBoardUp);
        board.setSemiBoardPlayer2(semiBoardDown);

        // Affichage du board
        System.out.println(board.display());
    }
}