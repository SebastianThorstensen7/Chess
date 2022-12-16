package edu.bothell.chess;
import java.util.Scanner;

public class Knight extends Piece{

  Boolean    Team;
  String        pieceID;
  int        row;
  int        column;
  
  public Knight(Boolean Team, String pieceID, int row, int column){
    super(Team,pieceID,row,column);
  }
  
  public void move(Scanner scn){
    super.move(scn);
    System.out.println("Knight move");
  }

  //validate move method for Knight
  public boolean validateMove (int x, int y, Square[][] state) {
    if (state[x][y].isNotOccupied() == true){
      if (super.column + 2 == y || super.column - 2 == y){
        if (super.row + 1 == x || super.row - 1 == x){
          return true;
        }
        else {
          return false;
        }
      }
      else if (super.column + 1 == y || super.column - 1 == y){
        if (super.row + 2 == x || super.row - 2 == x){
          
          return true;
        }
        else {
          return false;
        }
      }

      else if (super.row + 1 == x || super.row - 1 == x){
        if (super.column + 2 == y || super.column - 2 == y){
          
          return true;
        }
        else {
          return false;
        }
      }
      else if (super.row + 2 == x || super.row - 2 == x){
        if(super.column + 1 == y || super.column - 1 == y){
          
          return true;
        }
        else {
          return false; 
        }
      }
      else {
        
        return false;
      }
    }
      
    else{
      return false;
    }

  }

  public String toString() {
    if(super.getTeam()) {
      return "♘";
    } else {
      return "♞";
    }
  }
}