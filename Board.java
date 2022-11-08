import java.util.*;

public class Board {

  Square[][] state = new Square[8][8];
  ArrayList<Piece> Captured = new ArrayList<Piece>();
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

  public Piece selectPiece() {
    boolean invalid = true;
    while (invalid) {
      System.out.println("Please select a valid piece to move");
      String response = scn.next();
      for (Piece p : Pieces) {
        if (p.getPieceID().equals(response) && currentTeam == p.getTeam()) {
          return p;
        }
      }
    }
    return null;
  }

  public void switchTeam() {
    this.currentTeam = !currentTeam;
  }

  public void move() {
    Piece p = this.selectPiece();
    boolean invalidMove = true;
    while (invalidMove) {
      System.out.println("Where would you like the piece to go? (row,column) or 'back' to select another piece.");
      String response = scn.next();
      if (response.equals("back")) {
        p = this.selectPiece();
      } else {
        int column = Integer.parseInt(response.substring(0, response.indexOf(","))) - 1;
        int row = Integer.parseInt(response.substring(response.indexOf(",") + 1)) - 1;
        Boolean valid = p.validateMove(column, row, state);
        if (valid) {
          p.row = column;
          p.column = row;
          this.takePiece(p);
          invalidMove = false;
        } else {
          System.out.println("Invaild Move");
        }
      }

    }
  }

  public void takePiece(Piece p1) {
    Piece temp = null;
    for (Piece p : Pieces) {
        if (p1.getRow() == p.getRow() && p1.getColumn() == p.getColumn()) {
          if (p1.getTeam() != p.getTeam()) {
            temp = p;
            Captured.add(p);
            System.out.println("Removing " + temp.toString());
          }
        }
    }
    Pieces.remove(temp);
  }

}