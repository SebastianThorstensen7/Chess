package edu.bothell.chess;

import java.util.Scanner;
import java.util.ArrayList;

public class King extends Piece {

  private ArrayList<Piece> threats;
  private B board;

  public King(Boolean team, Square square, B board) {
    super(team, square, board);
  }

  public void move(Scanner scn) {
    super.move(scn);
    System.out.println("King move");
  }

  // validate move method for King
  @Override
  public boolean validateMove(Square x) {
    if (canCastle(x)) {
      return doSpecial(x);
    }
    else if(x.getPiece() != null && x.getPiece().getTeam() == this.getTeam()) 
      return false;
    
    return super.getDistance(x) == 1;
  }

  public boolean canCastle(Square p) {
    // Need to know if correct king is selected
    // TODO: Has this alreday happened
    // Confrim the square we move to is the rook
    // Check if the rook is the same thing as the king
    //
    
    Piece rook = p.getPiece();
     if (!(rook instanceof Rook) || rook.getTeam() != this.getTeam()) {
      return false;
    } else if (((p.getColumn() - this.getColumn())) != 0) {

      return false;
    }
    else if(super.getMoved() || rook.getMoved()){
      return false;
    }
     else if (!super.checkInbetween(p)) {
      return false;
    }
    return true;
  }  

  public boolean doSpecial(Square x){
    Rook rook = (Rook) x.getPiece();
    Square r = new Square(6,7);
    Square k = new Square(5,7); 
    board.move(r,r.getPiece());
    board.move(k,k.getPiece());
    return true;
  }
  
  public String toString() {
    if (super.getTeam()) {
      return "♔";
    } else {
      return "♚";
    }
  }
}