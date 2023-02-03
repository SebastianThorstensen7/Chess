package edu.bothell.chess;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.*;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class KnightTest {

  B board;

  @Before
  public void setPieces() {
    ArrayList<Piece> pieces = new ArrayList<Piece>();
    pieces.add(new Knight(true, new Square(4, 3), board));
    pieces.add(new Pawn(false, new Square(5, 1), board));
    pieces.add(new Pawn(false, new Square(6, 2), board));
    pieces.add(new Pawn(true, new Square(5, 5), board));
    pieces.add(new Pawn(false, new Square(6, 7), board));
    pieces.add(new Pawn(false, new Square(2, 2), board));
    pieces.add(new Pawn(false, new Square(6, 3), board));
    board = new B(pieces);
    for (Piece P : pieces) {
      P.setBoard(board);
    }
  }

  @Test
  public void KnightShouldAnswerWithFalse() {
    //Knight trying to go to a spot with a same team piece
    assertFalse(board.checkMove(4, 3, 6, 3));
    assertFalse(board.checkMove(4, 3, 6, 7));
    assertFalse(board.checkMove(4, 3, 5, 5));
  }

  
  @Test
  public void KnightShouldAnswerWithTrue() {
    //Knight trying to go to a spot with a diff team piece, that abides by knight logic
    assertTrue(board.checkMove(4, 3, 2, 2));
    assertTrue(board.checkMove(4, 3, 5, 1));
    assertTrue(board.checkMove(4, 3, 6, 2));
    //Knight trying to go to an empty spot that abides by knight logic
    assertTrue(board.checkMove(4, 3, 3, 5));
  }

}
