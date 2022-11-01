import java.util.*;

public class Board {

  Square[][] State = new Square[8][8];
  ArrayList<Piece> p1capture;
  ArrayList<Piece> p2capture;
  ArrayList<Piece> Pieces;
  Boolean currentTeam = false;
  Scanner scn = new Scanner(System.in);

  public Board(ArrayList<Piece> Pieces) {
    this.Pieces = Pieces;
    this.updateState();
  }

  public void Draw() {
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        System.out.print(State[i][j]);
      }
      System.out.println();
      System.out.println();
    }
  }

  public void updateState() {
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        Square meSquare = new Square();
        State[i][j] = meSquare;
        for (Piece p : Pieces) {
          if ((p.getRow() == i) && (p.getColumn() == j)) {
            meSquare.setPiece(p);
            State[i][j] = meSquare;
          }
        }
      }
    }
    this.Draw();
  }

  public void selectPiece() {
    boolean valid = true;
    while (valid) {
      System.out.println("Please select a valid piece to move");
      String Response = scn.next();
      for (Piece p : Pieces) {
        if (p.getPieceID().equals(Response) && currentTeam == p.getTeam()) {
          this.move(p);
          valid = false;
        }
      }
    }

  }

  public void switchTeam() {
    this.currentTeam = !currentTeam;
  }

  public void move(Piece p) {
    boolean invalidMove = true;
    while (invalidMove) {
      System.out.println("Where would you like the piece to go? (x,y)");
      String response = scn.next();
      int x = Integer.parseInt(response.substring(0, response.indexOf(","))) - 1;
      int y = Integer.parseInt(response.substring(response.indexOf(",") + 1)) - 1;
      Boolean valid = p.validateMove(x, y, State[x][y]);
      if (valid) {
        p.row = x;
        p.column = y;
        invalidMove = false;
      }
    }
  }

}