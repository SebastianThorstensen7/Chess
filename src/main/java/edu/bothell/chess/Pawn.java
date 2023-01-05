package edu.bothell.chess;

import java.util.Scanner;

public class Pawn extends Piece {

  Boolean Team;
  Boolean firstMove;
  String pieceID;
  int row;
  int column;
  
  public Pawn(boolean team, int column, int row, B board){
    super(team, column, row, board);
  }
  
  public Pawn(Boolean Team, String pieceID, int x, int y) {
    super(Team, pieceID, x, y);
    this.firstMove = true;
  }

  // validate move method for pawn
  public boolean validateMove(Square x) {
    return super.validateMove(x);
  }

  public String toString() {
    if (super.getTeam()) {
      return "♙";
    } else {
      return "♟";
    }
  }
}