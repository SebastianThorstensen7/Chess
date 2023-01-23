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
    pieces.add(new Pawn(false,new Square(5,5),board));
    board = new B(pieces);
  }
  
  @Test
  public void firstMovePawn() {
    //board.checkMove(5,5,5,3);
    assertFalse(board.checkMove(5,3,5,1));
  }

}