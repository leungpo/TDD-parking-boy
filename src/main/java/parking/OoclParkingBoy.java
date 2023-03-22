package parking;

import java.util.Comparator;
import java.util.List;

public class OoclParkingBoy{

    OoclParkingStrategy ooclParkingStrategy = new OoclParkingStrategy();

    public Receipt park(Car car, ParkingLot parkingLot) {
        return ooclParkingStrategy.park(car,parkingLot);
    }
    public Receipt park(Car car, List<ParkingLot> parkingLots) {
        return ooclParkingStrategy.park(car, parkingLots);
    }
}
