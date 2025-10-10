package trabs.trab1.grupo4;

public interface File {
    String getName();
    String getAbsolutePath();
    int getLenght();
    void setCurrentDir(Dir dir);
    String getDescription(String prefix);
}