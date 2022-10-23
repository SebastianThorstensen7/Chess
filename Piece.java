import java.util.Scanner;

public class Piece {
  // Fields -- or state variables
  // what our Piece has
  Boolean Team;
  String pieceID;
  int row;
  int column;

  // Constructor
  public Piece(Boolean Team, String pieceID, int row, int column) {
    this.Team = Team;
    this.pieceID = pieceID;
    this.row = row;
    this.column = column;
  }

  // Methods -- or functions ==> what our class can do

  public void move(Scanner scn){
    boolean invalidMove = true;
    while(invalidMove) {
    System.out.println("Where would you like the piece to go? (x,y)");
    String response = scn.next();
    int x = Integer.parseInt(response.substring(0,response.indexOf(","))) - 1;
    int y = Integer.parseInt(response.substring(response.indexOf(",") + 1)) - 1;
    Boolean valid = this.validateMove(x,y);
    if(x <= 7 && y <= 7 && valid) {
      this.row = x;
      this.column = y;
      invalidMove = false;
    }
    }
  }

  
  //validate move method
  public boolean validateMove(int x, int y) {
    return true;
  }


  
  public int getRow() {
    return this.row;
  }

  public int getColumn() {
    return this.column;
  }

  public String getPieceID() {
    return this.pieceID;
  }

  public boolean getTeam() {
    return this.Team;
  }

  

}