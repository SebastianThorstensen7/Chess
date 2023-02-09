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
    pieces.add(new Rook(true, new Square(1,5), board));
    pieces.add(new Rook(false, new Square(1,4), board));
    board = new B(pieces);
    for(Piece P: pieces) {
      P.setBoard(board);
    }
  }
  
  @Test
  public void kingMoves() {
    //King checking if it can move to all the spaces around it
    System.out.println("Doing movement method");
    assertTrue(board.checkMove(4,4,3,3));
    assertTrue(board.checkMove(4,4,4,3));
    assertTrue(board.checkMove(4,4,5,3));
    assertTrue(board.checkMove(4,4,3,4));
    assertTrue(board.checkMove(4,4,5,4));
  }

  @Test
  public void castling() {
    
  }

  @Test
  public void cantMoveIntoCheck() {
    System.out.println("Doing check method");
    assertFalse(board.checkMove(4,4,3,5));
    assertFalse(board.checkMove(4,4,4,5));
    assertFalse(board.checkMove(4,4,5,5));
  }

}