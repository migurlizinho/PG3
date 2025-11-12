package aulas.estudos.t123;

public class ParagraphsExample {
    public static void main(String[] args) {
//        TextParagraph txt = new TextParagraph("1ª imagem.");
//        System.out.println(txt.getContent());
//        ImageParagraph img = new ImageParagraph("image1.jpg");
//        System.out.println(img.getContent());

//        Paragraph txt = new TextParagraph( "1 imagem.");
//        Paragraph img= new ImageParagraph( "image1.jpg");
//        SimplePage pg= new SimplePage( "1 página", txt, img );
//        System.out.println(pg.render());

        Page pg1 = new SimplePage( "1ª página", new TextParagraph("1ª imagem"), new ImageParagraph("img1.jpg" ));
        Page pg2 = new SimplePage( "2ª página", new TextParagraph("2ª imagem"), new ImageParagraph("img2.jpg"));
        FolderPage f = new FolderPage( 1, new TextParagraph("Conjunto de páginas." ));
        try {
            f.addPage( pg1 ).addPage( pg2 );
        }
        catch( CmsException e ) {
            System.out.println( e.getMessage() );
        }
        System.out.println( f.render() );
        Page foundPage = f.findFirstPage("imagem");
        if ( foundPage != null ) System.out.println( foundPage.render() );
    }
}
