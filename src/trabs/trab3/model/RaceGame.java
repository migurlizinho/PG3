package trabs.trab3.model;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RaceGame implements RaceModel{
    private static final String STATS_FILEPATH = "race_statistics";

    private HashMap<String,Statistics> allStats;
    private final RaceModel.Statistics statistics;
    private final ArrayList<Racer> racers;
    private final int finnishLine;

    public RaceGame(String playername, int finnishLine, Racer... racers){
        this.racers = new ArrayList<>(List.of(racers));
        this.finnishLine = finnishLine;

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(STATS_FILEPATH))) {
            allStats = (HashMap<String, Statistics>) inputStream.readObject();
        } catch (IOException e) {
            allStats = new HashMap<>();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        if(allStats.containsKey(playername)){
            statistics = allStats.get(playername);
        }else {
            statistics = new Stat(playername);
            allStats.put(playername, statistics);
        }
    }

    @Override
    public int getFinishLine() {return finnishLine;}

    @Override
    public Iterable<Racer> getRacers() {return racers;}

    @Override
    public void start(String bet) {
        racers.forEach(Racer::reset);
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
        ArrayList<Statistics> stats = new ArrayList<>(allStats.values());
        stats.sort((s1, s2) -> {return s2.percentageCorrectBets() - s1.percentageCorrectBets();});
        int n = Math.min(9, stats.size());
        return stats.subList(0, n);
    }

    @Override
    public Statistics getPlayerStatistics() {return statistics;}

    @Override
    public Iterable<Statistics> getAllStatistics() {
        return allStats.values().stream().toList();
    }

    @Override
    public boolean saveStatistics() {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(STATS_FILEPATH));
            outputStream.writeObject(allStats);
        } catch (IOException e) {
            return false;
        }
        return true;
    }
}