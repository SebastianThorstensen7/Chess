// khushi singh
// 10.25.2022
// p.3
// team chess 

// i own rook
// am responsible for move validation

// this.x = original

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
        return false;
      } 
      else if (this.row != x && this.column == y) {
        this.row = x;
       
        for (int i =0; i<x; i++){
          if (state[i][y].isNotOccupied() == false){
            return false;
          }
      
            
          }
        }
        return true;
      } 
      else if (this.row == x && this.column != y) {
        this.column = y;

        for (int i =0; i<y; i++){
          if (state[x][i].isNotOccupied() == false){
            return false;
          }
        }
        return true;
      } 
      else {
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