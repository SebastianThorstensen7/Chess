package edu.bothell.chess;

import static org.junit.Assert.assertFalse;

import org.junit.Test;
import java.util.ArrayList;

/**
 * Unit test for simple App.
 */
public class BishopTest 
{

  Square[][]       state       = new Square[8][8];
  ArrayList<Piece> pieces      = new ArrayList<Piece>();
  Boolean          currentTeam = false;
  String           pieceID     = "B";

  Bishop b = new Bishop(currentTeam, pieceID, 5, 3, pieces);
  
  
  @Test
  public void bishopShouldAnswerWithFalse()
  {
      assertFalse( b.validateMove(5, 12, state) );
  }
  
}
