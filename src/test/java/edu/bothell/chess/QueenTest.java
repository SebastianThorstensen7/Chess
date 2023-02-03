
package edu.bothell.chess;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import java.util.*;

import org.junit.Test;

public class QueenTest {
  B board;

  @Before
  public void setUp() {
    ArrayList<Piece> pieces = new ArrayList<Piece>();
    pieces.add(new Queen(true, new Square(4, 7), board));
    pieces.add(new Rook(false, new Square(5, 6), board));
    pieces.add(new Rook(true, new Square(1, 7), board));
    pieces.add(new Rook(false, new Square(4, 2), board));
    pieces.add(new Rook(true, new Square(4, 3), board));
    pieces.add(new Rook(false, new Square(4, 4), board));
    pieces.add(new Rook(true, new Square(4, 5), board));
    pieces.add(new Rook(true, new Square(3, 3), board));
    //pieces.add(new Rook(false, new Square(1, 2), board));
    //pieces.add(new Rook(true, new Square(1, 2), board));
    
    board = new B(pieces);
    for(Piece p: pieces) {
      p.setBoard(board);
    }
  }

    @Test
  public void queenShouldAnswerWithTrue() {
    assertTrue(board.checkMove(4,7,5,6));
    assertTrue(board.checkMove(4,7,3,6));
  }

  @Test
  public void queenShouldAnswerWithFalse() {
    assertFalse(board.checkMove(4,7,4,3));
    assertFalse(board.checkMove(4,7,3,3));
    assertFalse(board.checkMove(4,7,4,5));

  }
}