package turtle.util;

import turtle.Paper;
import turtle.Turtle;
import turtle.TurtleInterpreter;
import turtle.type.*;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TurtleManufacture {

  private Scanner input;
  private PrintStream output;
  private Paper paper;
  private TurtleInterpreter ti;

  public TurtleManufacture(Scanner input, PrintStream output, Paper paper,
                           TurtleInterpreter ti) {
    this.input = input;
    this.output = output;
    this.paper = paper;
    this.ti = ti;
  }

  public Turtle newTurtleToken(String type, String clusterName) {

    String name = (!clusterName.equals("") ? clusterName + "." : clusterName)
                                                                + input.next();
    int x = input.nextInt();
    int y = input.nextInt();

    switch (type) {
      case "normal":
        return ti.addTurtle(name, new NormalTurtle(x, y, paper));

      case "continuous":
        return ti.addTurtle(name, new ContinuousTurtle(x, y, paper));

      case "bouncy":
        return ti.addTurtle(name, new BouncyTurtle(x, y, paper));

      case "reflecting":
        return ti.addTurtle(name, new ReflectingTurtle(x, y, paper));

      case "wrapping":
        return ti.addTurtle(name, new WrappingTurtle(x, y, paper));

      default:
        output.println("Error: Turtle type '" + type + "' not defined.");
        input.nextLine();
        if (clusterName.length() > 0) {
          input.next();
          output.print("> new ");
          return newTurtleToken(input.next(), clusterName);
        } else {
          return null;
        }
    }
  }

  public Turtle clusterToken(String parentCluster) {
    String clusterName = (!parentCluster.equals("") ?
                            parentCluster + "." :
                            parentCluster
                         ) + input.next();

    int clusterSize = input.nextInt();

    List<Turtle> clusterList = new ArrayList<>();

    while(clusterSize > 0) {
      if (input.next().equals("new")) {
        String type = input.next();

        clusterList.add(type.equals("cluster") ?
          clusterToken(clusterName) :
          newTurtleToken(type, clusterName));
        clusterSize--;
      } else {
        output.println("Cluster Turtle Initialization failed.");
        System.exit(1);
        break;
      }
    }

    return ti.addTurtle(clusterName, new ClusterTurtle(clusterList));
  }

  public void setPaper(Paper paper) {
    this.paper = paper;
  }
}
