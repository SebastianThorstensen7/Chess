import java.util.Scanner;
public class King extends Piece{

  Boolean    Team;
  String        pieceID;
  int        row;
  int        column;
  
  public King(Boolean Team, String pieceID, int row, int column){
    super(Team,pieceID,row,column);
    this.Team = Team;
    this.pieceID = pieceID;
    this.row = row;
    this.column = column;
  }

  public void move(Scanner scn){
    super.move(scn);
    System.out.println("King move");
  }

  //validate move method for King
  public boolean validateMove(int x, int y) {
    
    return true;
  }

  public String toString() {
    if(Team) {
      return "♔";
    } else {
      return "♚";
    }
  }
}