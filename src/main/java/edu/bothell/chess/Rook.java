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

  public boolean hasMoved = false;

  public Rook(boolean team, Square square, B board) {
    super(team, square, board);
  }

  public void move(Scanner scn) {
    super.move(scn);
    System.out.println("Rook move");
  }

  // validate move method for Rook
  public boolean validateMove(Square x) {
    if (x.getRow() == super.getRow() || x.getColumn() == super.getColumn()) {
      if (x.isEmpty()) {
        hasMoved = true;
        return true;
      }
        else if (super.getTeam() != x.getPiece().getTeam()) {
        hasMoved = true;
        return true;
      }
    }
    return false;
  }

  public boolean getMoved(){
    return hasMoved;
  }

  public String toString() {
    if (super.getTeam()) {
      return "♖";
    } else { 
      return "♜";
    }
  }
}