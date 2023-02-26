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
    System.out.println("The king validation move");
    for (Piece p : super.getBoard().getPieces()) {
      if (p.getTeam() != super.getTeam() && !(p instanceof King)) {
        if (p.validateMove(x) && p.checkInbetween(x, this)) {
          return false;
        }
      }
    }

    if (canCastle(x)) {
      System.out.println("Castle method ex");
      castle(x);
      return true;
    }
    return super.validateMove(x);
  }

  public boolean canCastle(Square x) {
    // Need to know if correct king is selected
    // TODO: Has this alreday happened
    // Confrim the square we move to is the rook
    // Check if the rook is the same thing as the king
    //
    System.out.println("Supposed to castle");
     if (!(x.getSymbol() == "♜" || x.getSymbol() == "♖")) {
      return false;
    } else if (((x.getColumn() - this.getColumn()) - (x.getRow() - x]this.getRow())) != 0) {
      return false;
    } else if (!super.checkInbetween(x)) {
      return false;
    }
    return true;
  }

  public void castle(Square x) {
    if (x.getSymbol() == "♖") {
      x.setRow(this.getRow());
      this.setRow(x.getRow());
    } else if (x.getSymbol() == "♜") {
      x.setRow(this.getRow());
      this.setRow(x.getRow());
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