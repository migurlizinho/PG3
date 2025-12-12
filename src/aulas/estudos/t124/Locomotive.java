package aulas.estudos.t124;

public class Locomotive extends Vehicle implements Towable{
    public final static char PREFIX_LOC = 'L';
    private final int towableWeight;

    protected Locomotive(String name, int weight, int towableWeight) throws VehicleException {
        super(String.valueOf(PREFIX_LOC) + String.valueOf('-') + name, weight);
        if(towableWeight < weight)
            throw new VehicleException("invalid weights");
        this.towableWeight = towableWeight;
    }

    @Override
    public int getTowableWeight() {
        return towableWeight;
    }

    @Override
    public int getSeats() {
        return 0;
    }

    @Override
    public String toString() {
        return super.toString() + " towable weight: " + towableWeight + 't';
    }
}
