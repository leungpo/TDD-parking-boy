package parking;

import java.util.List;

public class ParkingBoy{

    StandardParkingStrategy standardParkingStrategy = new StandardParkingStrategy();
    StandardFetchingStrategy standardFetchingStrategy = new StandardFetchingStrategy();
    public Receipt park(Car car, ParkingLot parkingLot) {
        return standardParkingStrategy.park(car, parkingLot);
    }

    public Receipt park(Car car, List<ParkingLot> parkingLots) {
        return standardParkingStrategy.park(car, parkingLots);
    }

    public Car fetch(Receipt receipt, ParkingLot parkingLot) {
        return standardFetchingStrategy.fetch(receipt, parkingLot);
    }

    public Car fetch(Receipt receipt, List<ParkingLot> parkingLots) {
        return standardFetchingStrategy.fetch(receipt, parkingLots);
    }
}
