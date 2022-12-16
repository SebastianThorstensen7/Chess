package edu.bothell.chess;
import java.util.Scanner;

public class Queen extends Piece{

  Boolean    Team;
  String     pieceID;
  int        row;
  int        column;
  int yDistance;
  
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
private double getSlope(int x, int y) {
    double slope = Math.abs((double) (y - super.column) / (x - super.row));
    return slope;
  }
  //Validate move method for Queen
  public boolean validateMove(int x, int y, Square[][] state) {
    System.out.println("Move method is being called");
    this.yDistance = y - super.column;
    int xInt = super.row;
    int yInt = super.column;

    if (getSlope(x, y) == 1.0) {
      for (int i = 0; i < Math.abs(yDistance); i++) {
        if (x < super.row && y > super.column) {
          xInt--;
          yInt++;
        } else if (x < super.row && y < super.column) {
          xInt--;
          yInt--;
        } else if (x > super.row && y > super.column) {
          xInt++;
          yInt++;
        } else if (x > super.row && y < super.column) {
          xInt++;
          yInt--;
        }
        else if(x > super.row && y == super.column){
          xInt++;
        }
        else if(x < super.row && y == super.column){
          xInt--;
        }
        else if(x == super.row && y > super.column){
          yInt++;
        }
        else if(x == super.row && y < super.column){
          yInt--;
        }
      }
    } 
    else if (state[xInt][yInt].isNotOccupied() == false) {
          System.out.println("occupied in between");
          return false;
        } 
    return true;
  }

  public String toString() {
    if(Team) {
      return "♕";
    } else {
      return "♛";
    }
  }
}