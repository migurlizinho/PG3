package aulas.estudos.t123;

public class CmsException extends Exception{
    public CmsException(String message){
        super(message);
    }

    public CmsException(Page page){
        super("Duplicate Page:" + "\"" + page.getTitle() + "\"");
    }
}
