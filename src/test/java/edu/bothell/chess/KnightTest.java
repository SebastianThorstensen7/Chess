package edu.bothell.chess;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.*;

import org.junit.Test;
import java.util.ArrayList;

public class KnightTest {
  B board1 = new B();
  ArrayList<Piece> pieces = new ArrayList<Piece>();
  private Square[][] board = new Square[8][8];

  public void setPieces() {
    pieces.add(new Knight(true, new Square(4, 3), board1));
    pieces.add(new Knight(false, new Square(5, 1), board1));
    pieces.add(new Knight(true, new Square(1, 7), board1));
    pieces.add(new Knight(false, new Square(2, 2), board1));
    setBoard(board);
  }

  @Test
  public void rookShouldAnswerWithFalse() {
    assertFalse(board1.checkMove(2, 2, 5, 12));
  }

  public void setBoard(Square[][] board) {

    for (int y = 0; y < board.length; y++) {
      for (int x = 0; x < board[y].length; x++) {
        this.board[y][x] = new Square(x, y);
        for (Piece p : pieces) {
          if (p.getRow() == y && p.getColumn() == x) {
            board[y][x].setPiece(p);
          }
        }
      }
    }
  }

}
