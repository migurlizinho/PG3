package aulas.estudos.t123;

import java.util.ArrayList;
import java.util.Iterator;

public class FolderPage extends Page implements Iterable<Page>{
    private final ArrayList<Page> pages;

    public FolderPage(int titleId, Paragraph... paragraphs) {
        super("folder", "Pasta " + titleId, paragraphs);
        pages = new ArrayList<>();
    }

    @Override
    public String renderMenu(String prefix) {
        StringBuilder sb = new StringBuilder();
        sb.append(prefix).append("<menu>\n");
        for (Page page : pages) {
            sb.append(prefix).append('\t').append("<item>").append(page.getTitle()).append("</item>\n");
        }
        sb.append(prefix).append("</menu>");
        return sb.toString();
    }

    @Override
    public Page findFirstPage(String searchedText) {
        Page superRet = super.findFirstPage(searchedText);
        if(superRet != null)
            return superRet;
        for (Page page : pages) {
            Page pageRet = page.findFirstPage(searchedText);
            if(pageRet != null)
                return pageRet;
        }
        return null;
    }

    public FolderPage addPage(Page page) throws CmsException{
        for (Page page1 : pages) {
            if(page1 == page)
                throw new CmsException(page);
        }
        pages.add(page);
        return this;
    }

    @Override
    public Iterator<Page> iterator() {
        return pages.iterator();
    }
}
