package trabs.trab1.grupo4;

public class DataFile extends AbstractFile{
    private final int length;
    public DataFile(String name, int length) throws FileException{
        super(name);
        if(length < 0)
            throw new FileException("Not create DataFile - Invalid length");
        this.length = length;
    }

    @Override
    public int getLength() {
        return length;
    }
}