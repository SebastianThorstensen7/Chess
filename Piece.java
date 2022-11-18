import java.util.Scanner;

public class Piece {
  // Fields -- or state variables
  // what our Piece has
  Boolean team;
  String pieceID;
  int row;
  int column;

  // Constructor
  public Piece(Boolean Team, String pieceID, int row, int column) {
    this.team = Team;
    this.pieceID = pieceID;
    this.row = row;
    this.column = column;
  }

  // Methods -- or functions ==> what our class can do

  public void move(Scanner scn) {

  }

  // validate move method
  public boolean validateMove(int row, int column, Square[][] state) {
    if (state[column][row].isNotOccupied()) {
      if (this.column != column && this.row != row) {
        if ((this.column + 1 == column) || (this.column - 1 == column)) {
          if ((this.row + 1 == row) || (this.row - 1 == row )) {
            this.column = column;
            this.row = row;
            return true;
          }
        } else {
          return false;
        }
      } else if((this.column != column) && (this.row == row) ) {
        if(this.column + 1 == column || this.column - 1 == column) {
          this.column = column;
          return true;
        } else {
          return false;
        }
      } else if((this.column == column) && (this.row != row)) {
        if ((this.row + 1 == row) || (this.row - 1 == row )) {
            this.row = row;
            return true;
        } else {
          return false;
        }
      }

      return true;
    } else if (state[column][row].getPiece().getTeam() != this.team) {
      return true;
    } else {
      return false;
    }
  }

  public int getRow() {
    return this.row;
  }

  public int getColumn() {
    return this.column;
  }

  public String getPieceID() {
    return this.pieceID;
  }

  public boolean getTeam() {
    return this.team;
  }

}