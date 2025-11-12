package trabs.trab1.grupo4;

public abstract class AbstractFile implements File{
    private final String name;
    protected File currentDir;

    public AbstractFile(String name) {
        this.name = name;
    }

    @Override
    public final String getName() {
        return name;
    }

    @Override
    public String getAbsolutePath() {
        if(currentDir == null)
            return name;
        return currentDir.getAbsolutePath() + "/" + name;
    }

    @Override
    public void setCurrentDir(Dir dir) {
        currentDir = dir;
    }

    public String getDescription( String prefix ) {
        return prefix + this;
    }

    public final String toString() {
        return name +" – " + getLength()+ "KB";
    }
}