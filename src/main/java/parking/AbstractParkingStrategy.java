package parking;

import java.util.List;

public abstract class AbstractParkingStrategy implements Parkable{

    protected List<ParkingLot> parkingLots;

    protected AbstractParkingStrategy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }
}
