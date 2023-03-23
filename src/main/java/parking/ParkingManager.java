package parking;

import parking.object.Car;
import parking.object.ParkingLot;
import parking.object.Receipt;
import parking.strategy.parking.AbstractParkingStrategy;
import parking.strategy.parking.CoscoParkingStrategy;
import parking.strategy.parking.OoclParkingStrategy;

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
