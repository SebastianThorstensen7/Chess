import java.util.Scanner;
public class King extends Piece{

  Boolean    team;
  String     pieceID;
  int        row;
  int        column;
  
  public King(Boolean Team, String pieceID, int row, int column){
    super(Team,pieceID,row,column);
    this.team = Team;
    this.pieceID = pieceID;
    this.row = row;
    this.column = column;
  }

  public void move(Scanner scn){
    super.move(scn);
    System.out.println("King move");
  }

  //validate move method for King
  public boolean validateMove(int row, int column, Square[][] state) {
    return super.validateMove(row,column,state);
  }

  public String toString() {
    if(team) {
      return "♔";
    } else {
      return "♚";
    }
  }
}