package turtle.type;

import turtle.AbstractTurtle;
import turtle.Paper;
import turtle.util.Direction;
import turtle.util.Pen;

public class NormalTurtle extends AbstractTurtle {

  public NormalTurtle(int x, int y, Paper paper) {
   super(x, y, paper);
  }

  public void move() {
    int i = dv.getXVector();
    int j = dv.getYVector();

    if (paper.checkBounds(x+i, y+j)) {
    	x += i;
      y += j;
    }

    mark();
  }
}
