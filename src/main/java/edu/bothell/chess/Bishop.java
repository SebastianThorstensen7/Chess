
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
  
  //////////////////////////////////////////////////////////
  // BETTER CONSTRUCTOR FOR BISHOP!!!!!
  //////////////////////////////////////////////////////////
  public Bishop(boolean team, int column, int row, B board){
    super(team, column, row, board);
  }
  
  public Bishop(Boolean Team, String pieceID, int row, int column, ArrayList<Piece> Pieces) {
    super(Team, pieceID, row, column);
    scn = new Scanner(System.in);
    this.Pieces = Pieces;
    this.board = board;
  }

  public void move(Scanner scn) {
    super.move(scn);
    board = new Board(Pieces);
    System.out.println("Bishop move");
  }

  private double getSlope(int x, int y) {
    double slope = Math.abs((double) (y - super.column) / (x - super.row));
    return slope;
  }

  // Validate move method for bishop
  public boolean validateMove(int x, int y, Square[][] state) {
    System.out.println("Move method is being called");
    this.yDistance = y - super.column;
    System.out.println(yDistance);
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
        } else if (state[xInt][yInt].isNotOccupied() == false) {
          System.out.println("occupied in between");
          return false;
        } 
        else{
          return true;
        }
      }
    } 
    else if (getSlope(x, y) != 1.0) {
      System.out.println("Not a diagonal move");
      return false;
    }
    return true;
  }

  public String toString() {
    if (super.getTeam()) {
      return "♗";
    } else {
      return "♝";
    }
  }
}
