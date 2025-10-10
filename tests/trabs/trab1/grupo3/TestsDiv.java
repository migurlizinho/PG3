package trabs.trab1.grupo3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by msousa on 3/12/2020.
 */
public class TestsDiv  {
    @Test
    public void testConstruct( ) {
        Div div = new Div( new Var("A", 6), new Const(3));
        assertEquals('/', div.operator );
        assertEquals(5, div.getPriority() );
    }


    @Test
    public void testToString() {
        Div div1 = new Div( new Var("A", 6), new Const(3));
        assertEquals("A/3", div1.toString());
        Div div2 = new Div( div1, new Const(2));
        assertEquals("(A/3)/2", div2.toString());
        Div div3 = new Div(new Div(new Var("B", 15), new Const(5)), div2);
        assertEquals("(B/5)/((A/3)/2)", div3.toString());
    }

    @Test
    public void testEvaluate()  {
        try {
            Div div1 = new Div( new Var("A", 6), new Const(3));
            assertEquals(2, div1.evaluate());
            Div div2 = new Div( div1, new Const(2));
            assertEquals(1, div2.evaluate());
            Div div3 = new Div(new Div(new Var("B", 15), new Const(5)), div2);
            assertEquals(3, div3.evaluate());

        } catch (Exception e) {
            fail("Exception not expected");
        }
    }

    @Test
    public void testExceptions() {
        InvalidExpException expExceptionByZero = assertThrowsExactly( InvalidExpException.class,
                () -> { new Div( new Var("D", 5), new Const(0) ).evaluate(); } );
        assertEquals( "Divide by zero -> D/0", expExceptionByZero.getMessage() );
        InvalidExpException expExceptionIndeterminate = assertThrowsExactly( InvalidExpException.class,
                () -> { new Div( new Const(0), new Const(0) ).evaluate(); } );
        assertEquals( "Indeterminate -> 0/0", expExceptionIndeterminate.getMessage() );
    }

}
