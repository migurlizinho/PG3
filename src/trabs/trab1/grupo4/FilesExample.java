package trabs.trab1.grupo4;

import java.util.List;

public class FilesExample {
    public static void main(String[] args) throws FileException {
/*
        File f = new DataFile("file1", 100);
        System.out.println( f + " -> "+ f.getAbsolutePath() );
        f.setCurrentDir( new Directory("dir1") );
        System.out.println( f + " -> " + f.getAbsolutePath() );
*/

/*
        File f1 = new DataFile("file1", 100); f1.setCurrentDir( new Directory("dir1") );
        File f2 = new Shortcut("file2", f1);
        System.out.println( f2.getDescription("") );
*/

        Dir d1 = new Directory("dir1");
        d1.append("file1", 100).append(new Directory("dir2") );
        File f = d1.get( ft -> ft instanceof Dir);
        if ( f != null )
            ((Dir) f).append("file2", 100).append("file3",300);
        f = d1.get( ft-> ft.getName().equals("file2"));
        d1.append( new Shortcut("file4", f));
//        System.out.println( d1.getDescription("") );

//        Dir d1 = new Directory("dir1");
//        int length;
//        for (int i = 2; i > -2 ; i--) {
//                length = i;
//                d1.append("file"+i, length);
//                length = 0;
//        }

        d1.append("file5", 50).append("file6", 150 );
        List<File> l = d1.getAll(ft -> ft instanceof DataFile);
        System.out.println(d1.getDescription(""));
    }
}