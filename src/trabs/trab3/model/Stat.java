package trabs.trab3.model;

import java.util.HashMap;
import java.util.Map;

public class Stat implements RaceModel.Statistics{
    private final String playerName;
    private int totalRaces;
    private int correctBets;
    private final Map<String, Integer> victories;

    public Stat(String playerName) {
        this.playerName = playerName;
        this.victories = new HashMap<>();
    }

    @Override
    public String getPlayerName() {return playerName;}
    @Override
    public int getTotalRaces() {return totalRaces;}
    @Override
    public int getCorrectBets() {return correctBets;}
    @Override
    public Map<String, Integer> getVictories() {return victories;}
    @Override
    public void finishRace(String winner, String bet) {
        totalRaces++;
        if(winner.equals(bet)){
            correctBets++;
            victories.compute(winner, (k, wins) -> (wins != null) ? wins+1 : 1);
        }
    }
    @Override
    public int percentageCorrectBets() {
        double r = (double) correctBets / (double)((totalRaces == 0)? 1 : totalRaces);
        return (int) (r * 100);
    }

    public String formatStringLn(){
        return playerName + "   " + percentageCorrectBets() + "%  " + correctBets + "/" + totalRaces + "\n";
    }

    @Override
    public String toString() {
        return "Stat{" +
            "playerName='" + playerName + '\'' +
            ", totalRaces=" + totalRaces +
            ", correctBets=" + correctBets +
            ", victories=" + victories +
            '}';
    }
}
