
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
  Bishop b = new Bishop(true, new Square(3,7), board1);
  
  @Test
  public void bishopShouldAnswerWithFalse() {
    setPieces();
  }

  public void setPieces(){
    pieces.add(b);
    pieces.add(new Rook(true, new Square(4,3), board1));
    pieces.add(new Rook(false, new Square(5,1), board1));
    pieces.add(new Rook(true, new Square(1,7), board1));
    pieces.add(new Rook(false, new Square(2,2), board1));
    setBoard(board);
  }
  
   public void setBoard(Square[][] board){
    boolean validation = false;
    for (int y = 0; y < board.length; y++) {
      for(int x = 0; x < board[y].length; x++){
        this.board[y][x] = new Square(x,y);
        assertFalse(board1.checkMove(b.getRow(), b.getColumn(), x, y)); //
        for(Piece p : pieces){
          if( p.getRow() == y && p.getColumn() == x ) {
            board[y][x].setPiece(p);
          }
        }
        System.out.println(checkValidation(validation, board[x][y]));
        System.out.println(checkOpposTeam(board[x][y]));
      }
    }
  }

  //First Test
  public boolean checkValidation(boolean validation, Square square) {
    if (Math.abs((square.getRow() - b.getRow()) / (square.getColumn() - b.getColumn())) == 1) {
      validation = true;
    } else if (Math.abs((square.getRow() - b.getRow()) / (square.getColumn() - b.getColumn())) != 1) {
      validation = false;
    }
    return validation;
  }

  //Second Test
  public boolean checkOpposTeam(Square square){
    boolean canAttack = false;
    if(square.isTeam(b.getTeam()) == b.getTeam()){
      canAttack = false;
    }
    else if(square.isTeam(b.getTeam()) != b.getTeam()){
      canAttack = true;
    }
    return canAttack;
  }
}

