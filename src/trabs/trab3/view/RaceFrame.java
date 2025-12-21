package trabs.trab3.view;

import trabs.trab3.model.RaceGame;
import trabs.trab3.model.RaceModel;
import trabs.trab3.model.Racer;
import trabs.trab3.model.Stat;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;

public class RaceFrame extends JFrame implements RaceView {
    private final RaceGame race;
    private final RacePanel racePanel;
    private final Timer timer;

    private final JComboBox<String> racerSelector;

    private final JTextField racesField;
    private final JTextField correctBetsField;
    private final ArrayList<JTextField> winnerCounterFields;

    public RaceFrame(RaceModel race){
        this.race = (RaceGame) race;
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if(!race.saveStatistics())
                    JOptionPane.showMessageDialog(e.getWindow(),"Error saving statistics!!!");
                e.getWindow().dispose();
            }
        });

        Container content = getContentPane();

        racePanel = new RacePanel(race.getRacers(), race.getFinishLine());
        content.add(racePanel, BorderLayout.CENTER);

        //TOP PANEL------------------------------------------------------------------------------
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        racerSelector = new JComboBox<String>();
        race.getRacers().forEach(r -> racerSelector.addItem(r.getIdentifier()));
        topPanel.add(racerSelector);

        JButton startButton = new JButton("Start Race");
        startButton.addActionListener(a -> startListener());
        topPanel.add(startButton);

        JButton topTenButton = new JButton("Top Ten");
        topTenButton.addActionListener(a -> topTenListener());
        topPanel.add(topTenButton);

        content.add(topPanel, BorderLayout.NORTH);

        //BOTTOM PANEL----------------------------------------------------------------------------
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        //BETS PANEL---
        JPanel betsPanel = new JPanel(new GridLayout(1, 2));
        betsPanel.setBorder(new TitledBorder("bets"));

        racesField = new JTextField(String.valueOf(race.getPlayerStatistics().getTotalRaces()), 5);
        racesField.setHorizontalAlignment(JTextField.CENTER);
        racesField.setEditable(false);
        racesField.setBorder(BorderFactory.createTitledBorder("races"));
        betsPanel.add(racesField, 0);

        correctBetsField = new JTextField(String.valueOf(race.getPlayerStatistics().getCorrectBets()), 5);
        correctBetsField.setHorizontalAlignment(JTextField.CENTER);
        correctBetsField.setEditable(false);
        correctBetsField.setBorder(new TitledBorder("correct"));
        betsPanel.add(correctBetsField,1);

        bottomPanel.add(betsPanel);
        //WINS COUNTER PANEL---
        int n = 0;
        for (Racer racer : race.getRacers()) {
            n++;
        }
        JPanel winCounterPanel = new JPanel(new GridLayout(1, n));
        winCounterPanel.setBorder(new TitledBorder("Win Counters"));

        winnerCounterFields = new ArrayList<>(n);
        for (Racer racer : race.getRacers()) {
            JTextField field = new JTextField("0", (2*racer.getIdentifier().length())/3);
            field.setHorizontalAlignment(JTextField.CENTER);
            field.setEditable(false);
            field.setBorder(new TitledBorder(racer.getIdentifier()));
            winnerCounterFields.add(field);
            winCounterPanel.add(field);
        }

        bottomPanel.add(winCounterPanel);

        content.add(bottomPanel, BorderLayout.SOUTH);

        timer = new Timer(16, a -> stepListener());
        pack();
    }

    @Override
    public void startListener() {
        if(timer.isRunning())
            return;
        race.start((String) racerSelector.getSelectedItem());
        timer.start();
    }

    @Override
    public void stepListener() {
        racePanel.updatePositions(race.getRacers());
        Racer winner;
        if((winner = race.step()) != null){
            timer.stop();
            updateStatsFields(winner);
            JOptionPane.showMessageDialog(this,"Winner: " + winner.getIdentifier());
        }
    }

    @Override
    public void topTenListener() {
        StringBuilder sb = new StringBuilder();
        race.getTopTen().forEach(s -> sb.append(((Stat)s).formatStringLn()));
        JOptionPane.showMessageDialog(this, sb);
    }

    @Override
    public void updateStatsFields(Racer winner) {
        Stat stats = (Stat) race.getPlayerStatistics();
        stats.finishRace(winner.getIdentifier(), (String)(racerSelector.getSelectedItem()));

        correctBetsField.setText(String.valueOf(stats.getCorrectBets()));
        racesField.setText(String.valueOf(stats.getTotalRaces()));

        Iterator<Racer> racers = race.getRacers().iterator();
        for (JTextField winnerCounterField : winnerCounterFields) {
            if(racers.next().getIdentifier().contains(winner.getIdentifier()))
                winnerCounterField.setText(String.valueOf(Integer.parseInt(winnerCounterField.getText()) + 1));
        }
    }
}
