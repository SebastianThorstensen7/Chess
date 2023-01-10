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

  public Rook(boolean team, Square square, B board) {
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
      if (x.isEmpty()) {
      if (super.getRow()  != x.getRow() && super.getColumn() != x.getColumn()) {
        return false;
      } else if (super.getRow()  != x.getRow() && super.getColumn() == x.getColumn()) {
        if (super.getRow()  < x.getRow()) {
          for (int i = super.getRow(); i < x.getColumn(); i++) {
            if (x.isEmpty()) {
              return false;
            } else if (x.getRow() - 1 == i) {
              validMove = true;
              return validMove;
            }
          }
        } else if (super.getRow()  > x.getRow()) {
          for (int i = super.getRow() ; i > x.getRow(); i--) {
            if (x.isEmpty()) {
              return false;
            } else if (x.getRow() - 1 == i) {
              validMove = true;
              return validMove;
            }
          }
        }
        validMove = true;
        return validMove;
      } else {
        validMove = true;
        return validMove;
      }}


    else if (super.getRow()  == x.getRow() && super.getColumn() != x.getColumn()) {
      if (super.getColumn() > x.getColumn()) {
        for (int i = super.getColumn(); i > x.getColumn(); i--) {
          if ((x.isEmpty())) {
            return false;
          }
        }
      } else if (super.getColumn() < x.getColumn()) {
        for (int i = super.getColumn(); i < x.getColumn(); i++) {
          if ((x.isEmpty())) {
            return false;
          }
        }
      }
      return true;
    } else {
      validMove = true;
      return validMove;
    }}
  

  public String toString() {
    if (super.getTeam()) {
      return "♖";
    } else {
      return "♜";
    }
  }
}