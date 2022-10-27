// khushi singh
// 10.25.2022
// p.3
// team chess 

// i own rook
// am responsible for move validation


// this.x = original

import java.util.Scanner;
public class Rook extends Piece{

  Boolean    Team;
  String     pieceID;
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
    if (this.row != x && this.column != y){
      return false;
    }
    else if (this.row != x && this.column == y){
      return true;
    }
    else if (this.row == x && this.column != y){
      return true;
    }
    else {
      return false;
    }
  
  }

  public String toString() {
    if(Team) {
      return "♖";
    } else {
      return "♜";
    }
  }
}