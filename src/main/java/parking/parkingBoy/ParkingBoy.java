package parking.parkingBoy;

import parking.object.Car;
import parking.object.ParkingLot;
import parking.object.Receipt;
import parking.strategy.fetching.StandardFetchingStrategy;
import parking.strategy.parking.StandardParkingStrategy;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {

    protected List<ParkingLot> parkingLots;

    public ParkingBoy(ParkingLot parkingLot) {
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        this.parkingLots = parkingLots;
    }

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Receipt park(Car car) {
        StandardParkingStrategy standardParkingStrategy = new StandardParkingStrategy(parkingLots);
        return standardParkingStrategy.park(car);
    }

    public Car fetch(Receipt receipt) {
        StandardFetchingStrategy standardFetchingStrategy = new StandardFetchingStrategy(parkingLots);
        return standardFetchingStrategy.fetch(receipt);
    }
}
