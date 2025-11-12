package aulas.estudos.t124;

import java.util.function.Predicate;

public class Carriage extends Vehicle{
    public final static char PREFIX_CAR = 'C';
    private final int seats;

    protected Carriage(int number, int weight) {
        super(String.valueOf(PREFIX_CAR) + String.valueOf(number), weight);
        this.seats = 0;
    }

    protected Carriage(int number, int seats, int weight) {
        super(String.valueOf(PREFIX_CAR) + String.valueOf(number), weight);
        this.seats = seats;
    }

    @Override
    public int getSeats() {
        return seats;
    }
}
