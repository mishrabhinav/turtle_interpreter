package turtle.type;

import turtle.Turtle;

import java.util.List;

public class ClusterTurtle implements Turtle{

  private List<Turtle> turtles;

  public ClusterTurtle(List<Turtle> turtles) {
    this.turtles = turtles;
  }

  public void changeBrush(char brush) {
    for (Turtle turtle : turtles)
     turtle.changeBrush(brush);
  }

  public void turn(boolean right, int turns) {
    for (Turtle turtle : turtles)
      turtle.turn(right, turns);
  }

  public void move() {

  }

  public void clusterMove(int steps) {
    for (Turtle turtle : turtles)
      if (turtle instanceof ClusterTurtle)
        ((ClusterTurtle) turtle).clusterMove(steps);
      else
        for(int i = 0; i < steps; i++) {
          turtle.move();
        }
  }

  public void setPen(boolean up) {
    for (Turtle turtle : turtles)
      turtle.setPen(up);
  }
}
