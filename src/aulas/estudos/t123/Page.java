package aulas.estudos.t123;

public abstract class Page {
    private final Paragraph[] paragraphs;
    private final String tag;
    private final String title;

    public Page(String tag, String title, Paragraph... paragraphs){
        this.tag = tag;
        this.title = title;
        this.paragraphs = paragraphs;
    }

    public final String getTitle() {
        return title;
    }

    public abstract String renderMenu(String prefix);

    public Page findFirstPage(String searchedText){
        if(title.contains(searchedText))
            return this;
        for (Paragraph paragraph : paragraphs) {
            if(paragraph.containText(searchedText))
                return this;
        }
        return null;
    }

    public String render(){
        StringBuilder sb = new StringBuilder();
        String prefix = "\t";
        sb.append('<').append(tag).append('>').append('\n');
        sb.append(prefix).append("<title>").append(title).append("</title>").append('\n');
        sb.append(this.renderMenu(prefix)).append('\n');
        for (Paragraph paragraph : paragraphs) {
            sb.append(prefix).append(paragraph.getContent()).append('\n');
        }
        sb.append("</").append(tag).append('>').append('\n');
        return sb.toString();
    }
}