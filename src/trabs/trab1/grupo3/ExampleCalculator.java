package trabs.trab1.grupo3;

public class ExampleCalculator {
    public static void main(String[] args) {
        try {
            Var v = new Var("A", 5); System.out.println( v+"->"+v.evaluate() );
            Const c = new Const(2); System.out.println( c+"->"+c.evaluate() );
            Exp e1 = new Mult(c, v); System.out.println( e1+"->"+e1.evaluate() );
            Exp e2 = new Add(v, c); System.out.println( e2+"->"+e2.evaluate() );
            Exp e3 = new Div(e1, e2); System.out.println( e3+"->"+e3.evaluate() );
            v.setValue( -2 );
            int r = e3.evaluate();
        } catch ( InvalidExpException ex ) {
            System.out.println(ex.getMessage());}
    }
}
