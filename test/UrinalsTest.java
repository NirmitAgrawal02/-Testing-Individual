import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UrinalsTest {

    @Test
    void getstring() {
        urinals test = new urinals();
        assertEquals("Length of the given string exceeds the constraints",test.getstring("000001111110000000001"), "NIRMIT AGRAWAL,TEST TWO EXECUTED");
        assertEquals("Given String does not contain any urinals",test.getstring(""), "NIRMIT AGRAWAL,TEST TWO EXECUTED");
        assertEquals("Given String is not a good string",test.getstring("421145"), "NIRMIT AGRAWAL,TEST TWO EXECUTED");
        assertEquals("Input is not in a formatted way - 1",test.getstring("11000"), "NIRMIT AGRAWAL,TEST ONE EXECUTED");
        assertEquals("Given String is a good string",test.getstring("00000"), "NIRMIT AGRAWAL,TEST ONE EXECUTED");
    }

    @Test
    void openFile() {
    }

    @Test
    void count() {
    }
}