import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class HorseTest {

    @Test
    void constructorTest() {
        Throwable nullName = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    Horse horse = new Horse(null, 1, 1);
                }
        );
        assertEquals("Name cannot be null.", nullName.getMessage());

        Throwable emptyName = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    Horse horse = new Horse(" ", 1, 1);
                }
        );
        assertEquals("Name cannot be blank.", emptyName.getMessage());

        Throwable speedContainsNegativeNumber = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    Horse horse = new Horse("Jorik", -1, 1);
                }
        );
        assertEquals("Speed cannot be negative.", speedContainsNegativeNumber.getMessage());

        Throwable distanceContainsNegativeNumber = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    Horse horse = new Horse("Jorik", 500, -1);
                }
        );
        assertEquals("Distance cannot be negative.", distanceContainsNegativeNumber.getMessage());

    }


    @Test
    void getName() {
        Horse horse = Mockito.spy(new Horse("Jesika", 1, 1));
        assertEquals("Jesika", horse.getName());

    }

    @Test
    void getSpeed() {
        Horse horse = Mockito.spy(new Horse("Jesika", 1, 1));
        assertEquals(1, horse.getSpeed());
    }

    @Test
    void getDistance() {
        Horse horse = Mockito.spy(new Horse("Jesika", 1, 2));
        assertEquals(2, horse.getDistance());

        Horse horseNoDistance = Mockito.spy(new Horse("Jesika", 1));
        assertEquals(0, horseNoDistance.getDistance());
    }

    @Test
    void move() {
        try(MockedStatic<Horse> mockedHorse = mockStatic(Horse.class)) {
            Horse horse = new Horse("Kirim" , 1 ,2);
            horse.move();

            mockedHorse.verify(() ->Horse.getRandomDouble(0.2,0.9));


        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
