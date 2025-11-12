package trabs.trab1.grupo4;

public class Shortcut extends AbstractFile{
    public final File fileOf;

    public Shortcut(String name, File fileOf) {
        super(name);
        this.fileOf = fileOf;
    }

    @Override
    public int getLength() {
        return fileOf.getLength();
    }

    @Override
    public String getDescription(String prefix) {
        return super.getDescription(prefix) + " [shortcut of " + fileOf.getAbsolutePath() + "]";
    }
}