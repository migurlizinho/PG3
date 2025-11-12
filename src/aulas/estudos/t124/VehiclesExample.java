package aulas.estudos.t124;

public class VehiclesExample {
    public static void main(String[] args){
        Train t1 = null;
        try {
            t1 = new Train("Alfa", new Locomotive("Diesel", 20, 400));
        t1.append(new Carriage(1, 54, 50));
        t1.append(new Carriage(2, 12, 50));
        t1.append(new Carriage(3, 83, 50));
        t1.append(new Carriage(4, 10, 50));
        } catch (VehicleException e) {
            System.out.println(e);
        }
        System.out.println(t1);
    }
}