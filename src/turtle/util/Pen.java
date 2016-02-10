package turtle.util;

public class Pen {

  private boolean penUp; //true denotes pen is Up and false for pen down.
  private char brush;

  public Pen(char brush, boolean penUp) {
    this.brush = brush;
    this.penUp = penUp;
  }

  public void changeState(boolean up) {
    penUp = up;
  }

  public boolean penDown() {
    return !penUp;
  }

  public void setBrush(char brush) {
    this.brush = brush;
  }

  public char getBrush() {
    return brush;
  }
}
