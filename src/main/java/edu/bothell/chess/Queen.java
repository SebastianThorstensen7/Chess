package edu.bothell.chess;
import java.util.Scanner;

public class Queen extends Piece{

  public Queen(Boolean team, Square square, B board){
    super(team,square,board);
  }
  
  public void move(Scanner scn){
    super.move(scn);
    System.out.println("Queen move");
  }
  
  /*
private double getSlope(int x, int y) {
    double slope = Math.abs((double) (y - super.column) / (x - super.row));
    return slope;
  }
  */
  
  //Validate move method for Queen
  /**
   * Sebastian: Things to help you update the code 
   * Starting coordinates are now got with super.getRow() and super.getColumn()
   * Destination coordinates are now got with x.getRow() and x.getColumn()
   * Don't worry about the check Inbetween method I'll be working on it
   */
  public boolean validateMove(Square x) {
    boolean validMove = false;
    
    // moving to square occupied by the same team is always no good...
    if( x.isTeam(team) ) return false;

    // moving like a rook...
    if(x.getRow() == super.getRow() || x.getColumn() == super.getColumn()) {
      validMove = true;
    }
    // moving like a bishop
    if( Math.abs((x.getRow() - super.getRow()) / (x.getColumn() - super.getColumn())) == 1) {
      validMove = true;
    }
    boolean noPeacesBetween = checkInbetween(x);
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