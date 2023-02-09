package edu.bothell.chess;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

/**
 * Test(s) for Pawn piece
 */
public class PawnTest {

  B board;

  @Before
  public void setUp() {
    ArrayList<Piece> pieces = new ArrayList<Piece>();
    pieces.add(new Pawn(false,new Square(5,5), board));
    pieces.add(new Pawn(false,new Square(3,5), board));
    pieces.add(new Pawn(true ,new Square(4,4), board));
    pieces.add(new Pawn(true ,new Square(5,4), board));
    board = new B(pieces);
    for(Piece P: pieces) {
      P.setBoard(board);
    }
  }
  
  @Test
  public void firstMoveWorks() {
    //Single pawm moving 2 spaces forward
    assertTrue(board.checkMove(3,5,3,3));
    //pawn attempting to move 2 forward, but blocked by a piece in the way
    assertFalse(board.checkMove(5,5,5,3));
  }

  @Test
  public void doesntMoveWrong() {
    //doesn't allow moves left, right, or down(down being relative to the specific pawn)
    assertFalse(board.checkMove(5,5,5,6));
    assertFalse(board.checkMove(5,5,6,5));
    assertFalse(board.checkMove(5,5,4,5));
  }

  @Test
  public void takesPiecesCorrectly() {
    //Pawn trying to take a piece right in front of it
    assertFalse(board.checkMove(5,5,5,4));
    //Pawn taking a piece properly
    assertTrue(board.checkMove(5,5,4,4));
  }

  @Test
  public void enPassant() {
    //assertTrue(board.checkMove());
    //assertTrue(board.checkMove());
  }

  @Test
  public void promotion() {
    
  }
  
}