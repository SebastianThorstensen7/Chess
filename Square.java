public class Square {

  private Piece piece;
  private String symbol;

  public Square(){
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

  public String toString(){
    return "[ " + symbol + " ]";
  }


}