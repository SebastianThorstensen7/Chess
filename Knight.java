import java.util.Scanner;
public class Knight extends Piece{

  Boolean    Team;
  String        pieceID;
  int        row;
  int        column;
  
  public Knight(Boolean Team, String pieceID, int row, int column){
    super(Team,pieceID,row,column);
    this.Team = Team;
    this.pieceID = pieceID;
    this.row = row;
    this.column = column;
  }
  
  public void move(Scanner scn){
    super.move(scn);
    System.out.println("Knight move");
  }

  public String toString() {
    if(Team) {
      return "♘";
    } else {
      return "♞";
    }
  }
}