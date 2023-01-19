package edu.bothell.chess;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class BishopTest {

  B board = new B();
  
  @Test
  public void bishopShouldAnswerWithFalse() {
    assertFalse(board.checkMove(2, 2, 5, 12));
  }

}
