/**
* This is a plausable refactor of the Board object.
*
* @author  Gus Reiber
* @version 1.0
* @since   2023-01-01 
*/

package edu.bothell.chess;

import java.util.ArrayList;
import java.util.Scanner;

public class B{

  ///////////////////////////////////////////////
  // PROPERTIES of CHESS BOARD
  ///////////////////////////////////////////////
  /**
   * The two main properties of the board is the squares and the pieces on them
   */
  private Square[][]       board   = new Square[8][8];
  private ArrayList<Piece> pieces  = new ArrayList<Piece>();
  private ArrayList<Turn>  turns  = new ArrayList<Turn>();
  private Player[]         players = new Player[2];
  private String           name    = "THE CHESS GAME!";
  private Player           activePlayer;
  private Turn             activeTurn;
  private Piece            activePiece;
  private Piece            captured;
  private Square           activeSquare;
  private boolean          gameOver;

  
  ///////////////////////////////////////////////
  // CONSTRUCTOR(S) of CHESS BOARD
  /////////////////////////////////////////////// 
   /**
   * Constructs a game board
   */  
  public B(){
    gameOver = false;
    players[0] = new Player("Stever", true);
    players[1] = new Player("Suezy Q", false);
    // TODO: These pieces are for testing purposes....
    pieces.add(new Bishop(true, 3, 5, this ));
    pieces.add(new Bishop(false, 2, 2, this ));
    pieces.add(new Pawn(false, 4, 4, this ));
    pieces.add(new Rook(false, 1, 7, this ));
    /////////////////////////////////////////////
    
    init();
    while(!gameOver){
      for(Player p : players){
        activePlayer = p;
        activeTurn = new Turn(p, this);
        turns.add(activeTurn);
        gameOver = activeTurn.checkMate();
        if(gameOver) return;
        
      }
    }
    //draw();
    //makeMove();
  }
  /**
   * Constructs a game board with specific pieces
   * @param  pieces  ArrayList<Piece> describing the pieces on the board
   */   
  public B(ArrayList<Piece> pieces){
    this.pieces = pieces;
    init();
    draw();
    makeMove();
  }

  
  ///////////////////////////////////////////////
  // METHODS of CHESS BOARD
  ///////////////////////////////////////////////
  public boolean isCheck(){
    return false;
  }

  public void setPieces(ArrayList<Piece> pieces){
    this.pieces = pieces;
    init();
  }
  
   /**
   * makeMove contols the UI for the player making moves.
   */
  public void makeMove(){
    Scanner scn = new Scanner(System.in);

    int x1; int y1; int x2; int y2;
    boolean valid;
    
    while(true){
      System.out.println("============================");
      System.out.println("Move from (x y) to (x, y)");
      System.out.println("Enter 4 numbers seperated by spaces...");
      x1 = scn.nextInt(); y1 = scn.nextInt(); x2 = scn.nextInt(); y2 = scn.nextInt(); 

      valid = checkMove( x1, y1, x2, y2);
      System.out.println("valid mode: " + valid);

      scn.reset();
      System.out.println("============================");
    }
  }
  
   /**
   * checkMove does the work of checking the move based on 4 coordinate numbers of the board
   * @param  x1  int piece's x position
   * @param  y1  int piece's y position
   * @param  x2  int destination square x position
   * @param  y2  int destination square y position
   * @return  boolean  is it valid?
   */
  public boolean checkMove(int x1, int y1, int x2, int y2){
    activePiece = null;
    activeSquare = null;
    captured = null;
    
    try{ // get Piece to move
      activePiece = getPiece(x1, y1);
      if(activePlayer.getTeam() != activePiece.getTeam()) return false;
    }
    catch(Exception e){
      System.out.println("Not a valid piece!");
    }
    try{ // get destination
      activeSquare = board[y2][x2];
    }
    catch(Exception e){
      System.out.println("Not a valid desination");
    }
    // if either fails return false...
    if(activePiece == null || activeSquare == null) return false;

    if(!activeSquare.isEmpty()) captured = activeSquare.getPiece();
    
    // Use the piece to check its move
    return activePiece.checkMove(activeSquare);
  }
  
  /**
   * @return the pieces on the board
   */    
  public ArrayList<Piece> getPieces(){
    return pieces;  
  }
  
  /**
   * @return the squares on the board
   */    
  public Square[][] getBoard(){
    return board;  
  }

  /**
   * @return Square at x,y location
   */   
  public Square getSquare(int x, int y){
    return board[y][x];
  }

  public Square getActiveSquare(){
    return this.activeSquare;
  }
  
  public Piece getActivePiece(){
    return this.activePiece;
  }
  
  public Piece getCaptured(){
    return this.captured;
  }

  public void removePiece(Piece p){
    pieces.remove(p);
  }

  public void commitMove(){
    pieces.remove(captured);
    activePiece.setSquare(activeSquare);
  }
  
  /**
   * @return Piece at x,y location
   */ 
  public Piece getPiece(int x, int y){
    return board[y][x].getPiece();
  }

   /**
   * Sets up the board with new squares and pieces in them if applicable
   */  
  public void init(){

    for (int y = 0; y < board.length; y++) {  
      for(int x = 0; x < board[y].length; x++){

        this.board[y][x] = new Square(x,y);
        for(Piece p : pieces){
          if( p.getRow() == y && p.getColumn() == x ) {
            board[y][x].setPiece(p);
          }
        }
        
      }
    }

    
  }

  /**
   * Draws the board based on this object's positioned player list
   */ 
  public void draw(){
    for(Square[] row : board){
      for(Square s : row)
        System.out.print(s);
      System.out.println();
    }
  }

  
}