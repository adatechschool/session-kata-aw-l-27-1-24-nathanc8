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

        //test pour la méthode saw de Board
        semiBoardUp.getCells().getLast().setSeedNb(4);

        System.out.println(board.displayBoard());

        board.saw(1, 5);

        System.out.println("État après semis :");

        System.out.println(board.displayBoard());

    }
}