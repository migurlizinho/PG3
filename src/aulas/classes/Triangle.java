package aulas.classes;

public class Triangle extends Figure {
    private int base;
    public Triangle(int base) {
        this.base = base;
    }
    public Triangle(int base, int offset){
        super(offset);
        this.base = base;
    }

    @Override
    public void drawHere() {
        //Sides
        int startOfLine = getOffset() + base/2;
        spaces(startOfLine);
        System.out.println('*');
        int insideWidth = 1;
        for(int count = 0; count < (base/2) - 1; count++){
            startOfLine--;
            spaces(startOfLine);System.out.print('*');
            spaces(insideWidth);System.out.println('*');
            insideWidth += 2;
        }
        //Base
        spaces(getOffset());
        for(int i = 0; i < base; i++){
            System.out.print('*');
        }
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }
}