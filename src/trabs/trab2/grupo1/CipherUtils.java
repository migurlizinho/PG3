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
    UnaryOperator<Character> ceaserCipher = (Character character) -> {return (char) encode(character, n);};
    try(BufferedReader br = new BufferedReader(new FileReader(pathname))){
        process(br, ceaserCipher, action);
    }
  }

  void encryptFile(String pathname, int n) throws IOException {
    File file = new File(pathname);
    try(FileWriter fileWriter = new FileWriter(file.getName() + ".cph")){
        BiConsumer<Character, Character> consumer = (Character character, Character character2) -> {
          try {
            fileWriter.write(character2);
          } catch (IOException e) {
            throw new RuntimeException(e);
          }
        };
        processCipher(pathname, n, consumer);
    }
  }

  void decryptFile(String pathname, int n) throws IOException {
    processCipher(pathname, -n, (Character character, Character character2) -> {System.out.println(character2);});
  }

  String processText(String text, int n, boolean isEncrypt) throws IOException {
    StringWriter sw = new StringWriter();
    int n2 = (isEncrypt)? n : -n;
    process(new BufferedReader(new StringReader(text)),
            (Character char1) -> {return (char) encode(char1, n2);}
            , (Character char1, Character char2) -> {sw.write(char2);});
    return sw.toString();
  }
}