package edu.bothell.chess;
import java.util.Scanner;

public class Piece {
  // Fields -- or state variables
  // what our Piece has
  boolean team;
  String pieceID = "Is this necissary?"; //TODO: Do you need this?
  int row;
  int column;
  private Square square;
  private B state;

  // Constructor
  public Piece(boolean team, String pieceID, int row, int column) {
    this.team = team;
    this.pieceID = pieceID;
    this.row = row;
    this.column = column;
  }

  /**
   * GUS: New constructore for a Piece -- adding a board and removing the ID
   * rows and columns seem backwards to me?
   * @param  team    boolean  
   * @param  row     int
   * @param  column  int
   * @param  board   Board type with Square[][] and ArrayList<Piece>
   */
  public Piece(boolean Team, int column, int row, B state) {
    this.team = Team;
    this.column = column;
    this.row = row;
    this.state = state;
  }

  
  ///////////////////////////////////////////////
  // METHODS of CHESS PIECE(s)
  ///////////////////////////////////////////////
  /**
   * GUS: Starts the process of checking a move. 
   * Can Override for specific pieces
   * @param  x    X marks the spot of the Square to move to
   * @retrun boolean saying if the move is OK
   */
  public boolean checkMove(Square x){
    // TODO: This does not check if pieces are in between.
    // That needs a new method that will check the spaces between.
    // basing on Queen....
    
    // moving to square occupied by the same team is always no good...
    if( x.isTeam(team) ) return false;

    // moving like a rook...
    if(x.getRow() == row || x.getColumn() == column) return true;

    // moving like a bishop
    if( Math.abs((x.getRow() - row) / (x.getColumn() - column)) == 1) return true;

    return false;
  }

  public void setSquare(Square square){
    this.square = square;
    this.column = square.getColumn();
    this.row = square.getRow();
  }
  
  public void move(Scanner scn) {

  }

  // validate move method
  // Super method is king movement
  public boolean validateMove(int row, int column, Square[][] state) {
    if (state[row][column].isNotOccupied()) {
      if (this.column != column && this.row != row) {
        if ((this.column + 1 == column) || (this.column - 1 == column)) {
          if ((this.row + 1 == row) || (this.row - 1 == row )) {
            return true;
          }
        } 
      } else if((this.column != column) && (this.row == row) ) {
        if(this.column + 1 == column || this.column - 1 == column) {
          return true;
        } 
      } else if((this.column == column) && (this.row != row)) {
        if ((this.row + 1 == row) || (this.row - 1 == row )) {
            return true;
        } 
      } 
    } else {
      Piece p = state[row][column].getPiece();
      if(p.getTeam() != this.team) {
        return true;
      } 
    }
    return false;
  }

  public void setRow(int row) {
    this.row = row;
  }

  public int getRow() {
    return this.row;
  }

  public void setColumn(int column) {
    this.column = column;
  }

  public int getColumn() {
    return this.column;
  }

  public String getPieceID() {
    return this.pieceID;
  }

  public boolean getTeam() {
    return this.team;
  }

}