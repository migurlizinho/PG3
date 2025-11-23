package trabs.trab2.grupo2;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class GuiApp extends JFrame {
    private final static JTextField filePathField = new JTextField("names.txt", 30);
    private final static JTextArea centerArea = new JTextArea();
    private final static JTextField surnameField = new JTextField("Costa",10);
    private static Map<String, Collection<String>> map = new HashMap();

    public GuiApp(){
        setTitle("Families");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        GuiApp app = new GuiApp();
        Container content = app.getContentPane();

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");

        JMenuItem loadButton = new JMenuItem("Load");
        loadButton.addActionListener((a) -> {
            try{
                map = AlgorithmUtils.families(new File(filePathField.getText()), HashMap<String, Collection<String>>::new, ArrayList::new);
            } catch (IOException e) {
                centerArea.setText("File \"" + filePathField.getText() + "\" not found");
            }
        });
        menu.add(loadButton);

        JMenuItem surnamesButton = new JMenuItem("Surnames");
        surnamesButton.addActionListener(GuiApp::actionListener);
        menu.add(surnamesButton);

        JMenuItem familyButton = new JMenuItem("Family");
        familyButton.addActionListener(GuiApp::actionListener);
        menu.add(familyButton);

        JMenuItem greaterFamiliesButton = new JMenuItem("Greater Families");
        greaterFamiliesButton.addActionListener(GuiApp::actionListener);
        menu.add(greaterFamiliesButton);

        menuBar.add(menu);
        app.setJMenuBar(menuBar);

        // --------------------TOP PANEL---------------------
        JPanel topPanel = new JPanel(new BorderLayout());
        content.add(topPanel, BorderLayout.NORTH);

        filePathField.setBorder(new TitledBorder("filename"));
        topPanel.add(filePathField, BorderLayout.CENTER);

        surnameField.setBorder(new TitledBorder("surname"));
        topPanel.add(surnameField, BorderLayout.EAST);

        // --------------------CENTER PANEL---------------------
        centerArea.setEditable(false);
        centerArea.setBorder(new TitledBorder("list"));
        content.add(centerArea, BorderLayout.CENTER);

        app.setVisible(true);
    }

    public static void actionListener(ActionEvent actionEvent){
        if(map == null || map.isEmpty()){
            centerArea.setText("No file loaded, please load a file");
            return;
        }
        StringBuilder sb = new StringBuilder();
        switch (actionEvent.getActionCommand()){
            case "Surnames":
                map.keySet().forEach((s) -> {sb.append(s).append('\n');});
                break;
            case "Family":
                String family = surnameField.getText();
                try{
                    map.get(family).forEach((s) -> {sb.append(s).append('\n');});
                }catch (NullPointerException e){
                    sb.append("No member of family \"").append(family).append("\" found.");
                }
                break;
            case "Greater Families":
                Collection<String> seq = new ArrayList<>();
                AlgorithmUtils.processRisingElements(map.values(),
                        (c1, c2) -> {return c1.size() - c2.size();},
                        (c) -> {seq.add(AlgorithmUtils.getSurname((String) c.toArray()[0]));}
                );
                seq.forEach(s -> {sb.append(s).append('\n');});
        }
        centerArea.setText(sb.toString());
    }
}
