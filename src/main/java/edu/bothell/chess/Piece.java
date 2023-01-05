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

  public void setSquare(Square square){
    this.square = square;
    this.column = square.getColumn();
    this.row = square.getRow();
  }
  
  public void move(Scanner scn) {

  }

  // validate move method
  // Super method is king movement
  public boolean validateMove(Square x) {
    if( x.isTeam(team) ) return false;
    if (this.column != x.getColumn() && this.row != x.getRow()) {
        if ((this.column + 1 == x.getColumn()) || (this.column - 1 == x.getColumn())) {
          if ((this.row + 1 == x.getRow()) || (this.row - 1 == x.getRow() )) {
            return true;
          }
        } 
      } else if((this.column != x.getColumn()) && (this.row == x.getRow()) ) {
        if(this.column + 1 == x.getColumn() || this.column - 1 == x.getColumn()) {
          return true;
        } 
      } else if((this.column == x.getColumn()) && (this.row != x.getRow())) {
        if ((this.row + 1 == x.getRow()) || (this.row - 1 == x.getRow() )) {
            return true;
        } 
      } 
    return false;
  }

  //Method to check if there a pieces between a location and destination
  public boolean checkInbetween(Square[][] Board) {
    
    return true;
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