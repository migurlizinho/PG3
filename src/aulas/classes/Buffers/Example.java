package aulas.classes.Buffers;

import java.io.File;
;

public class Example {
    public static void listAllFiles(File file, String prefix){
        System.out.println(prefix + file.getName());
        if(file.isDirectory()){
            for (File f : file.listFiles()) {
                listAllFiles(f, prefix + "\t");
            }
        }
    }

    public static void main(String[] args) {
        listAllFiles(new File("~/IdeaProjects/PG3"), "-");
    }
}
