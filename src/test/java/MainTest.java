import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.*;
@Disabled
class MainTest {

    @Test
    @Timeout(22)
    void main() throws Exception {
        String[] args = null;
        Main.main(args);
    }
}