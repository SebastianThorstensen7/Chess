/**
* This is a plausable refactor of the Board object.
*
* @author  Gus Reiber
* @version 1.0
* @since   2023-01-01 
*/

package edu.bothell.chess;

import java.util.Scanner;

public class Turn{

  private Player player = new Player();
  private B board;
  
  private boolean check;
  private boolean checkMate = false;
  private Scanner scn = new Scanner(System.in);
  
  ///////////////////////////////////////////////
  // CONSTRUCTOR(S) of chess TURN
  /////////////////////////////////////////////// 
   /**
   * Constructs a turn
   */ 
  public Turn(){
    System.out.println("TURN?");
  }
  public Turn(B board){
    this.board = board;
    doTurn();
  }
  public Turn(Player player, B board ){
    this.board = board;
    this.player = player;
    doTurn();   
  }

  public void doTurn(){
 // find my pieces!
    //this.check = board.isCheck();

    // name player
    intro();
    
    // draw board...
    draw();
    
    // check for check
    check();

    // get user input
    while(!this.getValidMove()) this.warnInvalid();

    // commit move
    commit();
  }
  
  public void draw(){
    board.init();
    board.draw();
  }
  
  public boolean checkMate(){
    return checkMate;
  }
  
  public boolean getValidMove(){
      int x1; int y1; int x2; int y2;
      boolean valid;
      System.out.println("============================");
      System.out.println("Move from (x y) to (x, y)");
      System.out.println("Enter 4 numbers seperated by spaces...");
      x1 = scn.nextInt(); y1 = scn.nextInt(); x2 = scn.nextInt(); y2 = scn.nextInt(); 

      valid = board.checkMove( x1, y1, x2, y2);
    
      System.out.println("valid mode: " + valid);

      scn.reset();
      System.out.println("============================"); 

    return valid;
  }

  private void warnInvalid(){
    System.out.println("Can't do it!");
  }

  private void commit(){
    System.out.println("capturing? " + board.getCaptured());
    System.out.println("new Square? " + board.getActiveSquare());

    board.commitMove();
    System.out.println();
    System.out.println();
    System.out.println();

  }
  
  private void check(){
    System.out.println( "player about to play: " + player.getName() );
    System.out.println( "is player in check?: " + check );    
  }

  private void intro(){
    System.out.println();
    System.out.println("============================");
    System.out.println(" I AM A TURN!");
    System.out.println("============================");    
  }
}