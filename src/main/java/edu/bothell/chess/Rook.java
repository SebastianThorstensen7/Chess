// khushi singh
// 10.25.2022
// p.3
// team chess 

// i own rook
// am responsible for move validation

// this.x = original

package edu.bothell.chess;

import java.util.Scanner;

public class Rook extends Piece {



  public Rook(boolean team, int column, int row, B board){
    super(team, column, row, board);
  }
  
  public Rook(boolean Team, String pieceID, int row, int column) {
    super(Team, pieceID, row, column);
  }

  public void move(Scanner scn) {
    super.move(scn);
    System.out.println("Rook move");
  }

  // validate move method for Rook
  public boolean validateMove(Square x,Square[][] board) {
      boolean validMove       = false;
      //code goes here
      boolean noPeacesBetween = checkInbetween(board);
      if(validMove && noPeacesBetween) {
        return true;
      }
      return false;
    }

  public String toString() {
    if (super.getTeam()) {
      return "♖";
    } else {
      return "♜";
    }
  }
}