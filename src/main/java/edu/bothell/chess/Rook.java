// khushi singh
// 10.25.2022
// p.3
// team chess 

// i own rook
// am responsible for move validation

// this.x = original

package edu.bothell.chess;

import java.util.Scanner;

public class Rook extends Piece {



  public Rook(boolean team, Square square, B board){
    super(team, square, board);
  }
  
  public void move(Scanner scn) {
    super.move(scn);
    System.out.println("Rook move");
  }

  // validate move method for Rook
 /**
   * Sebastian: Things to help you update the code 
   * Starting coordinates are now got with super.getRow() and super.getColumn()
   * Destination coordinates are now got with x.getRow() and x.getColumn()
   * Don't worry about the check Inbetween method I'll be working on it
   */
  public boolean validateMove(Square x) {
      boolean validMove       = false;
      //code goes here
      boolean noPeacesBetween = checkInbetween(x);
      if(validMove && noPeacesBetween) {
        return true;
      }
      return false;
    }

  public String toString() {
    if (super.getTeam()) {
      return "♖";
    } else {
      return "♜";
    }
  }
}