package edu.bothell.chess;
import java.util.Scanner;

public class Queen extends Piece{

  Boolean    Team;
  String     pieceID;
  int        row;
  int        column;
  int        yDistance;
  
  public Queen(Boolean Team, String pieceID, int row, int column){
    super(Team,pieceID,row,column);
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
  public boolean validateMove(Square x, Square[][] board) {
    boolean validMove = false;
    
    // moving to square occupied by the same team is always no good...
    if( x.isTeam(team) ) return false;

    // moving like a rook...
    if(x.getRow() == row || x.getColumn() == column) {
      validMove = true;
    }
    // moving like a bishop
    if( Math.abs((x.getRow() - row) / (x.getColumn() - column)) == 1) {
      validMove = true;
    }
    boolean noPeacesBetween = checkInbetween(board);
    if(validMove && noPeacesBetween) {
        return true;
      }
    return false;
  }

  public String toString() {
    if(super.getTeam()) {
      return "♕";
    } else {
      return "♛";
    }
  }
}