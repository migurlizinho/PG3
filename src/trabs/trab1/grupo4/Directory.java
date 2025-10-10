package trabs.trab1.grupo4;

import java.util.Iterator;
import java.util.function.Predicate;

public class Directory extends AbstractFile implements Dir{
    public Directory(String name) {
        super(name);
    }

    @Override
    public Dir append(File file) {
        return null;
    }

    @Override
    public Dir append(String name, int lenght) {
        return null;
    }

    @Override
    public File get(Predicate<File> filePredicate) {
        return null;
    }

    @Override
    public Iterator<File> iterator() {
        return null;
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