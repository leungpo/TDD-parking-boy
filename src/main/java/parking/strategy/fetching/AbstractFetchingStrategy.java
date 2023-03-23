package parking.strategy.fetching;

import parking.action.Fetchable;
import parking.object.ParkingLot;

import java.util.List;

public abstract class AbstractFetchingStrategy implements Fetchable {
    protected List<ParkingLot> parkingLots;

    protected AbstractFetchingStrategy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

}
