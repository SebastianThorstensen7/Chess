package edu.bothell.chess;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

/**
* Test(s) for King
*/
public class KingTest {

  B board;

  @Before
  public void setUp() {
    ArrayList<Piece> pieces = new ArrayList<Piece>();
    pieces.add(new King(false, new Square(4,4),board));
    board = new B(pieces);
    for(Piece P: pieces) {
      P.setBoard(board);
    }
  }
  
  @Test
  public void kingMoves() {
    assertTrue(board.checkMove(4,4,3,3));
    assertTrue(board.checkMove(4,4,4,3));
    assertTrue(board.checkMove(4,4,5,3));
    assertTrue(board.checkMove(4,4,3,4));
    assertTrue(board.checkMove(4,4,5,4));
    assertTrue(board.checkMove(4,4,3,5));
    assertTrue(board.checkMove(4,4,4,5));
    assertTrue(board.checkMove(4,4,5,5));
  }

  @Test
  public void castling() {
    
  }

  @Test
  public void cantMoveIntoCheck() {
    
  }
  
}