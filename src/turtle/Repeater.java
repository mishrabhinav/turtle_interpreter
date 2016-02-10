package turtle;

import turtle.util.TurtleManufacture;

import java.io.PrintStream;
import java.util.List;

public class Repeater {

  private TurtleInterpreter ti;
  private TurtleManufacture tm;
  private Paper paper;
  private PrintStream output;
  private List<String> repeatCommands;
  private int repeats;

  public Repeater(TurtleInterpreter ti, TurtleManufacture tm, Paper paper,
                  PrintStream output, List<String> repeatCommands, int repeats){
    this.ti = ti;
    this.tm = tm;
    this.paper = paper;
    this.output = output;
    this.repeatCommands = repeatCommands;
    this.repeats = repeats;
  }

  public void repeat() {
    int size = repeatCommands.size();
    int maxCommands = size*repeats;

    for (int i = 0; i < maxCommands; ) {
      int j = i % size;
      String token = get(j);
      switch (token) {
        case "paper":
          paper = new Paper(getInt(j + 1), getInt(j + 2));
          tm.setPaper(paper);
          break;

        case "move":
          ti.moveParse(get(j + 1), getInt(j + 2));
          break;

        case "right":
        case "left":
          ti.turnParse(get(j + 1), token.equals("right"), getInt(j + 2));
          break;

        case "show":
          output.println(paper.toString());
          break;
      }
      i = updateI(token.equals("show"), i);
    }
  }

  private int updateI(boolean show, int i){
   return i + (show ? 1 : 3);
  }

  private int getInt(int i) {
    return Integer.parseInt(repeatCommands.get(i));
  }

  private String get(int i) {
    return repeatCommands.get(i);
  }
}
