public class Queen extends Piece{

  Boolean    Team;
  String        pieceID;
  int        row;
  int        column;
  
  public Queen(Boolean Team, String pieceID, int row, int column){
    super(Team,pieceID,row,column);
    this.Team = Team;
    this.pieceID = pieceID;
    this.row = row;
    this.column = column;
  }
  
  public void move(int x,int y){
    super.move(x,y);
    System.out.println("Queen move");
  }

  public String toString() {
    if(Team) {
      return "♕";
    } else {
      return "♛";
    }
  }
}