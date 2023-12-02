package strategy;


public class ParkingFactory {
    public static ParkingStrategy getParkingStrategy(){
        return new DefaultParkingStrategy();

    }
}
