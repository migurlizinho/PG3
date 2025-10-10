package trabs.trab1.grupo2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TestGreater {
    @Test
    public void testConstruct( ) throws Exception {
        Grade c1 = new SG(10, "1º teste", 8);
        Grade c2 = new SG(12, "2º teste", 8);
        Grade c3 = new SG(14, "3º teste", 8);
        Grade g = new GreaterGrade(new Proof("Testes", 10), c1, c2, c3 );
        assertEquals(14, g.getGrade());
        assertEquals("Testes", g.getName());
        assertEquals("Testes - 14", g.toString());
        assertTrue(g.isApproved());
        g = new GreaterGrade(new Proof("Testes", 15), c3, c1, c2 );
        assertFalse(g.isApproved());
    }
}
