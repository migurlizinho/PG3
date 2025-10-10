package trabs.trab1.grupo3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by msousa on 3/12/2020.
 */
public class TestsConst  {
    @Test
    public void testConstruct( ) {
        Const c = new Const(5);
        assertEquals(5, c.value);
        assertEquals(0, c.getPriority());
    }


    @Test
    public void testToString() {
        Const c = new Const(5);
        assertEquals("5", c.toString());
    }

    @Test
    public void testEvaluate() {
        Const c = new Const(5);
        assertEquals(5, c.evaluate());
    }

}
