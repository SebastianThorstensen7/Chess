// khushi singh
// 12.08.2022
// p.3
// team chess 

// i own knight
// am responsible for move validation

// this.x = original

package edu.bothell.chess;

import java.util.Scanner;

public class Knight extends Piece {

  public Knight(Boolean team, Square square, B board) {
    super(team, square, board);
  }

  public void move(Scanner scn) {
    super.move(scn);
    System.out.println("Knight move");
  }

  // validate move method for Knight
  /**
   * Sebastian: Things to help you update the code 
   * Starting coordinates are now got with super.getRow() and super.getColumn()
   * Destination coordinates are now got with x.getRow() and x.getColumn()
   * Don't worry about the check Inbetween method I'll be working on it
   */
  public boolean validateMove(Square x) {
    //Put code here, make sure to delete the line below after you're done
    return super.validateMove(x);
  }

  public String toString() {
    if (super.getTeam()) {
      return "♘";
    } else {
      return "♞";
    }
  }
}