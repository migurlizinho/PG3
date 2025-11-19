package trabs.trab2.grupo1;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GuiApp extends JFrame {
  private static JTextArea outputField;
  private static JTextArea inputField;
  private static final CipherUtils cipherUtils = new CipherUtils();
  private static JTextField nShiftsField;
  private static JTextField filePathField;

  public GuiApp() {
    setSize(300, 300);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  public static void main(String[] args) {
    GuiApp app = new GuiApp();
    Container content = app.getContentPane();

    // --------------------TOP PANEL---------------------

    JPanel topPanel = new JPanel(new BorderLayout());
    content.add(topPanel, BorderLayout.NORTH);

    filePathField = new JTextField(30);
    filePathField.setBorder(new TitledBorder("filename"));
    topPanel.add(filePathField, BorderLayout.CENTER);

    nShiftsField = new JTextField("1", 5);
    nShiftsField.setBorder(new TitledBorder("n"));
    topPanel.add(nShiftsField, BorderLayout.EAST);

    // --------------------CENTER PANEL---------------------

    JPanel centerPanel = new JPanel(new GridLayout(1, 2));
    content.add(centerPanel, BorderLayout.CENTER);

    inputField = new JTextArea();
    inputField.setBorder(new TitledBorder("Input"));
    centerPanel.add(inputField);

    outputField = new JTextArea();
    outputField.setBorder(new TitledBorder("Output"));
    centerPanel.add(outputField);

    // --------------------BOTTOM PANEL---------------------

    JPanel bottomPanel = new JPanel(new FlowLayout());
    content.add(bottomPanel, BorderLayout.SOUTH);

    JButton cipherButton = new JButton("Cipher");
    cipherButton.addActionListener(e -> {
      processInputToOutput(true);
    });
    bottomPanel.add(cipherButton);

    JButton decipherButton = new JButton("Decipher");
    decipherButton.addActionListener(e -> {
      processInputToOutput(false);
    });
    bottomPanel.add(decipherButton);

    JButton toFileButton = new JButton("To File");
    toFileButton.addActionListener(e -> {
      processToFile();
    });
    bottomPanel.add(toFileButton);

    app.setVisible(true);
  }

  private static int readN() {
    String nStr = nShiftsField.getText();
    return (nStr.isEmpty()) ? 0 : Integer.parseInt(nStr);
  }

  private static void processInputToOutput(boolean Encrypt) {
    String input = inputField.getText();
    int n = readN();
    String encryptedText = null;
    try {
      encryptedText = cipherUtils.processText(input, n, Encrypt);
    } catch (IOException exp) {
    }
    outputField.setText(encryptedText);
  }

  private static void processToFile() {
    String fileName = filePathField.getText();
    try {
      cipherUtils.encryptFile(fileName, readN());
    } catch (IOException e) {
    }
  }
}
