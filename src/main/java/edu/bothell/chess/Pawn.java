package edu.bothell.chess;

import java.util.Scanner;

public class Pawn extends Piece {

  Boolean Team;
  Boolean firstMove;
  String pieceID;
  int row;
  int column;

  public Pawn(Boolean Team, String pieceID, int x, int y) {
    super(Team, pieceID, x, y);
    this.firstMove = true;
  }

  // validate move method for pawn
  public boolean validateMove(int row, int column, Square[][] state) {
    if (state[row][column].isNotOccupied()) {
      if (super.column == column) {
        if ((super.row + 2 == row) && super.team == true && firstMove) {
          if (state[super.row + 1][column].isNotOccupied()) {
            firstMove = false;
            return true;
          } else {
            return false;
          }
        } else if ((super.row + 1 == row) && (super.team == true)) {
          firstMove = false;
          return true;
        }
        if ((super.row - 2 == row) && super.team == false && firstMove) {
          if (state[super.row - 1][column].isNotOccupied()) {
            firstMove = false;
            return true;
          } else {
            return false;
          }
        } else if ((super.row - 1 == row) && (super.team == false)) {
          firstMove = false;
          return true;
        }
      }
      return false;
    } else {
      Piece p = state[row][column].getPiece();
      if (super.team != p.getTeam()) {
        if (super.team) {
          if ((super.row + 1 == row) && ((super.column + 1 == column) || (super.column - 1 == column))) {
            return true;
          } else {
            return false;
          }
        } else {
          if ((super.row - 1 == row) && ((super.column + 1 == column) || (super.column - 1 == column))) {
            return true;
          } else {
            return false;
          }
        }
      } else {
        return false;
      }
    }
  }

  public String toString() {
    if (super.getTeam()) {
      return "♙";
    } else {
      return "♟";
    }
  }
}