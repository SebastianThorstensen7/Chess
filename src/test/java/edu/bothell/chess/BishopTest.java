
package edu.bothell.chess;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import java.util.*;

import org.junit.Test;

/**
 * Unit test for simple App.
 */

public class BishopTest {

  B board;


  @Before
  public void setUp() {
      ArrayList<Piece> pieces = new ArrayList<Piece>();
    pieces.add(new Bishop(true, new Square(3, 4), board));
    pieces.add(new Rook(true, new Square(4, 3), board));
    pieces.add(new Rook(false, new Square(5, 6), board));
    pieces.add(new Rook(true, new Square(1, 7), board));
    pieces.add(new Rook(false, new Square(1, 2), board));
    board = new B(pieces);
    for(Piece p: pieces) {
      p.setBoard(board);
    }
  }
  
  @Test
  public void bishopShouldAnswerWithTrue() {
    assertTrue(board.checkMove(3,4,1,2));
    assertTrue(board.checkMove(3,4,5,6));
  }

  @Test
  public void bishopShouldAnswerWithFalse() {
    assertTrue(board.checkMove(3,4,4,3));
    assertTrue(board.checkMove(3,4,1,7));
    assertTrue(board.checkMove(3,4,3,3));
  }
  
}
