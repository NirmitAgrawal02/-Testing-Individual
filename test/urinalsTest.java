import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class urinalsTest {

    @Test
    void getstring() {
        urinals test = new urinals();
        assertEquals("Given String is a good string",test.getstring("11100"), "====== NIRMIT AGRAWAL == TEST ONE EXECUTED =======");
    }

    @Test
    void openFile() {
    }

    @Test
    void count() {
    }
}