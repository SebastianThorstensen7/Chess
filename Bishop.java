public class Bishop extends Piece{

  Boolean    Team;
  String     pieceID;
  int        row;
  int        column;
  
  public Bishop(Boolean Team, String pieceID, int row, int column){
    super(Team,pieceID,row,column);
    this.Team = Team;
    this.pieceID = pieceID;
    this.row = row;
    this.column = column;
  }
  
  public void move(int x, int y){
    super(x,y);
    System.out.println("Bishop move");
  }

  public String toString() {
    if(Team) {
      return "♗";
    } else {
      return "♝";
    }
  }
}