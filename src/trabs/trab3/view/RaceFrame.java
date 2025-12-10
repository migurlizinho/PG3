package trabs.trab3.view;

import trabs.trab3.model.RaceModel;
import trabs.trab3.model.Racer;

import javax.swing.*;

public class RaceFrame extends JFrame implements RaceView {
    private final RaceModel game;
    public RaceFrame(RaceModel game){
        this.game = game;
    }

    @Override
    public void startListener() {

    }

    @Override
    public void stepListener() {

    }

    @Override
    public void topTenListener() {

    }

    @Override
    public void updateStatsFields(Racer winner) {

    }
}
