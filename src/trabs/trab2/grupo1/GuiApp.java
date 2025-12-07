package trabs.trab2.grupo1;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

public class GuiApp extends JFrame {
  private final JTextField nShiftsField = new JTextField("1", 6);
  private final JTextField filePathField = new JTextField(30);
  private final JTextArea outputField = new JTextArea(18, 18);
  private final JTextArea inputField = new JTextArea(18, 18);
  private  final CipherUtils cipherUtils = new CipherUtils();

  public GuiApp() {
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    Container content = getContentPane();

    JPanel topPanel = new JPanel(new BorderLayout());
    content.add(topPanel, BorderLayout.NORTH);

    filePathField.setBorder(new TitledBorder("filename"));
    topPanel.add(filePathField, BorderLayout.CENTER);

    nShiftsField.setBorder(new TitledBorder("n"));
    topPanel.add(nShiftsField, BorderLayout.EAST);

    // --------------------CENTER PANEL---------------------

    JPanel centerPanel = new JPanel(new GridLayout(1, 2));
    content.add(centerPanel, BorderLayout.CENTER);

    inputField.setBorder(new TitledBorder("Input"));
    centerPanel.add(inputField);

    outputField.setBorder(new TitledBorder("Output"));
    centerPanel.add(outputField);

    // --------------------BOTTOM PANEL---------------------

    JPanel bottomPanel = new JPanel(new FlowLayout());
    content.add(bottomPanel, BorderLayout.SOUTH);

    JButton cipherButton = new JButton("Cipher");
    cipherButton.addActionListener(e -> processFile(true));
    bottomPanel.add(cipherButton);

    JButton decipherButton = new JButton("Decipher");
    decipherButton.addActionListener(e -> processFile(false));
    bottomPanel.add(decipherButton);

    JButton toFileButton = new JButton("To File");
    toFileButton.addActionListener(e -> processToFile());
    bottomPanel.add(toFileButton);
    this.pack();
  }

  public static void main(String[] args) {
    GuiApp app = new GuiApp();
    app.setVisible(true);
  }

  private int readN() {
    String nStr = nShiftsField.getText();
    return (nStr.isEmpty()) ? 0 : Integer.parseInt(nStr);
  }

  private void processFile(boolean isEncrypt){
    String fileName = filePathField.getText();
   try {
      int n = (isEncrypt)? readN() : -readN();
      inputField.setText("");
      outputField.setText("");
      cipherUtils.processCipher(fileName, n, ( c1, c2) -> {
        inputField.append(String.valueOf(c1));
        outputField.append(String.valueOf(c2));
      });
    }catch (IOException e){
      JOptionPane.showMessageDialog(this, "Error reading file");
    }catch (NumberFormatException e){
     JOptionPane.showMessageDialog(this, "Error parsing n");
   }
  }

  private void processToFile() {
      try (FileWriter fw = new FileWriter("out.cph")){
          fw.append(outputField.getText());
      } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "Error creating file");
      }
  }
}
