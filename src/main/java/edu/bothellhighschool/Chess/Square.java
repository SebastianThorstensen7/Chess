package edu.bothellhighschool.Chess;

public class Square {

  private Piece piece;
  private String symbol;

  public Square() {
    this.piece = null;
  }

  public void setPiece(Piece p) {
    this.piece = p;
  }

  public String getSymbol() {
    return this.symbol;
  }

  public Piece getPiece() {
    return this.piece;
  }

  public boolean isNotOccupied() {
    if (this.piece == null) {
      return true;
    } else {
      return false;
    }
  }

  public String toString() {
    if(piece == null) {
      this.symbol = " ";
    } else {
      this.symbol = piece.toString();
    }
    return "[ " + symbol + " ]";
  }

}