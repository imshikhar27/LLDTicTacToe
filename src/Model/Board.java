package Model;

import java.util.ArrayList;

public class Board {
    int size;
    PlayingPiece[][] board;
    public Board(int size) {
        this.size = size;
        this.board = new PlayingPiece[size][size];
    }
    public boolean makeMove(int row,int column,PlayingPiece piece) {
        if(row<0 || column<0 || row>=size || column>=size || board[row][column]  != null) {
            return false;
        }
        board[row][column] = piece;
        return true;
    }

    public boolean getWinner(int row, int column, PlayingPiece playingPiece) {
        boolean rowWinner = true, columnWinner = true,diagonalWinner = true,reverseDiagonalWinner = true;
        for(int i=0;i<size;i++) {
            if(board[i][column] != playingPiece) {
                rowWinner = false;
            }
            if(board[row][i] != playingPiece) {
                columnWinner = false;
            }
            if(board[i][i] != playingPiece) {
                diagonalWinner = false;
            }
            if(board[i][size-i-1] != playingPiece) {
                reverseDiagonalWinner = false;
            }
        }

        return rowWinner||columnWinner||diagonalWinner||reverseDiagonalWinner;
    }

    public void printBoard() {
        for(int i=0;i<size;i++) {
            for(int j=0;j<size;j++) {
                if(board[i][j] != null)
                    System.out.print(board[i][j].pieceType + " |");
                else
                    System.out.print( "  |");
            }
            System.out.println();
        }
    }
//    public List<Pair<Integer, Integer>> getLegalMoves() {
//        List<Pair<Integer, Integer>> legalMoves = new ArrayList<Pair<Integer, Integer>>();
//        for (int i = 0; i < size; i++) {
//            for (int j = 0; j < size; j++) {
//                if (board[i][j] != null) {
//                    Pair<Integer,Integer> rowColumn= new Pair<Integer,Integer>(i, j);
//                    legalMoves.add(rowColumn);
//                }
//            }
//        }
//    }
}
