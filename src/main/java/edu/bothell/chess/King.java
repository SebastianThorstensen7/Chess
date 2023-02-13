package edu.bothell.chess;
import java.util.Scanner;

public class King extends Piece{


  public King(Boolean team, Square square, B board){
    super(team,square,board);
  }

  public void move(Scanner scn){
    super.move(scn);
    System.out.println("King move");
  }

  //validate move method for King
 public boolean validateMove(Square x) {
    if (super.validateMove(x)) {
      return true;
    }
    if (castling(x)) {
      return true;
    }
    return false;
  }

  public boolean castling(Square x) {
    int rkDistance = this.getRow() - x.getRow();
    if (this.getRow() == this.getRow() - 2) {
      if (team) {
        if (rkDistance == 1 || rkDistance == 2) {
          if (x.getSymbol() == "♖") {
            x.setRow(this.getRow() - rkDistance);
            this.setRow(x.getRow());
            return true;
          }
        }
      }
    } else if (this.getRow() == this.getRow() + 2) {
      if (!team) {
        if (rkDistance == 1 || rkDistance == 2) {
          if (x.getSymbol() == "♜") {
            x.setRow(this.getRow() + rkDistance);
            this.setRow(x.getRow());
            return true;
          }
        }
      }
    }
    return false;
  }

  public String toString() {
    if(super.getTeam()) {
      return "♔";
    } else {
      return "♚";
    }
  }
}