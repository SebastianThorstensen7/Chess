package edu.bothellhighschool.Chess;
import java.util.Scanner;

public class Pawn extends Piece {

  Boolean Team;
  Boolean firstMove;
  String pieceID;
  int row;
  int column;

  public Pawn(Boolean Team, String pieceID, int x, int y) {
    super(Team, pieceID, x, y);
    this.Team = Team;
    this.pieceID = pieceID;
    this.row = x;
    this.column = y;
    this.firstMove = true;
  }

  // validate move method for pawn
  public boolean validateMove(int row, int column, Square[][] state) {
    if (state[row][column].isNotOccupied()) {
      if (this.column == column) {
        if ((this.row + 2 == row) && this.team == true && firstMove) {
          if (state[this.row + 1][column].isNotOccupied()) {
            firstMove = false;
            this.row = row;
            return true;
          } else {
            return false;
          }
        } else if ((this.row + 1 == row) && (this.team == true)) {
          firstMove = false;
          this.row = row;
          return true;
        }
        if ((this.row - 2 == row) && this.team == false && firstMove) {
          if (state[this.row - 1][column].isNotOccupied()) {
            firstMove = false;
            this.row = row;
            return true;
          } else {
            return false;
          }
        } else if ((this.row - 1 == row) && (this.team == false)) {
          firstMove = false;
          this.row = row;
          return true;
        }
      }
      return false;
    } else {
      Piece p = state[row][column].getPiece();
      if (this.team != p.getTeam()) {
        if (this.team) {
          if ((this.row + 1 == row) && ((this.column + 1 == column) || (this.column - 1 == column))) {
            this.row = row;
            this.column = column;
            return true;
          } else {
            return false;
          }
        } else {
          if ((this.row - 1 == row) && ((this.column + 1 == column) || (this.column - 1 == column))) {
            this.row = row;
            this.column = column;
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
    if (Team) {
      return "♙";
    } else {
      return "♟";
    }
  }
}