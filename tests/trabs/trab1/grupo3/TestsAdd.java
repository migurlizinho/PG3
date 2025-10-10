package trabs.trab1.grupo3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Created by msousa on 3/12/2020.
 */
public class TestsAdd  {

    @Test
    public void testConstruct( ) {
        Add add = new Add( new Const(3), new Var("A", 6));
        assertEquals('+', add.operator);
        assertEquals(6, add.getPriority());
    }


    @Test
    public void testToString() {
        Add add1 = new Add( new Const(3), new Var("A", 6));
        assertEquals("3+A", add1.toString());
        Add add2 = new Add( new Var("B", 6), add1);
        assertEquals("B+(3+A)", add2.toString());
        Add add3 = new Add( add1, add2);
        assertEquals("(3+A)+(B+(3+A))", add3.toString());
    }

    @Test
    public void testEvaluate()  {
        try {
            Add add1 = new Add( new Const(3), new Var("A", 6));
            assertEquals(9, add1.evaluate());
            Add add2 = new Add( new Var("B", 6), add1);
            assertEquals(15, add2.evaluate());
            Add add3 = new Add( add1, add2);
            assertEquals(24, add3.evaluate());
        } catch (Exception e) {
            fail("Exception not expected");
        }
    }
}
