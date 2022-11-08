
//Manas Kumar is in charge of this file
//10/24/2022
//P3
//I will be making changes to this file

import java.util.*;

public class Bishop extends Piece {

  Boolean Team;
  String pieceID;
  int row;
  int column;
  int slope;
  Piece bishop;
  Scanner scn;
  ArrayList<Piece> Pieces;

  public Bishop(Boolean Team, String pieceID, int row, int column, ArrayList<Piece> Pieces) {
    super(Team, pieceID, row, column);
    System.out.println("Making a bishop");
    this.Team = Team;
    this.pieceID = pieceID;
    this.row = row;
    this.column = column;
    scn = new Scanner(System.in);
    this.Pieces = Pieces;
    // move(scn);
    /*
     * for(int k = 0; k < 2; k++){
     * this.bishop = new Piece(true, "B" + k, 0, (k * 3) + 2);
     * }
     */
  }

  public void move(Scanner scn) {
    super.move(scn);
    System.out.println("Bishop move");
  }

  public int slope(int xNewPos, int yNewPos) {

    return (yNewPos - this.row) / (xNewPos - this.column);
    // return 1;
  }

  private double getSlope(double x, double y) {
    double slope = Math.abs((double) ((y - column) / (x - row)));
    System.out.println(slope);
    return slope;
  }

  // Validate move method for bishop
  public boolean validateMove(int x, int y, int[][] piecePos) {
    // If the slope is 1 or -1
    if (this.getSlope(x, y) != 1.0) {
      System.out.println("Not a valid move cause slope");
      return false;
    }
    // Sees if the move is outside the box
    else if (x < 0 || y < 0 || x > 7 || y > 7) {
      System.out.println("Not a valid move");
      return false;
    }

    // check if path is blocked

    // get path distance...
    int distance = Math.abs(y - column);

    for (int i = 0; i < distance; i++) {
      int testX = row;
      int testY = column;
      if (Math.abs(getSlope(x, y)) == 1) {
        for (int j = 0; j < Pieces.size(); j++) {
          if (Math.abs(getSlope(Pieces.get(j).getRow(), Pieces.get(j).getColumn())) == 1) {
            return false;
          }
        }
      }
    }

    for (int i = 0; i < piecePos.length; i++) {
      for (int j = 0; j < piecePos[i].length; j++) {
        if (piecePos[i][j] != x && piecePos[i][j + 1] != y) {
          return false;
        }
      }
    }

    return true;
  }

  public String toString() {
    if (Team) {
      return "♗";
    } else {
      return "♝";
    }
  }
}
