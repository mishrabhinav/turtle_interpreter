package turtle.type;

import turtle.AbstractTurtle;
import turtle.Paper;
import turtle.util.Direction;

public class BouncyTurtle extends AbstractTurtle {

  public BouncyTurtle(int x, int y, Paper paper) {
   super(x, y, paper);
  }

  public void move() {
    int i = dv.getXVector();
    int j = dv.getYVector();

    if (paper.checkBounds(x+i, y+j)) {
    	x += i;
      y += j;
    } else {
      this.turn(true, 4);
    }

    mark();
  }
}
