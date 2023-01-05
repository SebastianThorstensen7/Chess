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

  Boolean Team;
  String pieceID;
  int row;
  int column;

  public Knight(Boolean Team, String pieceID, int row, int column) {
    super(Team, pieceID, row, column);
  }

  public void move(Scanner scn) {
    super.move(scn);
    System.out.println("Knight move");
  }

  // validate move method for Knight
  public boolean validateMove(Square x) {
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