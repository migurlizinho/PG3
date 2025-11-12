package trabs.trab2.grupo1;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class TestCipherUtils {
    @Test
    public void testEncode(){
        CipherUtils c = new CipherUtils();
        assertEquals('D', c.encode('A', 3));
        assertEquals('E', c.encode('B', 3));
        assertEquals('C', c.encode('Z', 3));

        assertEquals('d', c.encode('a', 3));
        assertEquals('e', c.encode('b', 3));
        assertEquals('c', c.encode('z', 3));

        assertEquals('K', c.encode('A', 10));
        assertEquals('L', c.encode('B', 10));
        assertEquals('B', c.encode('R', 10));
        assertEquals('k', c.encode('a', 10));
        assertEquals('l', c.encode('b', 10));
        assertEquals('b', c.encode('r', 10));


        assertEquals('Z', c.encode('A', -1));
        assertEquals('z', c.encode('a', -1));
    }

    @Test
    public void testProcessText() throws IOException {
        CipherUtils c = new CipherUtils();
        assertEquals("dec", c.processText("abz", 3, true));
        assertEquals("abz", c.processText("dec", 3, false));

        assertEquals("wyvnyhthjhv l mpel", c.processText("programacao e fixe", 7, true));
        assertEquals("programacao e fixe", c.processText("wyvnyhthjhv l mpel", 7, false));
        String normal = "If he had anything confidential to say, he wrote it in cipher, that is, by so changing the order of the letters of the alphabet, that not a word could be made out.";
        String encrypted = "Sp ro rkn kxidrsxq myxpsnoxdskv dy cki, ro gbydo sd sx mszrob, drkd sc, li cy mrkxqsxq dro ybnob yp dro voddobc yp dro kvzrklod, drkd xyd k gybn myevn lo wkno yed.";
        assertEquals(encrypted, c.processText(normal, 10, true));
        assertEquals(normal, c.processText(encrypted, 10, false));
    }
}
