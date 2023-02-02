package edu.bothell.chess;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.*;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class RookTest {

  B board;

  @Before
  public void setPieces() {
    ArrayList<Piece> pieces = new ArrayList<Piece>();
    pieces.add(new Rook(true, new Square(4, 3), board));
    pieces.add(new Pawn(false, new Square(5, 1), board));
    pieces.add(new Rook(true, new Square(4, 5), board));
    pieces.add(new Queen(false, new Square(4, 7), board));
    pieces.add(new Pawn (true, new Square(5,3), board));
    board = new B(pieces);
    for(Piece P: pieces) {
      P.setBoard(board);
    }
  }

  @Test
  public void rookShouldAnswerWithFalse() {
    // if the piece is on the same team:
    assertFalse(board.checkMove(4, 3, 4, 5));
    // if the piece is changing both x and y coordinate:
    assertFalse(board.checkMove(4, 3, 5, 4));
    // if there is a piece in the way of a take:
    assertFalse(board.checkMove(4, 3, 4, 7));
    // if there is a piece in the way of a move:
    assertFalse(board.checkMove(4, 3, 6, 3));
  }

  @Test
  public void rookShouldAnswerWithTrue() {
    assertTrue(board.checkMove(4,3,0,3));
    assertTrue(board.checkMove(4,3,4,0));
  }
}
