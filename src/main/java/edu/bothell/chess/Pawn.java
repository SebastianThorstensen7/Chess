package edu.bothell.chess;

import java.util.Scanner;

public class Pawn extends Piece {


  public Pawn(boolean team, Square square, B board) {
    super(team, square, board);
  }

  // validate move method for pawn
  public boolean validateMove(Square x) {
    if (x.isEmpty()) {
      if (super.getColumn() == x.getColumn()) {
        if ((super.getRow() + 2 == x.getRow()) && super.team == true && !getMoved()) {
          if (checkInbetween(x)) {
            hasMoved();
            return true;
          }

        } else if ((super.getRow() + 1 == x.getRow()) && (super.team == true)) {
          return true;
        }
        if ((super.getRow() - 2 == x.getRow()) && super.team == false && !getMoved()) {
          if (checkInbetween(x)) {
            hasMoved();
            return true;
          }
        } else if ((super.getRow() - 1 == x.getRow()) && (super.team == false)) {
          hasMoved();
          return true;
        }
      }
    } else {
      if (super.team) {
        if ((super.getRow() + 1 == x.getRow())
            && ((super.getColumn() + 1 == x.getColumn()) || (super.getColumn() - 1 == x.getColumn()))) {
          hasMoved();
          return true;
        }
      } else {
        if ((super.getRow() - 1 == x.getRow())
            && ((super.getColumn() + 1 == x.getColumn()) || (super.getColumn() - 1 == x.getColumn()))) {
          hasMoved();
          return true;
        }
      }
    }

    return false;
  }

  public String toString() {
    if (super.getTeam()) {
      return "♙";
    } else {
      return "♟";
    }
  }
}