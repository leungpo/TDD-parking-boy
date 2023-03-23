package parking.strategy.parking;

import parking.action.Parkable;
import parking.object.ParkingLot;

import java.util.List;

public abstract class AbstractParkingStrategy implements Parkable {

    protected List<ParkingLot> parkingLots;

    protected AbstractParkingStrategy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }
}
