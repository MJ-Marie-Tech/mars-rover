public class Position {
    private static final Integer MIN_XY = 0;
    private static Integer MAX_XY = Integer.MAX_VALUE;
    private Integer x;
    private Integer y;

    public Position(Integer x, Integer y) {
        this.x = validateCoordinate(x, "x must not be null", "x is out of bounds");
        this.y = validateCoordinate(y, "y must not be null", "y is out of bounds");
    }

    public static Integer validateCoordinate(Integer obj, String messageNullObject, String messageIllegalValue) {
        if (obj == null)
            throw new NullPointerException(messageNullObject);
        if (obj < MIN_XY || obj > MAX_XY)
            throw new IllegalArgumentException(messageIllegalValue);
        return obj;
    }

    public static void setMaxXy(Integer maxXy) {
        MAX_XY = maxXy;
    }

    public Integer x() {
        return x;
    }

    public Integer y() {
        return y;
    }

    public void moveNorth() {
        Integer result = y + 1;
        if (result <= MAX_XY)
            this.y = result;
    }

    public void moveSouth() {
        Integer result = y - 1;
        if (result >= MIN_XY)
            this.y = result;
    }

    public void moveWest() {
        Integer result = x - 1;
        if (result >= MIN_XY)
            this.x = result;
    }

    public void moveEast() {
        Integer result = x + 1;
        if (result <= MAX_XY)
            this.x = result;
    }

    @Override
    public String toString() {
        return x + " " + y;
    }
}
