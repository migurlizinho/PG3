package trabs.trab1.grupo4;

public class FileException extends RuntimeException {
    private File file;

    public FileException(String message) {
        super(message);
    }
    public FileException(File file){
        this.file = file;
    }

    public File getFile() {
        return file;
    }
}
