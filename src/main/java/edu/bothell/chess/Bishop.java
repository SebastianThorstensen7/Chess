
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
  int xDistance;
  int yDistance;
  
  //////////////////////////////////////////////////////////
  // BETTER CONSTRUCTOR FOR BISHOP!!!!!
  //////////////////////////////////////////////////////////
  public Bishop(boolean team, int column, int row, B board){
    super(team, column, row, board);
  }
  
 

  private double getSlope(int x, int y) {
    double slope = Math.abs((double) (y - super.column) / (x - super.row));
    return slope;
  }

  // Validate move method for bishop
  public boolean validateMove(Square x) {
    return super.validateMove(x);
  }

  public String toString() {
    if (super.getTeam()) {
      return "♗";
    } else {
      return "♝";
    }
  }
}
