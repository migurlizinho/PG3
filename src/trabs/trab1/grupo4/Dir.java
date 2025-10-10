package trabs.trab1.grupo4;

import java.util.function.Predicate;

public interface Dir extends File, Iterable<File> {
    Dir append(File file);
    Dir append(String name, int lenght);
    File get(Predicate<File> filePredicate);
}