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
    for(Piece p : super.getBoard().getPieces()) {
      if(p.getTeam() != super.getTeam() && !(p instanceof King)) {
        if(p.validateMove(x) && p.checkInbetween(x,this)) {
          return false;
        }
      }
    }
    int rkDistance = this.getRow() - x.getRow();
    if (canCastle(x, rkDistance)) {
      System.out.println("Castle method ex");
      castle(x, rkDistance);
      return true;
    }
    return super.validateMove(x);
  }

  public boolean canCastle(Square x, int rkDistance) {
    // Need to know if correct king is selected
    // TODO: Has this alreday happened
    // Confrim the square we move to is the rook
    // Check if the rook is the same thing as the king
    //
    if (!x.isTeam(team)) {
      return false;
    } else if (!(x.getSymbol() == "♜")) {
      return false;
    } else if (((this.getRow() - x.getRow()) - (this.getColumn() - x.getColumn())) != 0) {
      return false;
    }
    return true;
  }

  public void castle(Square x, int rkDistance) {
    if (x.getSymbol() == "♖") {
      x.setRow(this.getRow() - rkDistance);
      this.setRow(x.getRow());
    } else if (x.getSymbol() == "♜") {
      x.setRow(this.getRow() + rkDistance);
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

  /*
   * @Override
   * pubic void validateMove(Square x){
   * 
   * }
   */

  public String toString() {
    if (super.getTeam()) {
      return "♔";
    } else {
      return "♚";
    }
  }
}