package trabs.trab1.grupo4;

public class AbstractFile implements File{
    private final String name;
    protected File currentDir;

    public AbstractFile(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public String getAbsolutePath() {
        return "";
    }

    @Override
    public int getLenght() {
        return 0;
    }

    @Override
    public void setCurrentDir(Dir dir) {

    }

    @Override
    public String getDescription(String prefix) {
        return "";
    }
}
