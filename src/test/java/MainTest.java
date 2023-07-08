import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class MainTest {
    @Disabled
    @Test
    @Timeout(22)
    void mainTest(){
        try {
            String[] args = null;
            Main.main(args);
        }catch (Exception e ){
            System.err.println("An error occurred in mainTest");
            e.printStackTrace();
        }

    }
}