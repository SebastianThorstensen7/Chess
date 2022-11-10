import java.util.ArrayList;
public class Chessgame {

  Board Board;
  ArrayList<Piece> chessPieces;

  public Chessgame(ArrayList<Piece> pieces) {
    this.Board = new Board(pieces);
    this.chessPieces = pieces;
  }

  public void play() {
    boolean checkmate = false;
    while(!checkmate) {
      this.Board.move();
      this.Board.updateState();
      this.Board.switchTeam();
      checkmate = winValidation();
    }
  }

  public boolean winValidation() {
    return false;
  }
  
}