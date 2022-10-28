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
        assertEquals("File not Exist -1",test.openFile("hello.dat"),"NIRMIT AGRAWAL,TEST SEVEN EXECUTED");
        assertEquals("File is Empty -1",test.openFile("Empty.dat"),"NIRMIT AGRAWAL,TEST EIGHT EXECUTED");
    }

    @Test
    void count() {
        urinals test = new urinals();
        assertEquals("3",test.counter(1,"00000"), "NIRMIT AGRAWAL,TEST NINE EXECUTED");
        assertEquals("0",test.counter(1,"10101"), "NIRMIT AGRAWAL,TEST TEN EXECUTED");
        assertEquals("0",test.counter(1,"100101"), "NIRMIT AGRAWAL,TEST ELEVEN EXECUTED");
        assertEquals("Input is not in a formatted way - 1",test.counter(1,"101101"), "NIRMIT AGRAWAL,TEST TWELVE EXECUTED");
        assertEquals("1",test.counter(1,"10001001"), "NIRMIT AGRAWAL,TEST THIRTHEEN EXECUTED");
        assertEquals("File Created and updated",test.counter(2,"urinal.dat"), "NIRMIT AGRAWAL,FOURTEEN SIX EXECUTED");
        assertEquals("File not Exist -1",test.counter(2,"hello.dat"), "NIRMIT AGRAWAL,FIFTEEN SIX EXECUTED");
        assertEquals("File is Empty -1",test.counter(2,"Empty.dat"), "NIRMIT AGRAWAL,SIXTEEN SIX EXECUTED");
        assertEquals("File Created and updated",test.counter(2,"urinal.dat"), "NIRMIT AGRAWAL,SEVENTEEN SIX EXECUTED");
        assertEquals("File Created and updated",test.counter(2,"urinal.dat"), "NIRMIT AGRAWAL,EIGHTEEN SIX EXECUTED");
    }
}