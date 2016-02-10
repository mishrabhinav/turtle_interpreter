package turtle;

import turtle.util.TurtleManufacture;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

  private static TurtleInterpreter ti = new TurtleInterpreter();
  private static Paper paper = new Paper();
  private static boolean inputFilePresent = false;
  private static boolean outputFilePresent = false;
  private static Scanner input;
  private static PrintStream output;
  private static TurtleManufacture tm;

  private static final int MIN_TURN = 45;

  public static void main(String[] args) throws FileNotFoundException {

    if (args.length == 2) {
      inputFilePresent = true;
      outputFilePresent = true;
    } else if (args.length == 1)
      inputFilePresent = true;

    input = inputFilePresent ? new Scanner(new File(args[0]))
                             : new Scanner(System.in);

    output = outputFilePresent ? new PrintStream(new File(args[1]))
                               : new PrintStream(System.out);

    tm = new TurtleManufacture(input, output, paper, ti);
    commandParser();
  }

  public static void commandParser() throws FileNotFoundException {

    printAngB();
    while(input.hasNext()) {
      String command = input.next();
      if (command.equals("exit") || command.equals("EXIT"))
        break;

      parseTokens(command);
      printAngB();
    }
  }

  private static void printAngB() {
    output.print(outputFilePresent ? "" : "> ");
  }

  private static void parseTokens(String inp) throws FileNotFoundException {

    switch(inp) {
      case "paper":
        paper = new Paper(input.nextInt(), input.nextInt());
        tm.setPaper(paper);
        break;

      case "new":
        String type = input.next();
        if (type.equals("cluster"))
          tm.clusterToken("");
        else
          tm.newTurtleToken(type, "");
        break;

      case "pen":
        String name = input.next();
        String state = input.next();
        ti.penChange(name, state.length() > 1, state.charAt(0));
        break;

      case "move":
        ti.moveParse(input.next(), input.nextInt());
        break;

      case "right":
      case "left":
        ti.turnParse(input.next(), inp.equals("right"),
                     input.nextInt()/MIN_TURN);
        break;

      case "show":
        output.print(paper.toString());
        break;

      case "save":
        PrintStream newOutput = new PrintStream(new File(input.next()));
        newOutput.print(paper.toString());
        break;

      case "repeat":
        List<String> repeatMode = new ArrayList<>();
        int repeats = input.nextInt();
        String next = "";
        while(!next.equals("end")) {
          next = input.next();
          repeatMode.add(next);
        }
        repeatMode.remove(repeatMode.size()-1);
        Repeater repeater = new Repeater(ti, tm, paper, output,
                                         repeatMode, repeats);
        repeater.repeat();
        break;

      default:
        output.println("Error: Command not recognized.");
        input.nextLine();
        break;
    }
  }
}
