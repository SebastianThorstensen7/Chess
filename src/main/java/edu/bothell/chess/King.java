package edu.bothell.chess;
import java.util.Scanner;

public class King extends Piece{

  Boolean    team;
  String     pieceID;
  int        row;
  int        column;
  
  public King(Boolean Team, String pieceID, int row, int column){
    super(Team,pieceID,row,column);
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