import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OrientationTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void should_return_orientation_nominal() {
        Orientation orientation = new Orientation('N');
        assertThat(orientation.direction().value).isEqualTo(1);
        assertThat(orientation.direction().character).isEqualTo('N');
        assertThat(orientation.direction().run).isNotNull();
        assertThat(orientation.toString().contains("N")).isTrue();
    }

    @Test
    void should_throws_nullPointerException_when_character_is_null() {
        Exception exception = assertThrows(NullPointerException.class, () ->
                new Orientation(null));
        assertThat(exception.getMessage()).isEqualTo("character must not be null");
    }

    @Test
    void should_throws_IllegalArgumentException_when_character_is_A() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Orientation('A'));
        assertThat(exception.getMessage()).isEqualTo("unknown direction");
    }

    @Test
    void should_throws_IllegalArgumentException_when_character_is_5() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Orientation('5'));
        assertThat(exception.getMessage()).isEqualTo("unknown direction");
    }

    @Test
    void should_return_east_when_direction_is_north_and_turnRight() {
        Orientation orientation = new Orientation('N');
        orientation.turnRight();
        assertThat(orientation.direction().value).isEqualTo(2);
        assertThat(orientation.direction().character).isEqualTo('E');
    }

    @Test
    void should_returnA_south_when_direction_is_east_and_turnRight() {
        Orientation orientation = new Orientation('E');
        orientation.turnRight();
        assertThat(orientation.direction().value).isEqualTo(3);
        assertThat(orientation.direction().character).isEqualTo('S');
    }

    @Test
    void should_returnV_south_when_direction_is_east_and_turnRight() {
        Orientation orientation = new Orientation('S');
        orientation.turnRight();
        assertThat(orientation.direction().value).isEqualTo(3);
        assertThat(orientation.direction().character).isEqualTo('W');
    }

    @Test
    void should_return_west_when_direction_is_North_and_turnLeft() {
        Orientation orientation = new Orientation('N');
        orientation.turnLeft();
        assertThat(orientation.direction().value).isEqualTo(4);
        assertThat(orientation.direction().character).isEqualTo('W');
    }


}