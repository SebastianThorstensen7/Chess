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
  
  public void move(Scanner scn){
    super.move(scn);
    System.out.println("Pawn move");
  }

  public String toString() {
    if(Team) {
      return "♙";
    } else {
      return "♟";
    }
  }
}