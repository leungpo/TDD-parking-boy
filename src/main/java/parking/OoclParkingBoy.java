package parking;

import java.util.Comparator;
import java.util.List;

public class OoclParkingBoy implements Parkable{

    OoclParkingStrategy ooclParkingStrategy = new OoclParkingStrategy();
    @Override
    public Receipt park(Car car, ParkingLot parkingLot) {
        return ooclParkingStrategy.park(car,parkingLot);
    }
    public Receipt park(Car car, List<ParkingLot> parkingLots) {
        return ooclParkingStrategy.park(car, parkingLots);
    }
}
