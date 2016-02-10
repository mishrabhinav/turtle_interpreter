package turtle.type;

import turtle.AbstractTurtle;
import turtle.Paper;
import turtle.util.Direction;

public class ReflectingTurtle extends AbstractTurtle {

  public ReflectingTurtle(int x, int y, Paper paper) {
   super(x, y, paper);
  }

  public void move() {
    int i = dv.getXVector();
    int j = dv.getYVector();

    x += i;
    y += j;

    if (!paper.checkBounds(x, y))
      reflector(i, j);

    mark();
  }

  private void reflector(int i, int j) {
    boolean paperHitX = paper.hitX(x);
    boolean paperHitY = paper.hitY(y);
    int ordinal = dv.getOrdinal();

    if (paperHitY && ordinal != 2 && ordinal != 6) {
      y -= j;
      int newOrdinalSum = ordinal > 4 ? 12 : 4;
      direction = Direction.values()[newOrdinalSum - ordinal];
    }

    if (paperHitX && ordinal != 0 && ordinal != 4) {
      x -= i;
      direction = Direction.values()[directionOrdinal - ordinal];
    }

    dv.setNewOrdinal(direction.ordinal());
  }
}
