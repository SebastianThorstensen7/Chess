package edu.bothellhighschool.Chess;
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
  // Super method is king movement
  public boolean validateMove(int row, int column, Square[][] state) {
    if (state[row][column].isNotOccupied()) {
      if (this.column != column && this.row != row) {
        if ((this.column + 1 == column) || (this.column - 1 == column)) {
          if ((this.row + 1 == row) || (this.row - 1 == row )) {
            return true;
          }
        } 
      } else if((this.column != column) && (this.row == row) ) {
        if(this.column + 1 == column || this.column - 1 == column) {
          return true;
        } 
      } else if((this.column == column) && (this.row != row)) {
        if ((this.row + 1 == row) || (this.row - 1 == row )) {
            return true;
        } 
      } 
    } else {
      Piece p = state[row][column].getPiece();
      if(p.getTeam() != this.team) {
        return true;
      } 
    }
    return false;
  }

  public void setRow(int row) {
    this.row = row;
  }

  public int getRow() {
    return this.row;
  }

  public void setColumn(int column) {
    this.column = column;
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