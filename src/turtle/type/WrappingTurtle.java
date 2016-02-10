package turtle.type;

import turtle.AbstractTurtle;
import turtle.Paper;
import turtle.util.Direction;

public class WrappingTurtle extends AbstractTurtle {

  public WrappingTurtle(int x, int y, Paper paper) {
   super(x, y, paper);
  }

  public void move() {
    int i = dv.getXVector();
    int j = dv.getYVector();

    x = paper.wrapX(x + i);
    y = paper.wrapY(y + j);
  	mark();
  }
}
