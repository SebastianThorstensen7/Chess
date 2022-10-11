
public class Piece {
  // Fields -- or state variables
  // what our Piece has
  Boolean    Team;
  String     pieceID;
  int        row;
  int        column;
  
  // Constructor  
  public Piece(Boolean Team, String pieceID, int row, int column){
    this.Team = Team;
    this.pieceID = pieceID;
    this.row = row;
    this.column = column;
  }

  // Methods -- or functions ==> what our class can do

  public void move(int x, int y){
    this.row = x;
    this.column = y;
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