package trabs.trab1.grupo4;

public class FileException extends Exception {
    private final File file;

    public FileException(String message) {
        super(message);
        file = null;
    }
    public FileException(File file){
        super(file.getAbsolutePath() + "Invalid Access");
        this.file = file;
    }

    public File getFile() {
        return file;
    }
}