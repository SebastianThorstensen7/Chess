//Sebastian Thorstensen
//Chess
//AP JAVA PROJECT ADVANCED
//9.6.22

/*
This is chess. Currently all pieces can be moved with some having move validation being worked, pieces can be taken and stored away, and you can now select a piece by feeding the console the coordinates instead of being forced to use the pieces ID. Next step is probably more move validation and then making the logic for check and check mate.
*/

import java.util.ArrayList;

class Main {
  public static void main(String[] args) {
    System.out.println();

    ArrayList<Piece> pieces = new ArrayList<Piece>();

    for (int i = 0; i < 8; i++) {
      pieces.add(new Pawn(true, "P" + (i + 1), 1, i));
    }
    for (int k = 0; k < 2; k++) {
      pieces.add(new Rook(true, "R" + (k + 1), 0, (k * 7)));
      pieces.add(new Knight(true, "KN" + (k + 1), 0, (k * 5) + 1));
      pieces.add(new Bishop(true, "B" + (k + 1), 0, (k * 3) + 2, pieces));
    }
    pieces.add(new King(true, "K", 0, 4));
    pieces.add(new Queen(true, "Q", 0, 3));

    for (int j = 0; j < 8; j++) {
      pieces.add(new Pawn(false, "P" + (j + 1), 6, j));
    }
    for (int k = 0; k < 2; k++) {
      pieces.add(new Rook(false, "R" + (k + 1), 7, (k * 7)));
      pieces.add(new Knight(false, "KN" + (k + 1), 7, (k * 5) + 1));
      pieces.add(new Bishop(false, "B" + (k + 1), 7, (k * 3) + 2, pieces));
    }
    pieces.add(new King(false, "K", 7, 4));
    pieces.add(new Queen(false, "Q", 7, 3));

   // Chessgame standardGame = new Chessgame(pieces);
   // standardGame.play();

    
    ArrayList<Piece> rookStuff = new ArrayList<Piece>();
    rookStuff.add(new Rook(false, "R", 4,5));

    Chessgame rookTest = new Chessgame(rookStuff);
    rookTest.play();
    
  }
}