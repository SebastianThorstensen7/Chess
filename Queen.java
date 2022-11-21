import java.util.Scanner;
public class Queen extends Piece{

  Boolean    Team;
  String     pieceID;
  int        row;
  int        column;
  
  public Queen(Boolean Team, String pieceID, int row, int column){
    super(Team,pieceID,row,column);
    this.Team = Team;
    this.pieceID = pieceID;
    this.row = row;
    this.column = column;
  }
  
  public void move(Scanner scn){
    super.move(scn);
    System.out.println("Queen move");
  }

  //Validate move method for Queen
  public boolean validateMove(int row, int column, Square[][] state) {
    return super.validateMove(row,column,state);
  }

  public String toString() {
    if(Team) {
      return "♕";
    } else {
      return "♛";
    }
  }
}