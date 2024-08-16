import Model.*;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TicTacToeGame {
    Queue<Player> players;
    Board board;
    Scanner sc;
    TicTacToeGame(){
        sc=new Scanner(System.in);
        initializeGame();
    }

    private void initializeGame() {
        System.out.println("Enter the name of player 1: ");
        String p1Name = sc.nextLine();
        players = new LinkedList<>();
        PlayingPiece pieceX = new PieceX();
        Player player1 = new Player(p1Name,pieceX);
        players.add(player1);

        System.out.println("Enter the name of player 2: ");
        String p2Name = sc.nextLine();
        PlayingPiece pieceO = new Piece0();
        Player player2 = new Player(p2Name,pieceO);
        players.add(player2);

        System.out.println("Enter the size of board: ");
        int boardSize = sc.nextInt();
        board = new Board(boardSize);
    }
    public String startGame(){
        boolean winner = false;
        int moves = 0;
        Player player=null;
        while(!winner && moves < 9){
            board.printBoard();
            player = players.poll();
            boolean legalMove;
            int row,column;
            do{
                assert player != null;
                System.out.println(player.getName() + " turn.. \nEnter your move row and column: ");
                row = sc.nextInt();
                column = sc.nextInt();
                legalMove = board.makeMove(row,column,player.getPlayingPiece());
                if(!legalMove){
                    System.out.println("Invalid move");
                }
            }while(!legalMove);
            winner = board.getWinner(row,column,player.getPlayingPiece());
            players.add(player);
            moves++;
        }

        if(!winner)
            return "none(tie)";
        return player.getName();
    }
}
