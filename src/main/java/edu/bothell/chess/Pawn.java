package edu.bothell.chess;

import java.util.Scanner;

public class Pawn extends Piece {

  Boolean firstMove;

  public Pawn(boolean team, Square square, B board) {
    super(team, square, board);
    this.firstMove = true;
  }

  // validate move method for pawn
  public boolean validateMove(Square x) {
    if (x.isEmpty()) {
      if (super.getColumn() == x.getColumn()) {
        if ((super.getRow() + 2 == x.getRow()) && super.team == true && firstMove) {
          if (checkInbetween(x)) {
            this.firstMove = false;
            return true;
          }

        } else if ((super.getRow() + 1 == x.getRow()) && (super.team == true)) {
          return true;
        }
        if ((super.getRow() - 2 == x.getRow()) && super.team == false && firstMove) {
          if (checkInbetween(x)) {
            this.firstMove = false;
            return true;
          }
        } else if ((super.getRow() - 1 == x.getRow()) && (super.team == false)) {
          return true;
        }
      }
    } else {
      if (super.team) {
        if ((super.getRow() + 1 == x.getRow())
            && ((super.getColumn() + 1 == x.getColumn()) || (super.getColumn() - 1 == x.getColumn()))) {
          return true;
        }
      } else {
        if ((super.getRow() - 1 == x.getRow())
            && ((super.getColumn() + 1 == x.getColumn()) || (super.getColumn() - 1 == x.getColumn()))) {
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