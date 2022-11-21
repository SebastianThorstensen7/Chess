import java.util.Scanner;
public class Pawn extends Piece{

  
  Boolean    Team;
  String     pieceID;
  int        x;
  int        y;
  
  public Pawn(Boolean Team, String pieceID, int x, int y){
    super(Team,pieceID,x,y);
    this.Team = Team;
    this.pieceID = pieceID;
    this.x = x;
    this.y = y;
  }

  //validate move method for pawn
  public boolean validateMove(int row, int column, Square[][] state) {
    return super.validateMove(row,column,state);
  }

  public String toString() {
    if(Team) {
      return "♙";
    } else {
      return "♟";
    }
  }
}