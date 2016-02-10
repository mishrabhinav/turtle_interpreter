package turtle;

public class Paper {

  private int width;
  private int height;
  private char[][] paper;

  public Paper() {
    paperDimension(10,10);
  }

  public Paper(int width, int height) {
    paperDimension(width, height);
  }

  private void paperDimension(int width, int height) {
    this.width = width;
    this.height = height;
    initialisePaper();
  }

  private void initialisePaper(){
    paper = new char[height][width];
    for (int i = 0; i < height; i++)
      for (int j = 0; j < width; j++)
        paper[i][j] = ' ';
  }

  public boolean checkBounds(int x, int y) {
    return (0 <= x && x < width) && (0 <= y && y < height);
  }

  public boolean hitX(int x) {  //Returns true if turtle goes outside paper.
    return (-1 == x || x == width);
  }

  public boolean hitY(int y) {  //Returns true if turtle goes outside paper.
    return (-1 == y || y == height);
  }

  public int wrapX(int x) {
    return x < 0 ? width - 1 : x % width;
  }

  public int wrapY(int y) {
    return y < 0 ? height - 1 : y % height;
  }

  public void mark(int x, int y, char brush) {
    if (checkBounds(x, y))
      paper[y][x] = brush;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();

    for (int i = height - 1; i >= 0; i--) {
      sb.append(new String(paper[i]));
      sb.append('\n');
    }

    sb.append('\n');
    return sb.toString();
  }
}
