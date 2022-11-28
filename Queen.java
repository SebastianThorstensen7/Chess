import java.util.Scanner;
public class Queen extends Piece{

  Boolean    Team;
  String     pieceID;
  int        row;
  int        column;
  
  public Queen(Boolean Team, String pieceID, int row, int column){
    super(Team,pieceID,row,column);
    this.Team = Team;
    this.pieceID = pieceID;
    this.row = row;
    this.column = column;
  }
  
  public void move(Scanner scn){
    super.move(scn);
    System.out.println("Queen move");
  }

  //Validate move method for Queen
  public boolean validateMove(int row, int column, Square[][] state) {
    System.out.println("Move method is being called");
    int yDistance = Math.abs(y - column);

    if (this.row == x && this.column == y) {
      System.out.println("Thats the same spot its in(invalide move)");
      return false;
    }

    else if ((x > 0 && x <= 8) || (y > 0 && y <= 8)) {
      int xInt = (row+1);
      int yInt = (column+1);

      if (this.getSlope(x, y).equals("1.0")) {
        for (int i = 0; i < yDistance; i++) {
          if(x < row && y > column){
            xInt --;
            yInt ++;
          }
          else if(x < row && y < column){
            xInt --;
            yInt --;
          }
          else if(x > row && y > column){
            xInt ++;
            yInt ++;
          }
          else if(x > row && y < column){
            xInt ++;
            yInt --;
          }

          if (state[xInt][yInt].isNotOccupied() == false) {
            System.out.println("occupied in between");
            return false;
          }
        }
        System.out.println("Valid move");
      }
      else if(!this.getSlope(x, y).equals("1.0")){
        System.out.println("Not a diagonal move");
        return false;
      }
    }
    else if(!(x > 0 && x <= 8) || !(y > 0 && y <= 8)){
      System.out.println("This is outside the board");
      return false;
    }
        if (state[x][y].isNotOccupied()) {
      if (this.row != x && this.column != y) {
        System.out.println("both are different");
        return false;
      } 
      else if (this.row != x && this.column == y) {
        for (int i =0; i < x; i++){
          if (state[i][y].isNotOccupied() == false){
            System.out.println("occupied in between");
            return false;
          }
          else if (x-1 == i){
            this.row = x;
            return true;
          }
          
         }
        this.row = x;
        return true;
        }
      else {
        return true;
      }
       
      } 
      
      else if (this.row == x && this.column != y) {
        
        for (int i =0; i<y; i++){
          if (state[x][i].isNotOccupied() == false){
            System.out.println("occupied in between part 2");
            return false;
          }
        }
        this.column = y;
       return true;
      } 
      else {
        this.column = y;
        return true;
      }
  }

  public String toString() {
    if(Team) {
      return "♕";
    } else {
      return "♛";
    }
  }
}