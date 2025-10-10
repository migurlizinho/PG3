package trabs.trab1.grupo2;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestSG {
   Proof p= new Proof("1º teste", 8);
   @Test
    public void testConstructsThreeArg( ) {
        Grade c = new SG(10, "1º teste", 8);
        assertEquals(10, c.getGrade());
        assertEquals("1º teste", c.getName());
    }

    @Test
    public void testConstructsTwoArg( ) {
        Grade c = new SG(10, p );
        assertEquals(10, c.getGrade());
        assertEquals("1º teste", c.getName());
    }

    @Test
    public void testIsApproved() {
       assertTrue( new SG(12, "Teste", 9).isApproved() );       // Above minimum
       assertTrue( new SG(9, "Teste", 9).isApproved() );        // Test minimum
       assertFalse( new SG(8, "Teste", 9).isApproved() );       // Below minimum
    }

    @Test
    public void testEquals( ) {
        Grade c = new SG(9, "Exame", 10 );
        assertTrue(c.equals(c));
        assertTrue(c.equals(new SG(9, new String("Exame"), 10)));
        assertFalse(c.equals(new SG(9, "Teste", 10)));
        assertFalse(c.equals(new SG(10,  "Exame", 10)));
    }

    @Test
    public void testCompareTo( ) {
        Grade c1 = new SG(12, "Teste1", 10 );
        Grade c2 = new SG(11, "Teste2", 10 );
        assertTrue(c1.compareTo( c2)> 0);
        assertTrue(c2.compareTo( c1)< 0);
        assertEquals(0, c1.compareTo(c1));
   }

    @Test
    public void testToString(){
        assertEquals("1º teste - 8", new SG(8, p ).toString());
    }
}
