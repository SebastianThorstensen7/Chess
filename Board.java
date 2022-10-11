import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Board {

  Square[][] State = new Square[8][8];
  ArrayList<Piece> p1capture;
  ArrayList<Piece> p2capture;
  ArrayList<Piece> Pieces;
  Boolean currentTeam = true;
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
          p.move(4,4);
          valid = false;
        }
      }
    }
    
  }

  public void switchTeam() {
    this.currentTeam = !currentTeam;
  }

}