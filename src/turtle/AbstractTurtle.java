package turtle;

import turtle.util.Direction;
import turtle.util.Pen;

public abstract class AbstractTurtle implements Turtle {

  protected Direction direction;
  protected DirectionVectors dv;
  protected Pen pen;
  protected Paper paper;
  protected int x;
  protected int y;
  protected int directionOrdinal = Direction.values().length;

  public AbstractTurtle(int x, int y, Paper paper) {
    this.direction = Direction.NORTH;
    this.dv = new DirectionVectors(direction.ordinal());
    this.pen = new Pen('*', true);
    this.x = x;
    this.y = y;
    this.paper = paper;
  }

  public void setPen(boolean up) {
    pen.changeState(up);
  }

  public void changeBrush(char brush) {
    pen.setBrush(brush);
  }

  public void turn(boolean right, int turns) {

    int currentOrdinal = direction.ordinal();
    direction = right ?
      Direction.values()[(currentOrdinal + turns)%directionOrdinal] :
      Direction.values()[(directionOrdinal + currentOrdinal -
                            turns)%directionOrdinal];

    dv.setNewOrdinal(direction.ordinal());
  }

  protected void mark() {
    if(pen.penDown())
      paper.mark(x, y, pen.getBrush());
  }

  public abstract void move();
}
