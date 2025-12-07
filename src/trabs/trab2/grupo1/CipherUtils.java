package trabs.trab2.grupo1;

import java.io.*;
import java.util.function.BiConsumer;
import java.util.function.UnaryOperator;

public class CipherUtils {

  public int encode(int c, int n) {
    if (!Character.isAlphabetic(c))
      return c;
    if (Character.isLowerCase(c) && c + n > 'z') {
      return 'a' + (n - ('z' - c) - 1);
    }
    if (Character.isLowerCase(c) && c + n < 'a') {
      n = -n;
      return 'z' - (n - (c - 'a') - 1);
    }
    if (Character.isUpperCase(c) && c + n > 'Z') {
      return 'A' + (n - ('Z' - c) - 1);
    }
    if (Character.isUpperCase(c) && c + n < 'A') {
      n = -n;
      return 'Z' - (n - (c - 'A') - 1);
    }
    return c + n;
  }

  public void process(BufferedReader br, UnaryOperator<Character> mapper, BiConsumer<Character, Character> action) throws IOException {
    int c;
    while ((c = br.read()) != -1) {
      action.accept((char) c, mapper.apply((char) c));
    }
  }

  void processCipher(String pathname, int n, BiConsumer<Character, Character> action) throws IOException {
    try(BufferedReader br = new BufferedReader(new FileReader(pathname))){
        process(br, (c)->(char)encode(c, n), action);
    }
  }

  void encryptFile(String pathname, int n) throws IOException {
    File file = new File(pathname);
    try(PrintWriter fileWriter = new PrintWriter(file.getName() + ".cph")){
        BiConsumer<Character, Character> consumer = (c1,c2) -> {
            fileWriter.write(c2);
        };
        processCipher(pathname, n, consumer);
    }
  }

  void decryptFile(String pathname, int n) throws IOException {
    processCipher(pathname, -n, (c1, c2) -> System.out.println(c2));
  }

  String processText(String text, int n, boolean isEncrypt) {
    StringWriter sw = new StringWriter();
    int n2 = (isEncrypt)? n : -n;
      try {
          process(new BufferedReader(new StringReader(text)),
                  (c) -> (char) encode(c, n2),
                  (c1, c2) -> sw.write(c2));
      } catch (IOException e) {
          throw new RuntimeException(e);
      }
      return sw.toString();
  }
}