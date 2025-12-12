package aulas.classes;

public class Box extends Figure {
    private int width;
    private int height;
    public Box(){
        width = 0;
        height = 0;
    }
    public Box(int width, int height){
        this.width = width;
        this.height = height;
    }
    public Box(int width,int height, int offset){
        super(offset);
        this.width = width;
        this.height = height;
    }

    @Override
    public void drawHere() {
        for (int row = 0; row < height; row++) {
            spaces(getOffset());
            for (int col = 0; col < width; col++) {
                if(row == 0 || row == height - 1){
                    System.out.print('-');
                }
                else if(col == 0 || col == width - 1) {
                    System.out.print('|');
                }else{
                    System.out.print(' ');
                }
            }
            System.out.println();
        }
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getSize() {
        return height;
    }

    public void setSize(int size) {
        this.height = size;
    }
}
