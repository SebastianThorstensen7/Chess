package edu.bothell.chess;

import java.util.Scanner;

public class King extends Piece {

  public King(Boolean team, Square square, B board) {
    super(team, square, board);
  }

  public void move(Scanner scn) {
    super.move(scn);
    System.out.println("King move");
  }

  // validate move method for King
  public boolean validateMove(Square x) {
    System.out.println("hdeuqho");
    int rkDistance = this.getRow() - x.getRow();
    /*
    if (canCastle(x, rkDistance)) {
      castle(x, rkDistance);
      return true;
    }
    */
    return super.validateMove(x);
  }
/*
  public boolean canCastle(Square x, int rkDistance) {
    if (this.getRow() == this.getRow() - 2) {
      if (team) {
        if (rkDistance == 1 || rkDistance == 2) {
          if (x.getSymbol() == "♖") {
            return true;
          }
        }
      }
    } else if (this.getRow() == this.getRow() + 2) {
      if (!team) {
        if (rkDistance == 1 || rkDistance == 2) {
          if (x.getSymbol() == "♜") {
            return true;
          }
        }
      }
    }
    return false;
  }
  */
  
/*
  public void castle(Square x, int rkDistance) {
    x.setRow(this.getRow() - rkDistance);
    this.setRow(x.getRow());
  }
*/
  public String toString() {
    if (super.getTeam()) {
      return "♔";
    } else {
      return "♚";
    }
  }
}