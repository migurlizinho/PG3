package trabs.trab2.grupo1;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GuiApp extends JFrame{
    private static JTextArea outputField;
    private static JTextArea inputField;
    private static final CipherUtils cipherUtils = new CipherUtils();
    private static JTextField nShiftsField;

    public GuiApp(){
        setSize(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        GuiApp app = new GuiApp();
        Container content = app.getContentPane();

        // --------------------TOP PANEL---------------------

        JPanel topPanel = new JPanel(new BorderLayout());
        content.add(topPanel, BorderLayout.NORTH);

        JTextField filePathField = new JTextField(30);
        filePathField.setBorder(new TitledBorder("filename"));
        topPanel.add(filePathField, BorderLayout.CENTER);

        nShiftsField = new JTextField("1",5);
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
        cipherButton.addActionListener(e -> {processInputToOutput(true);});
        bottomPanel.add(cipherButton);

        JButton decipherButton = new JButton("Decipher");
        decipherButton.addActionListener(e -> {processInputToOutput(false);});
        bottomPanel.add(decipherButton);

        JButton toFileButton = new JButton("To File");
        toFileButton.addActionListener(e -> {

        });
        bottomPanel.add(toFileButton);

        app.pack();
        app.setVisible(true);
    }

    private static void processInputToOutput(boolean Encrypt){
        String input = inputField.getText();
        String nStr = nShiftsField.getText();
        int n = (nStr.isEmpty())?0:Integer.parseInt(nStr);
        String encriptedText = null;
        try {
            encriptedText = cipherUtils.processText(input, n, Encrypt);
        }catch (IOException exp){
            System.out.println("Error processing the text: " + exp.getMessage());
        }
        outputField.setText(encriptedText);
    }
}
