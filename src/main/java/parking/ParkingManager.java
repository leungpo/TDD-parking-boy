package parking;

import java.util.ArrayList;
import java.util.List;

public class ParkingManager{

    protected List<ParkingLot> parkingLots;
    AbstractParkingStrategy parkingStrategy;

    public ParkingManager (int weekDay, List<ParkingLot> parkingLots){
        if (weekDay == 1){
            parkingStrategy = new OoclParkingStrategy(parkingLots);
        }else if (weekDay == 2){
            parkingStrategy = new CoscoParkingStrategy(parkingLots);
        }
        this.parkingLots = parkingLots;
    }

    public Receipt park(Car car) {
        return parkingStrategy.park(car);
    }

}
