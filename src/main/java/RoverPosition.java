public class RoverPosition {

    private static final String SEPARATE=" ";
    private Position position;
    private Orientation direction;

    public RoverPosition( String positionRover) {
        String [] pos=positionRover.split(SEPARATE);
        this.position = new Position(Integer.valueOf(pos[0]),Integer.valueOf(pos[1]));
        this.direction = new Orientation(pos[2].charAt(0));
    }

    public void move() {
        direction.direction().run.accept(position);
    }

    public void turnRight() {
        direction.turnRight();
    }

    public void turnLeft() {
        direction.turnLeft();
    }

    public String toString(){
       return position + " " + direction;
    }
}
