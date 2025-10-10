package trabs.trab1.grupo2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestAverage {
   @Test
   public void testConstruct( ) throws Exception {
      Grade c1 = new SG(10, "1º teste", 8);
      Grade c2 = new SG(12, "2º teste", 8);
      Grade c3 = new SG(14, "3º teste", 8);
      Grade g= new AverageGrade(new Proof("Testes", 10), c1, c2, c3 );
      assertEquals((10+12+14)/3, g.getGrade());
      assertTrue(g.isApproved());
      assertEquals("Testes", g.getName());
      assertEquals("Testes - 12", g.toString());
   }
}