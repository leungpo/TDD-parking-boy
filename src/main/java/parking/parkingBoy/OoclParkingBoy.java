package parking.parkingBoy;

import parking.object.Car;
import parking.object.ParkingLot;
import parking.object.Receipt;
import parking.strategy.parking.OoclParkingStrategy;

import java.util.List;

public class OoclParkingBoy extends ParkingBoy{

    public OoclParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public Receipt park(Car car) {
        OoclParkingStrategy ooclParkingStrategy = new OoclParkingStrategy(parkingLots);
        return ooclParkingStrategy.park(car);
    }
}
