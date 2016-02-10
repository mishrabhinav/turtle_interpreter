package turtle;

public class DirectionVectors {

  private int dirOrdinal;

  public DirectionVectors(int dirOrdinal) {
    this.dirOrdinal = dirOrdinal;
  }

  //Method return 1 if turtle facing EAST or *_EAST
  //and -1 if facing WEST or *_WEST. If none is valid then
  //return 0.
  public int getXVector(){
    return ordinalEquality(1, 2, 3) ? 1 : (ordinalEquality(5, 6, 7) ? -1 : 0);
  }

  //Method return 1 if turtle facing NORTH or NORTH_*
  //and -1 if facing SOUTH or SOUTH_*. If none is valid then
  //return 0.
  public int getYVector(){
    return ordinalEquality(0, 1, 7) ? 1 : (ordinalEquality(3, 4, 5) ? -1 : 0);
  }

  public void setNewOrdinal(int dirOrdinal) {
    this.dirOrdinal = dirOrdinal;
  }

  public int getOrdinal(){
    return dirOrdinal;
  }

  private boolean ordinalEquality(int a, int b, int c) {
     return dirOrdinal == a || dirOrdinal == b || dirOrdinal == c;
  }
}
