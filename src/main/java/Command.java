import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public enum Command {
    L('L',RoverPosition::turnLeft),
    R('R',RoverPosition::turnRight),
    M('M',RoverPosition::move);

    public final Consumer<RoverPosition> run;
    public final Character character;

    Command(Character character, Consumer<RoverPosition> run) {
        this.character = character;
        this.run = run;
    }

    private static final Map<Character, Command> BY_CHARACTER = new HashMap<>();

    static {
        for (Command command : values()) {
            BY_CHARACTER.put(command.character, command);
        }
    }

    public static Command getCommand(Character character){
        return BY_CHARACTER.get(character);
    }
}
