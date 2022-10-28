import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class urinalsTest {

    @Test
    void getstring() {
        urinals test = new urinals();
        assertEquals("Given String is a good string",test.getstring("00000"), "NIRMIT AGRAWAL,TEST ONE EXECUTED");
        assertEquals("Length of the given string exceeds the constraints",test.getstring("000001111110000000001"), "NIRMIT AGRAWAL,TEST TWO EXECUTED");
        assertEquals("Given String does not contain any urinals",test.getstring(""), "NIRMIT AGRAWAL,TEST TWO EXECUTED");

    }

    @Test
    void openFile() {
    }

    @Test
    void count() {
    }
}