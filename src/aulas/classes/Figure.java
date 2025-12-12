package aulas.classes;

public abstract class Figure {
    private int offset;
    public Figure(){ offset = 0;}
    public Figure(int offset){ this.offset = offset;}

    public int getOffset() {
        return offset;
    }
    public void setOffset(int offset) {
        this.offset = offset;
    }

    public void spaces(int number){
        for(int count = 0; count < number ; count++){
            System.out.print(' ');
        }
    }

    public abstract void drawHere();

    public void drawAt(int lineNumber){
        for(int count = 0; count < lineNumber ; count++){
            System.out.println();
        }
        drawHere();
    }
}
