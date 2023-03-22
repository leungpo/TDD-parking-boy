package parking;

import java.util.List;

public interface Parkable {

    public Receipt park(Car car, ParkingLot parkingLot);
    public Receipt park(Car car, List<ParkingLot> parkingLots);
}
