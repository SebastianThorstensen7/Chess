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
  @Override
  public boolean validateMove(Square x) {
    for (Piece p : super.getBoard().getPieces()) {
      if (p.getTeam() != super.getTeam() && !(p instanceof King)) {
        if (p.validateMove(x) && p.checkInbetween(x, this)) {
          return false;
        }
      }
    }
    if (canCastle(x)) {
        if (x.getRow() > this.getRow()) {
          System.out.println("Does castling on left");
          x.setRow(this.getRow() - 1);
          return true;
        } else if (x.getRow() < this.getRow()) {
          System.out.println("Does castling on right");
          x.setRow(this.getRow() + 1);
          return true;
        }
    }
    return super.validateMove(x);
  }

  public boolean canCastle(Square p) {
    // Need to know if correct king is selected
    // TODO: Has this alreday happened
    // Confrim the square we move to is the rook
    // Check if the rook is the same thing as the king
    //
    
    Piece rook = p.getPiece();
     if (!(rook instanceof Rook) || rook.getTeam() != this.getTeam()) {
             System.out.println("Can do castling");
      return false;
    } else if (((p.getColumn() - this.getColumn())) != 0) {
             System.out.println("Can do castling");
      return false;
    }
    else if(super.getMoved() || rook.getMoved()){
            System.out.println("Can do castling");
      return false;
    }
     else if (!super.checkInbetween(p)) {
             System.out.println("Can do castling");
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