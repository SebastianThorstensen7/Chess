
//Manas Kumar is in charge of this file
//10/24/2022
//P3
//I will be making changes to this file
package edu.bothell.chess;
import java.util.*;


public class Bishop extends Piece {

  Boolean Team;
  String pieceID;
  int row;
  int column;
  int slope;
  Piece bishop;
  Scanner scn;
  ArrayList<Piece> Pieces;
  Board board;

  public Bishop(Boolean Team, String pieceID, int row, int column, ArrayList<Piece> Pieces) {
    super(Team, pieceID, row, column);
    this.Team = Team;
    this.pieceID = pieceID;
    this.row = row;
    this.column = column;
    scn = new Scanner(System.in);
    this.Pieces = Pieces;
    this.board = board;
  }

  public void move(Scanner scn) {
    super.move(scn);
    board = new Board(Pieces);
    System.out.println("Bishop move");
  }

  private String getSlope(double x, double y) {
    double slope = Math.abs((double) ((y - column) / (x - row)));
    return slope + "";
  }

  // Validate move method for bishop
  public boolean validateMove(int x, int y, Square[][] state) {
    System.out.println("Move method is being called");
    int yDistance = Math.abs(y - column);

    if (this.row == x && this.column == y) {
      System.out.println("Thats the same spot its in(invalide move)");
      return false;
    }

    else if ((x > 0 && x <= 8) || (y > 0 && y <= 8)) {
      int xInt = (row+1);
      int yInt = (column+1);

      if (this.getSlope(x, y).equals("1.0")) {
        for (int i = 0; i < yDistance; i++) {
          if(x < row && y > column){
            xInt --;
            yInt ++;
          }
          else if(x < row && y < column){
            xInt --;
            yInt --;
          }
          else if(x > row && y > column){
            xInt ++;
            yInt ++;
          }
          else if(x > row && y < column){
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
      else if(!this.getSlope(x, y).equals("1.0")){
        System.out.println("Not a diagonal move");
        return false;
      }
    }
    else if(!(x > 0 && x <= 8) || !(y > 0 && y <= 8)){
      System.out.println("This is outside the board");
      return false;
    }
    return true;
  }

  public String toString() {
    if (Team) {
      return "♗";
    } else {
      return "♝";
    }
  }
}
