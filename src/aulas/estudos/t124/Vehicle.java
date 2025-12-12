package aulas.estudos.t124;

public abstract class Vehicle {
    private final String identifier;
    private final int weight;

    protected Vehicle(String identifier, int weight){
        this.identifier = identifier;
        this.weight = weight;
    }

    public final String getIdentifier() {
        return identifier;
    }

    public int getWeight() {
        return weight;
    }

    public abstract int getSeats();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.getIdentifier());
        int seats = this.getSeats();
        if(seats != 0)
            sb.append(" seats: ").append(this.getSeats());
        sb.append(" weight: ").append(this.getWeight()).append('t');
        return sb.toString();
    }
}