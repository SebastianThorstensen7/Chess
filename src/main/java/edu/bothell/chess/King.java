package edu.bothell.chess;

import java.util.Scanner;
import java.util.ArrayList;

public class King extends Piece {

  private ArrayList<Piece> threats;

  public King(Boolean team, Square square, B board) {
    super(team, square, board);
  }

  public void move(Scanner scn) {
    super.move(scn);
    System.out.println("King move");
  }

  // validate move method for King
  public boolean validateMove(Square x) {
    for (Piece p : super.getBoard().getPieces()) {
      if (p.getTeam() != super.getTeam() && !(p instanceof King)) {
        if (p.validateMove(x) && p.checkInbetween(x, this)) {
          return false;
        }
      }
      else if (canCastle(p)) {
        if(p.getRow() > this.getRow()){
          p.setRow(this.getRow() - 1);
        }
        else if(p.getRow() < this.getRow()){
          p.setRow(this.getRow() + 1);
        }
        return true;
      }
    }

    return super.validateMove(x);
  }

  public boolean canCastle(Piece p) {
    // Need to know if correct king is selected
    // TODO: Has this alreday happened
    // Confrim the square we move to is the rook
    // Check if the rook is the same thing as the king
    //
     if (!(p instanceof Rook)) {
      return false;
    } else if (((p.getColumn() - this.getColumn())) != 0) {
      return false;
    } else if (!super.checkInbetween(p.getSquare())) {
      return false;
    }
    return true;
  }  



  public String toString() {
    if (super.getTeam()) {
      return "♔";
    } else {
      return "♚";
    }
  }
}