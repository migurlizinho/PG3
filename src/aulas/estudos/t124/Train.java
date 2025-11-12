package aulas.estudos.t124;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Train extends Vehicle implements Towable, Iterable<Carriage> {
    private final Locomotive locomotive;
    private final ArrayList<Carriage> carriages;

    protected Train(String name, Locomotive locomotive) {
        super("Train " + name, 0);
        this.locomotive = locomotive;
        carriages = new ArrayList<>();
    }

    public Carriage findFirst(Predicate<Carriage> predicate){
        for (Carriage carriage : carriages) {
            if(predicate.test(carriage))
                return carriage;
        }
        return null;
    }

    @Override
    public int getTowableWeight() {
        return locomotive.getTowableWeight();
    }

    @Override
    public int getWeight() {
        int sum = 0;
        for (Carriage carriage : carriages) {
            sum += carriage.getWeight();
        }
        return sum;
    }

    @Override
    public int getSeats() {
        int sum = 0;
        for (Carriage carriage : carriages) {
            sum += carriage.getSeats();
        }
        return sum;
    }

    public Train append(Carriage carriage) throws VehicleException {
        if(findFirst(carriage1 -> carriage1.getIdentifier().equals(carriage.getIdentifier())) != null || getTowableWeight() < getWeight() + carriage.getWeight()) {
            throw new VehicleException("invalid carriage", carriage);
        }else{
            carriages.add(carriage);
        }
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        String prefix = "\n - ";
        sb.append(prefix).append(locomotive.toString());
        carriages.sort((c1,c2) -> {return c1.getSeats() - c2.getSeats();});
        for (Carriage carriage : carriages) {
            sb.append(prefix).append(carriage.toString());
        }
        return sb.toString();
    }

    @Override
    public Iterator<Carriage> iterator() {
        return carriages.iterator();
    }

    @Override
    public void forEach(Consumer<? super Carriage> action) {
        carriages.forEach(action);
    }
}
