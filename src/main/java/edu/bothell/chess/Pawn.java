package edu.bothell.chess;

import java.util.Scanner;

public class Pawn extends Piece {
  
  Boolean firstMove;
  
  public Pawn(boolean team, Square square, B board){
    super(team, square, board);
    this.firstMove = true;
  }
  
  // validate move method for pawn
  public boolean validateMove(Square x) {
    boolean validMove = false;
    if(x.isEmpty()) {
      System.out.println("Square is empty");
      if (super.getColumn() == x.getColumn()) {
        System.out.println("In same column");
        if ((super.getRow() + 2 == x.getRow()) && super.team == true && firstMove) {
          System.out.println("First pawn move (black)");
          this.firstMove = false;
          validMove = true;
        } else if ((super.getRow() + 1 == x.getRow()) && (super.team == true)) {
          validMove = true;
        }
        if ((super.getRow() - 2 == x.getRow()) && super.team == false && firstMove) {
          System.out.println("First pawn move (white)");
          this.firstMove = false;
          validMove = true;
          
        } else if ((super.getRow() - 1 == x.getRow()) && (super.team == false)) {
          validMove = true;
        }
      }
    } else {
      System.out.println("Occupied space");
      if (super.team) {
        System.out.println("black piece");
          if ((super.getRow() + 1 == x.getRow()) && ((super.getColumn() + 1 == x.getColumn()) || (super.getColumn() - 1 == getColumn()))) {
            validMove = true;
          }
        } else {
        System.out.println("white piece");
          if ((super.getRow() - 1 == x.getRow()) && ((super.getColumn() + 1 == getColumn()) || (super.getColumn() - 1 == getColumn()))) {
            validMove = true;
          } 
        }
    }
    
    boolean noPeacesBetween = checkInbetween(x);
    if(validMove && noPeacesBetween) {
        return true;
    }
    return false;
  }

  public String toString() {
    if (super.getTeam()) {
      return "♙";
    } else {
      return "♟";
    }
  }
}