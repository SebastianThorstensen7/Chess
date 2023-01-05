package edu.bothell.chess;

public class Square {

  private Piece piece;
  private String symbol;
  private int x;
  private int y;

  public Square() {
    this.piece = null;
  }

  /**
   * GUS: New constructor for Square
   * Square needs coordinates!!!
   * @param  x  int for column
   * @param  y  int for row
   */
  public Square(int x, int y) {
    this.piece = null;
    this.x = x;
    this.y = y;
  }


  ////////////////////////////////////////////
  // Methods
  ///////////////////////////////////////////

  public int getColumn(){
    return x;
  }

  public int getRow(){
    return y;
  }

  public void setColumn(int column){
    this.x = column;
  }

  public void setRow(int row){
    this.y = row;
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

  public boolean isEmpty(){
    return this.piece == null;
  }

  public boolean isTeam(boolean team){
    return !isEmpty() && (team == piece.getTeam());
  }
  
  public boolean isNotOccupied() {
    return isEmpty();
  }

  public String toString() {
    if(piece == null) {
      this.symbol = " ";
    } else {
      this.symbol = piece.toString();
    }
    return "[ " + symbol + "  ]";
  }

}