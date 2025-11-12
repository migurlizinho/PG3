package aulas.estudos.t123;

public class TextParagraph implements Paragraph{
    private final String text;

    public TextParagraph(String text){
        this.text = text;
    }

    @Override
    public String getContent() {
        return "<txt>" + text + "</txt>";
    }

    @Override
    public boolean containText(String word) {
        return text.contains(word);
    }
}
