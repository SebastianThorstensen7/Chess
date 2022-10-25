//Sebastian Thorstensen
//Chess
//AP JAVA PROJECT ADVANCED
//9.6.22

/*
This is chess. Currently the board can be created with the pieces in the correct places. I am working on being able to validate piece moves to have them move the way the pieces are intended to move. After that I think I will start working on the logic of the game.

*/

import java.util.ArrayList;

class Main {
  public static void main(String[] args) {
    System.out.println();

    ArrayList<Piece> Pieces = new ArrayList<Piece>();

    for (int i = 0; i < 8; i++) {
      Pieces.add(new Pawn(true, "P" + i, 1, i));
    }
    for (int k = 0; k < 2; k++) {
      Pieces.add(new Rook(true, "R" + k, 0, (k * 7)));
      Pieces.add(new Knight(true, "KN" + k, 0, (k * 5) + 1));
      Pieces.add(new Bishop(true, "B" + k, 0, (k * 3) + 2));
    }
    Pieces.add(new King(true, "K", 0, 4));
    Pieces.add(new Queen(true, "Q", 0, 3));

    for (int j = 0; j < 8; j++) {
      Pieces.add(new Pawn(false, "P" + j, 6, j));
    }
    for (int k = 0; k < 2; k++) {
      Pieces.add(new Rook(false, "R" + k, 7, (k * 7)));
      Pieces.add(new Knight(false, "KN" + k, 7, (k * 5) + 1));
      Pieces.add(new Bishop(false, "B" + k, 7, (k * 3) + 2));
    }
    Pieces.add(new King(false, "K", 7, 4));
    Pieces.add(new Queen(false, "Q", 7, 3));

    Board Board = new Board(Pieces);
    Board.selectPiece();
    Board.updateState();
    Board.switchTeam();
    Board.selectPiece();
    Board.updateState();
    

    System.out.println();
    System.out.println();
    System.out.println("I Work!");
    System.out.println();
    System.out.println();
  }
}