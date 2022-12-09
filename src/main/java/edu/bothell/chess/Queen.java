package edu.bothell.chess;
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
    System.out.println("Move method is being called");
    int yDistance = Math.abs(column - this.column);

    if (this.row == row && this.column == column) {
      System.out.println("Thats the same spot its in(invalide move)");
      return false;
    }

    else if ((row > 0 && row <= 8) || (column > 0 && column <= 8)) {
      int xInt = (row+1);
      int yInt = (column+1);

      if (this.getSlope(row, column).equals("1.0")) {
        for (int i = 0; i < yDistance; i++) {
          if(row < row && column > column){
            xInt --;
            yInt ++;
          }
          else if(row < row && column < column){
            xInt --;
            yInt --;
          }
          else if(row > row && column > column){
            xInt ++;
            yInt ++;
          }
          else if(row > row && column < column){
            xInt ++;
            yInt --;
          }

          if (state[xInt][yInt].isNotOccupied() == false) {
            System.out.println("occupied in between");
            return false;
          }
        }
        System.out.println("Valid move");
      }
      else if(!this.getSlope(row, column).equals("1.0")){
        System.out.println("Not a diagonal move");
        return false;
      }
    }
    else if(!(row > 0 && column <= 8) || !(column > 0 && column <= 8)){
      System.out.println("This is outside the board");
      return false;
    }
        if (state[row][column].isNotOccupied()) {
      if (this.row != row && this.column != column) {
        System.out.println("both are different");
        return false;
      } 
      else if (this.row != row && this.column == column) {
        for (int i =0; i < row; i++){
          if (state[i][column].isNotOccupied() == false){
            System.out.println("occupied in between");
            return false;
          }
          else if (row-1 == i){
            this.row = row;
            return true;
          }
          
         }
        this.row = row;
        return true;
        }
      else {
        return true;
      }
       
      } 
      
      else if (this.row == row && this.column != column) {
        
        for (int i =0; i<column; i++){
          if (state[row][i].isNotOccupied() == false){
            System.out.println("occupied in between part 2");
            return false;
          }
        }
        this.column = column;
       return true;
      } 
      else {
        this.column = column;
        return true;
      }
  }

  private String getSlope(double x, double y) {
    double slope = Math.abs((double) ((y - column) / (x - row)));
    return slope + "";
  }

  public String toString() {
    if(Team) {
      return "♕";
    } else {
      return "♛";
    }
  }
}