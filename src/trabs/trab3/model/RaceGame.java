package trabs.trab3.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RaceGame implements RaceModel{
    private static final String STATS_FILEPATH = "race_statistics.txt";

    private RaceModel.Statistics statistics;
    private ArrayList<Racer> racers;
    private final int finnishLine;

    public RaceGame(String playername, int finnishLine, Racer... racers){
        this.racers = (ArrayList<Racer>) List.of(racers);
        this.finnishLine = finnishLine;
        for (Statistics stats : getAllStatistics()) {
            if(stats.getPlayerName().equals(playername)){
                statistics = getPlayerStatistics();
                if(statistics == null)
                    statistics = new Stat(playername);
            }
        }
    }

    @Override
    public int getFinishLine() {return finnishLine;}

    @Override
    public Iterable<Racer> getRacers() {return racers;}

    @Override
    public void start(String bet) {
    }

    @Override
    public Racer step() {
        for (Racer racer : racers) {
            racer.walk();
            if(racer.getPosition() >= finnishLine)
                return racer;
        }
        return null;
    }

    @Override
    public Iterable<Statistics> getTopTen() {
        ArrayList<Statistics> allStats = (ArrayList<Statistics>) getAllStatistics();
        allStats.sort((s1, s2) -> {return s2.percentageCorrectBets() - s1.percentageCorrectBets();});
        return allStats.subList(0, 9);
    }

    @Override
    public Statistics getPlayerStatistics() {return statistics;}

    @Override
    public Iterable<Statistics> getAllStatistics() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(STATS_FILEPATH))) {
            statistics = (Statistics) inputStream.readObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public boolean saveStatistics() {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(STATS_FILEPATH));
            outputStream.writeObject(statistics);
        } catch (IOException e) {
            return false;
        }
        return true;
    }
}
