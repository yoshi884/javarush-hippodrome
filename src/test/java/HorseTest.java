import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mockStatic;

@ExtendWith(MockitoExtension.class)
class HorseTest {

    @Test
    void nullNameTest() {
        Throwable nullName = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    Horse horse = new Horse(null, 1, 1);
                }
        );
        assertEquals("Name cannot be null.", nullName.getMessage());

    }

    @Test
    void negativeDistanceTest(){
        Throwable distanceContainsNegativeNumber = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    Horse horse = new Horse("Jorik", 500, -1);
                }
        );
        assertEquals("Distance cannot be negative.", distanceContainsNegativeNumber.getMessage());
    }

    @Test
    void negativeSpeedTest(){
        Throwable speedContainsNegativeNumber = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    Horse horse = new Horse("Jorik", -1, 1);
                }
        );
        assertEquals("Speed cannot be negative.", speedContainsNegativeNumber.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  " , "\t" , "\r" , "\n" , "\f" , "  "})
    void  blankNameTest(String input){
        Throwable emptyName = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    Horse horse = new Horse(input, 1, 1);
                }
        );
        assertEquals("Name cannot be blank.", emptyName.getMessage());
    }


    @ParameterizedTest
    @ValueSource(strings = {"Jesika", "H" , "oooooops" , "James Statham"})
    void getNameTest(String args) {
        Horse horse = Mockito.spy(new Horse(args, 1, 1));
        assertEquals(args, horse.getName());
    }

    @Test
    void getSpeedTest() {
        Horse horse = Mockito.spy(new Horse("Jesika", 1, 1));
        assertEquals(1, horse.getSpeed());
    }

    @Test
    void getDistanceTest() {
        Horse horse = Mockito.spy(new Horse("Jesika", 1, 2));
        assertEquals(2, horse.getDistance());

        Horse horseNoDistance = Mockito.spy(new Horse("Jesika", 1));
        assertEquals(0, horseNoDistance.getDistance());
    }

    @Test
    void moveTest() {
        try(MockedStatic<Horse> mockedHorse = mockStatic(Horse.class)) {
            Horse horse = new Horse("Kirim" , 1 ,2);
            horse.move();

            mockedHorse.verify(() ->Horse.getRandomDouble(0.2,0.9));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
