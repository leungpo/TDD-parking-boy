package parking;

import java.util.List;

public abstract class AbstractFetchingStrategy implements Fetchable{
    protected List<ParkingLot> parkingLots;

    protected AbstractFetchingStrategy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

}
