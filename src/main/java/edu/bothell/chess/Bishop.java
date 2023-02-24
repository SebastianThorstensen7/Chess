
//Manas Kumar is in charge of this file
//10/24/2022
//P3
//I will be making changes to this file
package edu.bothell.chess;

import java.util.*;

public class Bishop extends Piece {

  //////////////////////////////////////////////////////////
  // BETTER CONSTRUCTOR FOR BISHOP!!!!!
  //////////////////////////////////////////////////////////
  public Bishop(boolean team, Square square, B board) {
    super(team, square, board);
  }

  // Validate move method for bishop
  /**
   * Sebastian: Things to help you update the code
   * Starting coordinates are now got with super.getRow() and super.getColumn()
   * Destination coordinates are now got with x.getRow() and x.getColumn()
   * Don't worry about the check Inbetween method I'll be working on it
   */
  public boolean validateMove(Square x) {
    if (x.getRow() != super.getRow() && x.getColumn() != super.getColumn()) {
      if (Math.abs((x.getRow() - super.getRow()) / (x.getColumn() - super.getColumn())) == 1) {
        if (x.isEmpty()) {
          return true;
        } else if (super.getTeam() != x.getPiece().getTeam()) {
          return true;
        }
      }
    }
    return false;
  }

  public String toString() {
    if (super.getTeam()) {
      return "♗";
    } else {
      return "♝";
    }
  }
}
