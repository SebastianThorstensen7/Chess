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
  B board2;

  @Before
  public void setUp() {
    ArrayList<Piece> pieces = new ArrayList<Piece>();
    pieces.add(new King(  false,new Square(4,4),  board));
    pieces.add(new Rook(  false,new Square(1,4),  board));
    ArrayList<Piece> pieces2 = new ArrayList<Piece>();
    pieces2.add(new King(  false,new Square(4,4),  board2));
    pieces2.add(new Bishop(true, new Square(4,2),  board2));
    pieces2.add(new Rook(  true, new Square(0,5),  board2));
    pieces2.add(new Rook(  true, new Square(0,4),  board2));
    board = new B(pieces);
    board2 = new B(pieces2);
    for(Piece P: pieces) {
      P.setBoard(board);
    }
    for(Piece P: pieces2) {
      P.setBoard(board2);
    }
  }

  
  @Test
  public void kingMoves() {
    //King checking if it can move to all the spaces around it
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


  /*
  @Test
  public void cantMoveIntoCheck() {
    //makes sure the king cant move in the way of a piece that can capture it
    assertFalse(board2.checkMove(4,4,3,4));
    // this test below breaks because the kings destination is blocked by the king, so the rook returns false
    assertFalse(board2.checkMove(4,4,5,4));
    assertFalse(board2.checkMove(4,4,4,5));
    assertFalse(board2.checkMove(4,4,3,5));
    assertFalse(board2.checkMove(4,4,5,5));
    assertFalse(board2.checkMove(4,4,3,3));
    assertFalse(board2.checkMove(4,4,5,3));
    assertTrue(board2.checkMove(4,4,4,3));
  }
  */
}