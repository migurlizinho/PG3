package trabs.trab3;

public class Race {
    public final Car car1;
    public final Car car2;
    public final Car car3;

    public enum GameState{
        ONGOING,CAR1,CAR2,CAR3
    }
    private GameState gameState = GameState.ONGOING;

    private int finnish = 300;
    private int start = 300;

    public Race(int start, int finnish){
        car1 = new Sprinter("Sprinter", start);
        car2 = new Crawler("Crawler", start);
        car3 = new Robot("Robot", start);
        this.start = start;
        this.finnish = finnish;
    }

    public void updateCars(){
        car1.move();
        car2.move();
        car3.move();
        if(car1.getX() >= finnish){
            restart(car1);
            gameState = GameState.CAR1;
        }else if(car2.getX() >= finnish){
            restart(car2);
            gameState = GameState.CAR2;
        } else if(car3.getX() >= finnish){
            restart(car3);
            gameState = GameState.CAR3;
        }
    }

    private void restart(Car winner){
        car1.reset(start);
        car2.reset(start);
        car3.reset(start);
    }

    public void setFinnish(int finnish) {
        this.finnish = finnish;
    }

    public GameState getGameState(){return gameState;}

    public void startRace(){gameState = GameState.ONGOING;}

    public int getFinnish(){return finnish;}
}