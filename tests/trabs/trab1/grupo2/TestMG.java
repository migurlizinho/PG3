package trabs.trab1.grupo2;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestMG {
   Proof p= new Proof("1º teste", 8);

   @Test
    public void testGreater( ) {
       Grade c1 = new SG(10, "1º teste", 8);
       Grade c2 = new SG(12, "1º teste", 8);
       Grade c3 = new SG(15, "1º teste", 8);
       assertEquals(c1, MG.greater(c1));
       assertEquals(c3, MG.greater(c1, c2,c3));
       assertEquals(c3, MG.greater(c3, c2,c1));
       assertEquals(c3, MG.greater(c1, c3,c2));
    }

    @Test
    public void testSum( ) {
        Grade c1 = new SG(10, "1º teste", 8);
        Grade c2 = new SG(12, "1º teste", 8);
        Grade c3 = new SG(15, "1º teste", 8);
        assertEquals(10, MG.sum(c1));
        assertEquals(10+12, MG.sum(c1, c2));
        assertEquals(10+12+15, MG.sum(c1, c2, c3));
   }
}
