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

    if (super.getColumn() + 2 == x.getColumn() || super.getColumn() - 2 == x.getColumn()) {
      if (super.getRow() + 1 == x.getRow() || super.getRow() - 1 == x.getRow()) {
        if (x.isEmpty()) {
          return true;
        } else if (super.getTeam() != x.getPiece().getTeam()) {
          return true;
        }
      }
    } else if (super.getColumn() + 1 == x.getColumn() || super.getColumn() - 1 == x.getColumn()) {
      if (super.getRow() + 2 == x.getRow() || super.getRow() - 2 == x.getRow()) {
        if (x.isEmpty()) {
          return true;
        } else if (super.getTeam() != x.getPiece().getTeam()) {
          return true;
        }
      }
    } else if (super.getRow() + 1 == x.getRow() || super.getRow() - 1 == x.getRow()) {
      if (super.getColumn() + 2 == x.getColumn() || super.getColumn() - 2 == x.getColumn()) {
        if (x.isEmpty()) {
          return true;
        } else if (super.getTeam() != x.getPiece().getTeam()) {
          return true;
        }
      }
    } else if (super.getRow() + 2 == x.getRow() || super.getRow() - 2 == x.getRow()) {
      if (super.getColumn() + 1 == x.getColumn() || super.getColumn() - 1 == x.getColumn()) {
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
      return "♘";
    } else {
      return "♞";
    }
  }
}