package edu.bothell.chess;

import java.util.Scanner;

public class Piece {
  // Fields -- or state variables
  // what our Piece has
  boolean team;
  private Square square;
  private B state;

  /**
   * GUS: New constructore for a Piece -- adding a board and removing the ID
   * rows and columns seem backwards to me?
   * 
   * @param team   boolean
   * @param row    int
   * @param column int
   * @param board  Board type with Square[][] and ArrayList<Piece>
   */
  public Piece(boolean team, Square square, B state) {
    this.team = team;
    this.square = square;
    this.state = state;
  }

  ///////////////////////////////////////////////
  // METHODS of CHESS PIECE(s)
  ///////////////////////////////////////////////
  /**
   * GUS: Starts the process of checking a move.
   * Can Override for specific pieces
   * 
   * @param x X marks the spot of the Square to move to
   * @retrun boolean saying if the move is OK
   */

  public void setSquare(Square square) {
    this.square = square;
  }

  public void move(Scanner scn) {

  }

  // validate move method
  // Super method is king movement
  public boolean validateMove(Square x) {
    if (x.isTeam(team))
      return false;
    if (this.getColumn() != x.getColumn() && this.getRow() != x.getRow()) {
      if ((this.getColumn() + 1 == x.getColumn()) || (this.getColumn() - 1 == x.getColumn())) {
        if ((this.getRow() + 1 == x.getRow()) || (this.getRow() - 1 == x.getRow())) {
          return true;
        }
      }
    } else if ((this.getColumn() != x.getColumn()) && (this.getRow() == x.getRow())) {
      if (this.getColumn() + 1 == x.getColumn() || this.getColumn() - 1 == x.getColumn()) {
        return true;
      }
    } else if ((this.getColumn() == x.getColumn()) && (this.getRow() != x.getRow())) {
      if ((this.getRow() + 1 == x.getRow()) || (this.getRow() - 1 == x.getRow())) {
        return true;
      }
    }
    return false;
  }

  // Method to check if there a pieces between a location and destination
  public boolean checkInbetween(Square end) {
    int rowDirect = getDirection(this.getRow() - end.getRow());
    int columnDirect = getDirection(this.getColumn() - end.getColumn());
    for(int x = this.getRow(); x < end.getRow(); x = x + rowDirect) {
      for(int y = this.getColumn(); y < end.getColumn(); y = x + columnDirect) {
        Square square = state.getSquare(x,y);
        if(!square.isEmpty()) {
          System.out.println("Piece between");
          return false;
        }
      }
    }
    System.out.println("No pieces between");
    return true;
  }

  public int getDirection(int direction) {
    if (direction <= -1) {
      return -1;
    } else if (direction >= 1) {
      return 1;
    } else {
      return 0;
    }
  }

  public void setRow(int row) {
    this.square.setRow(row);
  }

  public int getRow() {
    return square.getRow();
  }

  public void setColumn(int column) {
    this.square.setColumn(column);
  }

  public int getColumn() {
    return square.getColumn();
  }

  public boolean getTeam() {
    return this.team;
  }

}