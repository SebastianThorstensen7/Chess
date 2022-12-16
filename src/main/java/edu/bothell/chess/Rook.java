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
    this.Team = Team;
    this.pieceID = pieceID;
    this.row = row;
    this.column = column;
  }

  public void move(Scanner scn) {
    super.move(scn);
    System.out.println("Rook move");
  }

  // validate move method for Rook
  public boolean validateMove(int x, int y, Square[][] state) {
    if (state[x][y].isNotOccupied()) {
      if (this.row != x && this.column != y) {
        System.out.println("both are different");
        return false;
      } else if (this.row != x && this.column == y) {
        if (row < x) {
          for (int i = row; i < x; i++) {
            if (state[i][y].isNotOccupied() == false) {
              System.out.println("occupied in between");
              return false;
            } else if (x - 1 == i) {
              this.row = x;
              return true;
            }
          }
        } else if (row > x) {
          for (int i = row; i > x; i--) {
            if (state[i][y].isNotOccupied() == false) {
              System.out.println("occupied in between");
              return false;
            } else if (x - 1 == i) {
              this.row = x;
              return true;
            }
          }
        }

        this.row = x;
        return true;
      } else {
        return true;
      }

    }

    else if (this.row == x && this.column != y) {
      if (column > y) {
        for (int i = column; i > y; i--) {
          if (state[x][i].isNotOccupied() == false) {
            System.out.println("occupied in between part 2");
            return false;
          }
        }
      } else if (column < y) {
        for (int i = column; i < y; i++) {
          if (state[x][i].isNotOccupied() == false) {
            System.out.println("occupied in between part 2");
            return false;
          }
        }
      }

      this.column = y;
      return true;
    } else {
      this.column = y;
      return true;
    }
  }

  public String toString() {
    if (Team) {
      return "♖";
    } else {
      return "♜";
    }
  }
}