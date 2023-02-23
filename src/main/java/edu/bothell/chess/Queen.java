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
    
    if( x.isTeam(team) ) {
      return false;
    } else if(x.getRow() == super.getRow() || x.getColumn() == super.getColumn()) {
      return true;
    } else if( Math.abs((x.getRow() - super.getRow()) / (x.getColumn() - super.getColumn())) == 1) {
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