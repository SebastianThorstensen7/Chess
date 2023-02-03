
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
    pieces.add(new Rook(true, new Square(5, 2), board));
    pieces.add(new Rook(false, new Square(5, 6), board));
    pieces.add(new Rook(true, new Square(1, 6), board));
    pieces.add(new Rook(false, new Square(1, 2), board));
    pieces.add(new Pawn(false, new Square(7,0), board));
    board = new B(pieces);
    for(Piece p: pieces) {
      p.setBoard(board);
    }
  }
  
  @Test
  public void bishopShouldAnswerWithTrue() {
    //Bishop trying to go to spots with diff team pieces
    assertTrue(board.checkMove(3,4,1,2));
    assertTrue(board.checkMove(3,4,5,6));
    //Bishops basic movement
    assertTrue(board.checkMove(3,4,2,3));
    assertTrue(board.checkMove(3,4,4,3));
    assertTrue(board.checkMove(3,4,2,5));
    assertTrue(board.checkMove(3,4,4,5));
  }

  @Test
  public void bishopShouldAnswerWithFalse() {
    //Bishop trying to go to spots with same team pieces
    assertFalse(board.checkMove(3,4,5,2));
    assertFalse(board.checkMove(3,4,1,6));
    //Bishop trying to go to spot when piece is in the way
    assertFalse(board.checkMove(3,4,6,1));
    assertFalse(board.checkMove(3,4,0,1));
    //Bishop trying to go to spot with takeable piece but piece in way
    assertFalse(board.checkMove(3,4,0,7));
  }
  
}
