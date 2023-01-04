package edu.bothell.chess;

public class Player{
  String name = "PLAYER-X";
  boolean currentTeam = true;
  
  public Player(){
    
  }
  public Player(String name){
    this.name = name;
  }
  public Player(String name, boolean team){
    this.name = name;
    this.currentTeam = team;
  }

  public String getName(){
    return name;
  }

  public boolean getTeam(){
    return currentTeam;
  }
}