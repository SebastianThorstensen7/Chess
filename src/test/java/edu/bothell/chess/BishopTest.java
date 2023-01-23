package edu.bothell.chess;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.*;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class BishopTest {

  B board1 = new B();
  ArrayList<Piece> pieces  = new ArrayList<Piece>();
  private Square[][] board = new Square[8][8];
  @Test
  public void bishopShouldAnswerWithFalse() {
    assertFalse(board1.checkMove(2, 2, 5, 12));
  }

  public void setPieces(){
    pieces.add(new Bishop(true, new Square(4,3), board1));
    pieces.add(new Rook(false, new Square(5,1), board1));
    pieces.add(new Queen(true, new Square(1,7), board1));
    pieces.add(new Knight(false, new Square(2,2), board1));
    init(board);
  }
  
   public void init(Square[][] board){

    for (int y = 0; y < board.length; y++) {
      for(int x = 0; x < board[y].length; x++){
        this.board[y][x] = new Square(x,y);
        for(Piece p : pieces){
          if( p.getRow() == y && p.getColumn() == x ) {
            board[y][x].setPiece(p);
          }
        }
      }
    }
  }
}
