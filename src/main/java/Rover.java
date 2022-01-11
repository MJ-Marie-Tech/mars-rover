import java.util.Arrays;

public class Rover {

    public  static void process(String commands,String roverPosition) {

        RoverPosition position= new RoverPosition(roverPosition);

        Arrays.stream(commands.split(""))
                .map(s->Command.getCommand(s.charAt(0)))
                .forEach(c->c.run.accept(position));

        System.out.println(position);

    }

    public static void main(String args[]) {

        process("LMLMLMLMM","1 2 N");

        process("MMRMMRMRRM","3 3 E");

    }
}
