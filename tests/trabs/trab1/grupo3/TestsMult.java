package trabs.trab1.grupo3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Created by msousa on 3/12/2020.
 */
public class TestsMult  {
    @Test
    public void testConstruct( ) {
        Mult mult = new Mult( new Const(3), new Var("A", 6 ));
        assertEquals('*', mult.operator );
        assertEquals(5, mult.getPriority() );
    }

    @Test
    public void testToString() {
        Mult mult1 = new Mult( new Const(3), new Var("A", 6));
        assertEquals("3*A", mult1.toString());
        Mult mult2 = new Mult( new Const(7), mult1);
        assertEquals("7*(3*A)", mult2.toString());
        Mult mult3 = new Mult(mult2, new Mult(new Var("B", 5), new Const(2)));
        assertEquals("(7*(3*A))*(B*2)", mult3.toString());
    }

    @Test
    public void testEvaluate()  {
        try {
            Mult mult1 = new Mult( new Const(3), new Var("A", 6));
            assertEquals(18, mult1.evaluate());
            Mult mult2 = new Mult( new Const(3), mult1);
            assertEquals(54, mult2.evaluate());
            Mult mult3 = new Mult(mult2, new Mult(new Var("A", 5), new Const(2)));
            assertEquals(540, mult3.evaluate());
        } catch (Exception e) {
            fail("Exception not expected");
        }
    }
}
