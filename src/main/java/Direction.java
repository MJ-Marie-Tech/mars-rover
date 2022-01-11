import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public enum Direction {
    N(1,Position::moveNorth,'N'),
    E(2,Position::moveEast,'E'),
    S(3,Position::moveSouth,'S'),
    W(4,Position::moveWest,'W');

    public final Integer value;
    public final Character character;
    public final Consumer<Position> run;

    Direction(Integer value,Consumer<Position> run, Character character) {
        this.value = value;
        this.run= run;
        this.character= character;
    }

    private static final Map<Integer, Direction> BY_VALUE = new HashMap<>();
    public static final Map<Character, Direction> BY_CHARACTER = new HashMap<>();

    static {
        for (Direction direction : values()) {
            BY_VALUE.put(direction.value, direction);
            BY_CHARACTER.put(direction.character, direction);
        }
    }

    public static Direction getDirection(Integer value){
        return BY_VALUE.get(value);
    }

    public static Direction getDirection(Character character){
        return BY_CHARACTER.get(character);
    }

}
