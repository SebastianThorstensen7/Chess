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
    System.out.println("The king validation move");
    for (Piece p : super.getBoard().getPieces()) {
      if (p.getTeam() != super.getTeam() && !(p instanceof King)) {
        System.out.println("hieuchiew");
        if (p.validateMove(x) && p.checkInbetween(x, this)) {
          System.out.println("ekjvporj");
          return false;
        }
      }
      else if (canCastle(p)) {
        System.out.println("Castle method ex");
        castle(p);
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
    System.out.println("Supposed to castle");
     if (!(p instanceof Rook)) {
      return false;
    } else if (((p.getColumn() - this.getColumn()) - (p.getRow() - this.getRow())) != 0) {
      return false;
    } else if (!super.checkInbetween(p.getSquare())) {
      return false;
    }
    return true;
  }

  public void castle(Piece p) {
    if (p instanceof Rook) {
      p.setRow(this.getRow());
      this.setRow(p.getRow());
    } 
  }

  public void getThreats(Square s) {
    for (Piece p : super.getBoard().getPieces()) {
      if (p.getTeam() != super.getTeam()) {
        if (p.validateMove(s))
          threats.add(p);
      }
    }
  }

  public String toString() {
    if (super.getTeam()) {
      return "♔";
    } else {
      return "♚";
    }
  }
}