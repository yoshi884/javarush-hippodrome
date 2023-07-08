import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HippodromeTest {
    @Test
    void emptyListTest() {
        Throwable emptyList = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    Hippodrome hippodrome = new Hippodrome(new ArrayList<Horse>());
                }
        );
        assertEquals("Horses cannot be empty.", emptyList.getMessage());
    }

    @Test
    void nullListTest(){
        Throwable nullList = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    Hippodrome hippodrome = new Hippodrome(null);
                }
        );
        assertEquals("Horses cannot be null.", nullList.getMessage());
    }

    @Test
    void getHorsesTest() {
        ArrayList horses = new ArrayList(30);
        for (int i = 0; i < 30; i++) {
            horses.add(new Horse("Horse", 1, 1));
        }
        Hippodrome hippodrome = new Hippodrome(horses);

        assertEquals(horses, hippodrome.getHorses());

    }

    @Test
    void moveTest(){
        List<Horse> horses = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            horses.add(Mockito.mock(Horse.class));
        }

        Hippodrome hippodrome = Mockito.spy(new Hippodrome(horses));
        hippodrome.move();

        for (Horse currentHorse : horses){
            Mockito.verify(currentHorse).move();
        }
    }

    @Test
    void getWinnerTest(){
        Horse fasterHorse = new Horse("Monika" , 1 , 10);
        Horse slowerHorse = new Horse("Monika" , 1 , 1);
        List<Horse> horses = new ArrayList<>();

        horses.add(fasterHorse);
        horses.add(slowerHorse);

        Hippodrome hippodrome = new Hippodrome(horses);

        assertEquals(fasterHorse , hippodrome.getWinner());
    }
}
