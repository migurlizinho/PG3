package aulas.estudos.t123;

public class SimplePage extends Page{
    public SimplePage(String title, Paragraph... paragraphs) {
        super("page", title, paragraphs);
    }

    @Override
    public String renderMenu(String prefix) {
        return prefix + "<menu><item>voltar</item></menu>";
    }
}
