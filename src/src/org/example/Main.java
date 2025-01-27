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
        System.out.println(board.displayBoard());

        //test pour la méthode saw de Board
        semiBoardUp.getCells().getLast().setSeedNb(4);
        board.saw(semiBoardUp, 6);

        System.out.println("État après semis :");
//        for (Cell cell : semiBoardUp.getCells()) {
//            System.out.print("(" + cell.getSeedNb() + ") ");
//        }
//        System.out.println();

        System.out.println(board.displayBoard());

    }
}