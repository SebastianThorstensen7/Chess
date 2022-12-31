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

  Boolean Team;
  String pieceID;
  int row;
  int column;

  public Rook(Boolean Team, String pieceID, int row, int column) {
    super(Team, pieceID, row, column);
  }

  public void move(Scanner scn) {
    super.move(scn);
    System.out.println("Rook move");
  }

  // validate move method for Rook
  public boolean validateMove(int x, int y, Square[][] state) {
    if (state[x][y].isNotOccupied()) {
      if (super.row != x && super.column != y) {
        return false;
      } else if (super.row != x && super.column == y) {
        if (row < x) {
          for (int i = super.row; i < x; i++) {
            if (state[i][y].isNotOccupied() == false) {
              return false;
            } else if (x - 1 == i) {
              return true;
            }
          }
        } else if (super.row > x) {
          for (int i = super.row; i > x; i--) {
            if (state[i][y].isNotOccupied() == false) {
              return false;
            } else if (x - 1 == i) {
              return true;
            }
          }
        }
        return true;
      } else {
        return true;
      }

    }

    else if (super.row == x && super.column != y) {
      if (super.column > y) {
        for (int i = super.column; i > y; i--) {
          if (state[x][i].isNotOccupied() == false) {
            return false;
          }
        }
      } else if (super.column < y) {
        for (int i = super.column; i < y; i++) {
          if (state[x][i].isNotOccupied() == false) {
            return false;
          }
        }
      }
      return true;
    } else {
      return true;
    }
  }

  public String toString() {
    if (super.getTeam()) {
      return "♖";
    } else {
      return "♜";
    }
  }
}