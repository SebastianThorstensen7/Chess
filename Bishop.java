//Manas Kumar is in charge of this file
//10/24/2022
//P3
//I will be making changes to this file

import java.util.Scanner;
public class Bishop extends Piece{

  Boolean    Team;
  String     pieceID;
  int        row;
  int        column;
  
  public Bishop(Boolean Team, String pieceID, int row, int column){
    super(Team,pieceID,row,column);
    this.Team = Team;
    this.pieceID = pieceID;
    this.row = row;
    this.column = column;
  }
  
  public void move(Scanner scn){
    super.move(scn);
    System.out.println("Bishop move");
  }

  //Validate move method for bishop
  public boolean validateMove(int x, int y) {
    return true;
  }

  public String toString() {
    if(Team) {
      return "♗";
    } else {
      return "♝";
    }
  }
}