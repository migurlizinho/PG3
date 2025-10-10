package trabs.trab1.grupo3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
/**
 * Created by msousa on 3/12/2020.
 */
public class TestsVar  {

    @Test
    public void testConstruct( ) {
        Var v = new Var("A", 10);
        assertEquals(10, v.value);
        assertEquals(0, v.getPriority());
    }


    @Test
    public void testToString() {
        Var v = new Var("A", 10);
        assertEquals("A", v.toString());
    }

    @Test
    public void testEvaluate() {
            Var v = new Var("A", 10);
            assertEquals(10, v.evaluate());
    }


    @Test
    public void testSetValue() {
        Var v = new Var("A", 10);
        assertEquals(10, v.evaluate());
        int old = v.setValue( 15 );
        assertEquals(10, old);
        assertEquals(15, v.evaluate());
    }
}
