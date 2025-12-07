package trabs.trab2.grupo2;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class GuiApp extends JFrame{
  private final JTextField filePathField = new JTextField("names.txt", 30);
  private final JTextField surnameField = new JTextField(10);
  private final JTextArea centerArea = new JTextArea(20, 40);
  private static Map<String, Collection<String>> map = new HashMap<>();

  public GuiApp(){
    setTitle("Families");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    Container content = getContentPane();

    // --------------------MENU BAR---------------------
    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu("Menu");

    JMenuItem loadButton = new JMenuItem("Load");
    loadButton.addActionListener((a) -> loadAction());
    menu.add(loadButton);

    JMenuItem surnamesButton = new JMenuItem("Surnames");
    surnamesButton.addActionListener((a) -> surnamesAction());
    menu.add(surnamesButton);

    JMenuItem familyButton = new JMenuItem("Family");
    familyButton.addActionListener((a) -> familyAction());
    menu.add(familyButton);

    JMenuItem greaterFamiliesButton = new JMenuItem("Greater Families");
    greaterFamiliesButton.addActionListener((a)-> greaterFamiliesAction());
    menu.add(greaterFamiliesButton);

    menuBar.add(menu);
    this.setJMenuBar(menuBar);

    // --------------------TOP PANEL---------------------
    JPanel topPanel = new JPanel(new BorderLayout());
    content.add(topPanel, BorderLayout.NORTH);

    Font font = new Font("JetBrains Mono", Font.PLAIN, 15);

    filePathField.setBorder(new TitledBorder("filename"));
    filePathField.setFont(font);
    topPanel.add(filePathField, BorderLayout.CENTER);

    surnameField.setBorder(new TitledBorder("surname"));
    surnameField.setFont(font);
    topPanel.add(surnameField, BorderLayout.EAST);

    // --------------------CENTER PANEL---------------------
    centerArea.setEditable(false);
    centerArea.setBorder(new TitledBorder("list"));
    centerArea.setFont(font);
    JScrollPane scrollPane = new JScrollPane(centerArea);
    content.add(scrollPane, BorderLayout.CENTER);
    pack();
  }

  public static void main(String[] args) {
    GuiApp app = new GuiApp();
    app.setVisible(true);
  }

  public void loadAction(){
    try{
      map = AlgorithmUtils.families(new File(filePathField.getText()), HashMap::new, ArrayList::new);
    } catch (IOException e) {
      centerArea.setText("File \"" + filePathField.getText() + "\" not found");
    }
  }

  public boolean testParamsAction(){
    if(map.isEmpty()){
      centerArea.setText("No file loaded, please load a file");
      return false;
    }
    return true;
  }

  public void surnamesAction(){
    if(!testParamsAction())
      return;
    StringBuilder sb = new StringBuilder();
    map.keySet().forEach((s) -> sb.append(s).append('\n'));
    centerArea.setText(sb.toString());
  }

  public void familyAction(){
    if(!testParamsAction())
      return;
    StringBuilder sb = new StringBuilder();
    String family = surnameField.getText();
    try{
      map.get(family).forEach((s) -> sb.append(s).append('\n'));
    }catch (NullPointerException e){
      sb.append("No member of family \"").append(family).append("\" found.");
    }
    centerArea.setText(sb.toString());
  }

  public void greaterFamiliesAction(){
    if(!testParamsAction())
      return;
    StringBuilder sb = new StringBuilder();
    Collection<String> seq = new ArrayList<>();
    AlgorithmUtils.processRisingElements(map.values(),
        Comparator.comparingInt(Collection::size),
        (c) -> seq.add(AlgorithmUtils.getSurname(c.iterator().next()))
    );
    seq.forEach(s -> sb.append(s).append('\n'));
    centerArea.setText(sb.toString());
  }
}
