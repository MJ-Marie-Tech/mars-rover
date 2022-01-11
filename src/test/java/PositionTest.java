import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PositionTest {

    @BeforeEach
    void setUp() {
        Position.setMaxXy(5);
    }

    @Test
    void should_return_position_nominal() {
        Position position = new Position(1, 2);
        assertThat(position.x()).isEqualTo(1);
        assertThat(position.y()).isEqualTo(2);
        assertThat(position.toString().contains("1 2")).isTrue();
    }

    @Test
    void should_return_position_with_zero_x_coordinate() {
        Position position = new Position(0, 2);
        assertThat(position.x()).isEqualTo(0);
        assertThat(position.y()).isEqualTo(2);
    }

    @Test
    void should_return_position_with_zero_x_and_y_coordinates() {
        Position position = new Position(0, 0);
        assertThat(position.x()).isEqualTo(0);
        assertThat(position.y()).isEqualTo(0);
    }

    @Test
    void should_throws_nullPointerException_when_x_is_null() {
        Exception exception = assertThrows(NullPointerException.class, () ->
                new Position(null, 2));
        assertThat(exception.getMessage()).isEqualTo("x must not be null");
    }

    @Test
    void should_throws_nullPointerException_when_y_is_null() {
        Exception exception = assertThrows(NullPointerException.class, () ->
                new Position(1, null));
        assertThat(exception.getMessage()).isEqualTo("y must not be null");
    }

    @Test
    void should_throws_illegalArgumentException_when_x_is_negative() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Position(-1, 3));
        assertThat(exception.getMessage()).isEqualTo("x is out of bounds");
    }

    @Test
    void should_throws_illegalArgumentException_when_x_is_over_max_x() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Position(6, 3));
        assertThat(exception.getMessage()).isEqualTo("x is out of bounds");
    }

    @Test
    void should_throws_illegalArgumentException_when_y_is_negative() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Position(1, -3));
        assertThat(exception.getMessage()).isEqualTo("y is out of bounds");
    }

    @Test
    void should_throws_illegalArgumentException_when_y_is_over_max_y() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Position(1, 6));
        assertThat(exception.getMessage()).isEqualTo("y is out of bounds");
    }

    @Test
    void should_return_x_one_y_two_when_x_is_one_and_y_one_and_move_to_north() {
        Position position = new Position(1, 1);
        position.moveNorth();
        assertThat(position.x()).isEqualTo(1);
        assertThat(position.y()).isEqualTo(2);
    }

    @Test
    void should_return_x_one_y_five_when_x_is_one_and_y_five_and_move_to_north() {
        Position position = new Position(1, 5);
        position.moveNorth();
        assertThat(position.x()).isEqualTo(1);
        assertThat(position.y()).isEqualTo(5);
    }

    @Test
    void should_return_x_zero_y_zero_when_x_is_zero_and_y_is_zero_and_move_to_south() {
        Position position = new Position(0, 0);
        position.moveSouth();
        assertThat(position.x()).isEqualTo(0);
        assertThat(position.y()).isEqualTo(0);
    }

    @Test
    void should_return_x_zero_y_zero_when_x_is_zero_and_y_is_one_and_move_to_south() {
        Position position = new Position(0, 1);
        position.moveSouth();
        assertThat(position.x()).isEqualTo(0);
        assertThat(position.y()).isEqualTo(0);
    }

    @Test
    void should_return_x_five_y_five_when_x_is_five_and_y_is_five_and_move_to_east() {
        Position position = new Position(5, 5);
        position.moveEast();
        assertThat(position.x()).isEqualTo(5);
        assertThat(position.y()).isEqualTo(5);
    }

    @Test
    void should_return_x_three_y_four_when_x_is_two_and_y_is_four_and_move_to_east() {
        Position position = new Position(2, 4);
        position.moveEast();
        assertThat(position.x()).isEqualTo(3);
        assertThat(position.y()).isEqualTo(4);
    }

    @Test
    void should_return_x_zero_y_zero_when_x_is_zero_and_y_is_zero_and_move_to_west() {
        Position position = new Position(0, 0);
        position.moveWest();
        assertThat(position.x()).isEqualTo(0);
        assertThat(position.y()).isEqualTo(0);
    }

    @Test
    void should_return_x_zero_y_three_when_x_is_one_and_y_is_three_and_move_to_west() {
        Position position = new Position(1, 3);
        position.moveWest();
        assertThat(position.x()).isEqualTo(0);
        assertThat(position.y()).isEqualTo(3);
    }

}