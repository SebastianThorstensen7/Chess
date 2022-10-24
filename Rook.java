import java.util.Scanner;
public class Rook extends Piece{

  Boolean    Team;
  String        pieceID;
  int        row;
  int        column;
  
  public Rook(Boolean Team, String pieceID, int row, int column){
    super(Team,pieceID,row,column);
    this.Team = Team;
    this.pieceID = pieceID;
    this.row = row;
    this.column = column;
  }
  
  public void move(Scanner scn) {
    super.move(scn);
    System.out.println("Rook move");
  }

  //validate move method for Rook
  public boolean validateMove(int x, int y) {
    return true;
  }

  public String toString() {
    if(Team) {
      return "♖";
    } else {
      return "♜";
    }
  }
}