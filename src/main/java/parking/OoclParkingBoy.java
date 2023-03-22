package parking;

import java.util.Comparator;
import java.util.List;

public class OoclParkingBoy extends ParkingBoy{

    OoclParkingStrategy ooclParkingStrategy = new OoclParkingStrategy();
    @Override
    public Receipt park(Car car, ParkingLot parkingLot) {
        return ooclParkingStrategy.park(car,parkingLot);
    }
    @Override
    public Receipt park(Car car, List<ParkingLot> parkingLots) {
        return ooclParkingStrategy.park(car, parkingLots);
    }
}
