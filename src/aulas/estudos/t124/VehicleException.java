package aulas.estudos.t124;

public class VehicleException extends Exception {
    private final Vehicle vehicle;

    public VehicleException(String message) {
        super(message);
        this.vehicle = null;
    }

    public VehicleException(String message, Vehicle vehicle) {
        super("\"" + vehicle.getIdentifier() + "\" " + message);
        this.vehicle = vehicle;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}