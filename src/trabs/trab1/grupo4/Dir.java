package trabs.trab1.grupo4;

import java.util.List;
import java.util.function.Predicate;

public interface Dir extends File, Iterable<File> {
    Dir append(File file);
    Dir append(String name, int length) throws FileException;
    File get(Predicate<File> filePredicate);
    File getFileWithName(String name);
    List<File> getAll(Predicate<File> filePredicate);
}