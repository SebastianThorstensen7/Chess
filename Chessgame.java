import java.util.ArrayList;
public class Chessgame {

  Board Board;
  ArrayList<Piece> chessPieces;

  public Chessgame(ArrayList<Piece> pieces) {
    this.Board = new Board(pieces);
    this.chessPieces = pieces;
  }

  public void play() {
    for(int i = 0; i < 1000; i++) {
      this.Board.selectPiece();
      this.Board.updateState();
      this.Board.switchTeam();
    }
  }
  
}