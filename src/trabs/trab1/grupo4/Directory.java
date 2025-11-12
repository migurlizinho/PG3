package trabs.trab1.grupo4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class Directory extends AbstractFile implements Dir{
    protected ArrayList<File> files;

    public Directory(String name) {
        super(name);
        files = new ArrayList<>();
    }

    @Override
    public Dir append(File file) {
        files.add(file);
        file.setCurrentDir(this);
        return this;
    }

    @Override
    public Dir append(String name, int length) throws FileException{
        return append(new DataFile(name, length));
    }

    @Override
    public File get(Predicate<File> filePredicate) {
        for (File file : files) {
            if(filePredicate.test(file))
                return file;

            if(file instanceof Dir){
                File r = ((Dir)file).get(filePredicate);
                if(r != null)
                    return r;
            }
        }
        return null;
    }

    @Override
    public File getFileWithName(String name) {
        return get(file -> file.getName().equals(name));
    }

    @Override
    public List<File> getAll(Predicate<File> filePredicate) {
        ArrayList<File> list = new ArrayList<>();
        for (File file : files) {
            if(filePredicate.test(file))
                list.add(file);
            if(file instanceof Dir)
                list.addAll(((Dir)file).getAll(filePredicate));
        }
        list.sort((file1, file2) -> file1.getLength() - file2.getLength());
        return list;
    }

    @Override
    public Iterator<File> iterator() {
        return files.iterator();
    }

    @Override
    public int getLength() {
        int sum = 0;
        for (File file : files) {
            sum += file.getLength();
        }
        return sum;
    }

    @Override
    public void setCurrentDir(Dir dir) {
        super.setCurrentDir(dir);
    }

    @Override
    public String getDescription(String prefix) {
        StringBuilder finalString = new StringBuilder(prefix + this.getName());
        for (File file : files) {
            finalString.append("\n").append(prefix).append(file.getDescription(" "));
        }
        return finalString.toString();
    }
}