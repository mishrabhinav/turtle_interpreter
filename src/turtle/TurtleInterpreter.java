package turtle;

import turtle.type.ClusterTurtle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TurtleInterpreter {

  private final HashMap<String, Turtle> turtles = new HashMap<>();
  private final List<String> turtleNames = new ArrayList<>();

  public Turtle addTurtle(String name, Turtle turtle) {
    turtles.put(name, turtle);
    turtleNames.add(name);
    return turtle;
  }

  private Turtle getTurtle(String name) {
    return turtles.get(name);
  }

  private List<Turtle> wildcards(String name) {
    String[] names = name.split(",");
    List<Turtle> globTurtles = new ArrayList<>();

    for (int i = 0; i < names.length; i++) {
      String pref = names[i].endsWith("*") ?
                    names[i].substring(0, names[i].length() - 1) :
                    names[i];


      if (pref.equals(names[i]))
        globTurtles.add(getTurtle(names[i]));
      else
        for (String turtle : turtleNames)
          if (turtle.startsWith(pref))
            globTurtles.add(getTurtle(turtle));
    }
    return globTurtles;
  }

  public void moveParse(String name, int steps) {
    List<Turtle> focusTurtle = wildcards(name);

    for (Turtle turtle : focusTurtle) {
      if (turtle instanceof ClusterTurtle)
        ((ClusterTurtle) turtle).clusterMove(steps);
      else
        for (int i = 0; i < steps; i++) {
          try {
            turtle.move();
          } catch (NullPointerException e) {
            System.out.println("Error: Turtle '" + name + "' not found.");
            break;
          }
        }
    }
  }

  public void turnParse(String name, boolean right, int turns) {
    List<Turtle> focusTurtle = wildcards(name);
    for (Turtle turtle : focusTurtle)
      turtle.turn(right, turns);
  }

  public void penChange(String name, boolean forState, char brush) {
    List<Turtle> focusTurtle = wildcards(name);
    for (Turtle turtle : focusTurtle) {
      if (forState)
        turtle.setPen(brush == 'u');
      else
        turtle.changeBrush(brush);
    }
  }

}
