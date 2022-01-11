public class Orientation {
    private final static Direction MIN_DIRECTION= Direction.N;
    private final static Direction MAX_DIRECTION= Direction.W;
    private Direction direction;

    public Orientation(Character character) {
        this.direction = validateDirection(character,"character must not be null","unknown direction");
    }

    public static Direction validateDirection(Character character, String messageNullObject, String messageIllegalValue) {
        if (character == null)
            throw new NullPointerException(messageNullObject);
        if (!Direction.BY_CHARACTER.containsKey(character))
            throw new IllegalArgumentException(messageIllegalValue);
        return Direction.getDirection(character);
    }

    public Direction direction(){
        return direction;
    }

    public void turnLeft() {
        Integer result = direction.value - 1;
        this.direction = (result) < Direction.N.value ? MAX_DIRECTION : Direction.getDirection(result);
    }

    public void turnRight() {
        Integer result = direction.value + 1;
        this.direction = (result) > Direction.W.value ? MIN_DIRECTION : Direction.getDirection(result);
    }

    public String toString(){
        return direction.name();
    }
}
