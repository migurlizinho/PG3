package trabs.trab3.model;

import java.util.Map;

public class Stat implements RaceModel.Statistics{
    private final String playerName;
    private int totalRaces;
    private int correctBets;
    private Map<String, Integer> victories;

    public Stat(String playerName) {
        this.playerName = playerName;
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
        return (correctBets/totalRaces)*100;
    }
}
