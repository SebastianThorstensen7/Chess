package edu.bothell.chess;
import java.util.Scanner;

public class King extends Piece{


  public King(Boolean team, Square square, B board){
    super(team,square,board);
  }

  public void move(Scanner scn){
    super.move(scn);
    System.out.println("King move");
  }

  //validate move method for King
  public boolean validateMove(Square x) {
    return super.validateMove(x);
  }

  

  public String toString() {
    if(super.getTeam()) {
      return "♔";
    } else {
      return "♚";
    }
  }
}