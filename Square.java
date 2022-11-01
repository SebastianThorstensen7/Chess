public class Square {

  private Piece piece;
  private String symbol;

  public Square() {
    this.symbol = " ";
  }

  public Square(Piece p) {
    this.piece = p;
    this.symbol = p.toString();
  }

  public void setPiece(Piece p) {
    this.piece = p;
    this.symbol = p.toString();
  }

  public String getSymbol() {
    return this.symbol;
  }

  public Piece getPiece() {
    return this.piece;
  }

  public boolean isNotOccupied() {
    if (this.symbol.equals(" ")) {
      return true;
    } else {
      return false;
    }
  }

  public String toString() {
    return "[ " + symbol + " ]";
  }

}