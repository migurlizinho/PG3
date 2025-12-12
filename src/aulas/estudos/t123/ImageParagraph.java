package aulas.estudos.t123;

public class ImageParagraph implements Paragraph{
    private final String text;

    public ImageParagraph(String text){
        this.text = text;
    }

    @Override
    public String getContent() {
        return "<img src=\"" + text + "\"/>";
    }

    @Override
    public boolean containText(String word) {
        return false;
    }
}
