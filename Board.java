import java.util.*;

public class Board {

  Square[][] state = new Square[8][8];
  ArrayList<Piece> Captured;
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
        System.out.print(state[i][j]);
      }
      System.out.println();
      System.out.println();
    }
  }

  public void updateState() {
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        Square meSquare = new Square();
        state[i][j] = meSquare;
        for (Piece p : Pieces) {
          if ((p.getRow() == i) && (p.getColumn() == j)) {
            meSquare.setPiece(p);
            state[i][j] = meSquare;
          }
        }
      }
    }
    this.Draw();
  }

  public void selectPiece() {
    boolean invalid = true;
    while (invalid) {
      System.out.println("Please select a valid piece to move");
      String response = scn.next();
      for (Piece p : Pieces) {
        if (p.getPieceID().equals(response) && currentTeam == p.getTeam()) {
          this.move(p);
          invalid = false;
        }
      }
    }

  }

  public void switchTeam() {
    this.currentTeam = !currentTeam;
  }

  public void move(Piece p) {
    boolean invalidMove = true;
    System.out.println("Where would you like the piece to go? (row,column) or 'back' to select another piece.");
    while (invalidMove) {
      String response = scn.next();
      if (response.equals("back")) {
        this.selectPiece();
        break;
      } else {
        int column = Integer.parseInt(response.substring(0, response.indexOf(","))) - 1;
        int row = Integer.parseInt(response.substring(response.indexOf(",") + 1)) - 1;
        Boolean valid = p.validateMove(column, row, state);
        if (valid) {
          p.row = column;
          p.column = row;
          invalidMove = false;
        } else {
          System.out.println("Invaild Move");
        }
      }

    }
  }

}