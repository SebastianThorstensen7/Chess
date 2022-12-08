package edu.bothellhighschool.Chess;
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

  //validate move method for Knight
  public boolean validateMove (int x, int y, Square[][] state) {
    if (state[x][y].isNotOccupied() == true){
      if (this.column + 2 == y || this.column - 2 == y){
        if (this.row + 1 == x || this.row - 1 == x){
          this.column = y;
          this.row = x;
          return true;
        }
        else {
          
          return false;
        }
      }
      else if (this.column + 1 == y || this.column - 1 == y){
        if (this.row + 2 == x || this.row - 2 == x){
          this.column = y;
          this.row = x;
          return true;
        }
        else {
          return false;
        }
      }

      else if (this.row + 1 == x || this.row - 1 == x){
        if (this.column + 2 == y || this.column - 2 == y){
          this.row = x; 
          this.column = y;
          return true;
        }
        else {
          return false;
        }
      }
      else if (this.row + 2 == x || this.row - 2 == x){
        if(this.column + 1 == y || this.column - 1 == y){
          this.row = x; 
          this.column = y;
          return true;
        }
        else {
          return false; 
        }
      }
      else {
        System.out.println("nothing valid");
        return false;
      }
    }
      
    else{
      return false;
    }

  }

  public String toString() {
    if(Team) {
      return "♘";
    } else {
      return "♞";
    }
  }
}