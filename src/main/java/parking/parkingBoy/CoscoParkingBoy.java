package parking.parkingBoy;

import parking.object.Car;
import parking.object.ParkingLot;
import parking.object.Receipt;
import parking.strategy.parking.CoscoParkingStrategy;

import java.util.List;

public class CoscoParkingBoy extends ParkingBoy{

    public CoscoParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public Receipt park(Car car) {
        CoscoParkingStrategy coscoParkingStrategy = new CoscoParkingStrategy(parkingLots);
        return coscoParkingStrategy.park(car);
    }

}
