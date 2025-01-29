package org.example;

public class Main {
    public static void main(String[] args) {

        //Initialisation des joueurs
        Player playerOne = new Player(2, "Player One", 1);
        Player playerTwo = new Player(0, "Player Two", 2);

        // Initialisation des semi-boards
        SemiBoard semiBoardUp = new SemiBoard(playerOne);
        semiBoardUp.setCells();

        SemiBoard semiBoardDown = new SemiBoard(playerTwo);
        semiBoardDown.setCells();

        // Initialisation du board
        Board board = new Board();
        board.setSemiBoardUp(semiBoardUp);
        board.setSemiBoardDown(semiBoardDown);

        //test pour la méthode saw de Board
        semiBoardDown.getCells().getLast().setSeedNb(4);

        System.out.println(board.displayBoard());

        board.saw(0, 5);

        System.out.println(playerOne);

        System.out.println("État après semis :");

        System.out.println(board.displayBoard());

    }
}