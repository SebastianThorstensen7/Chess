
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
  int xDistance;
  int yDistance;

  public Bishop(Boolean Team, String pieceID, int row, int column, ArrayList<Piece> Pieces) {
    super(Team, pieceID, row, column);
    this.Team = Team;
    this.pieceID = pieceID;
    this.row = row;
    this.column = column;
    scn = new Scanner(System.in);
    this.Pieces = Pieces;
    this.board = board;
    this.xDistance = xDistance;
    this.yDistance = yDistance;
  }

  public void move(Scanner scn) {
    super.move(scn);
    board = new Board(Pieces);
    System.out.println("Bishop move");
  }

  private double getSlope(double x, double y) {
    double slope = Math.abs((double) (y - column) / (x - row));
    return slope;
  }

  // Validate move method for bishop
  public boolean validateMove(int x, int y, Square[][] state) {
    System.out.println("Move method is being called");
      xDistance = x - row;
      yDistance = y - column;
    System.out.println(xDistance);
    System.out.println(yDistance);
      int xInt = row;
      int yInt = column;

      if (this.getSlope(x, y) == 1.0) {
        for (int i = 0; i < Math.abs(yDistance); i++) {
          if(xDistance < 0 && yDistance > 0){
            xInt --;
            yInt ++;
          }
          else if(xDistance < 0 && yDistance < 0){
            xInt --;
            yInt --;
          }
          else if(xDistance > 0 && yDistance > 0){
            xInt ++;
            yInt ++;
          }
          else if(xDistance > 0 && yDistance < 0){
            xInt ++;
            yInt --;
          }
           else if (state[xInt][yInt].isNotOccupied() == false) {
          System.out.println("occupied in between");
          return false;
        }
        }
      }
      else if((this.getSlope(x, y)) != 1.0){
        System.out.println("Not a diagonal move");
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
