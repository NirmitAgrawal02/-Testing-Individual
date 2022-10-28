import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UrinalsTest {

    @Test
    void getstring() {
        urinals test = new urinals();
        assertEquals("Length of the given string exceeds the constraints",test.getstring("000001111110000000001"), "NIRMIT AGRAWAL,TEST ONE EXECUTED");
        assertEquals("Given String does not contain any urinals",test.getstring(""), "NIRMIT AGRAWAL,TEST TWO EXECUTED");
        assertEquals("Given String is not a good string",test.getstring("421145"), "NIRMIT AGRAWAL,TEST THREE EXECUTED");
        assertEquals("Input is not in a formatted way - 1",test.getstring("11000"), "NIRMIT AGRAWAL,TEST FOUR EXECUTED");
        assertEquals("Given String is a good string",test.getstring("00000"), "NIRMIT AGRAWAL,TEST FIVE EXECUTED");
    }

    @Test
    void openFile() {
        urinals test = new urinals();

        assertEquals("File Exists",test.openFile("urinal.dat"), "NIRMIT AGRAWAL,TEST SIX EXECUTED");
    }

    @Test
    void count() {
//        urinals test = new urinals();
//        assertEquals("3",test.count(1,"00000"), "NIRMIT AGRAWAL,TEST SIX EXECUTED");
//        assertEquals("0",test.count(1,"10101"), "NIRMIT AGRAWAL,TEST SEVEN EXECUTED");
//        assertEquals("0",test.count(1,"100101"), "NIRMIT AGRAWAL,TEST EIGHT EXECUTED");
//        assertEquals("-1",test.count(1,"101101"), "NIRMIT AGRAWAL,TEST NINE EXECUTED");
//        assertEquals("1",test.count(1,"10001001"), "NIRMIT AGRAWAL,TEST TEN EXECUTED");
    }
}