package edu.bothell.chess;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.*;

import org.junit.Test;
import java.util.ArrayList;

public class RookTest {
  B board1 = new B();
  ArrayList<Piece> pieces = new ArrayList<Piece>();
  private Square[][] board = new Square[8][8];

  public void setPieces() {
    pieces.add(new Rook(true, new Square(4, 3), board1));
    pieces.add(new Pawn(false, new Square(5, 1), board1));
    pieces.add(new Rook(true, new Square(4, 5), board1));
    pieces.add(new Queen(false, new Square(4, 7), board1));
    pieces.add(new Pawn (true, new Square(5,3), board1));
    setBoard(board);
  }

  @Test
  public void knightShouldAnswerWithFalse() {
    // if the piece is on the same team:
    assertFalse(board1.checkMove(4, 3, 4, 5));
    // if the piece is changing both x and y coordinate:
    assertFalse(board1.checkMove(4, 3, 5, 4));
    // if there is a piece in the way of a take:
    assertFalse(board1.checkMove(4, 3, 4, 7));
    // if there is a piece in the way of a move:
    assertFalse(board1.checkMove(4, 3, 6, 3));
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
