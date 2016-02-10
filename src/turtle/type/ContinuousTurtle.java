package turtle.type;

import turtle.AbstractTurtle;
import turtle.Paper;
import turtle.util.Direction;

public class ContinuousTurtle extends AbstractTurtle {

  public ContinuousTurtle(int x, int y, Paper paper) {
   super(x, y, paper);
  }

  public void move() {
    int i = dv.getXVector();
    int j = dv.getYVector();
    
    x += i;
    y += j;

    if (paper.checkBounds(x, y))
      mark();
  }
}
