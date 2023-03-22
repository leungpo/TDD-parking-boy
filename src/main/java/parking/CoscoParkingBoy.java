package parking;

import org.apache.commons.lang3.StringUtils;

import java.util.Comparator;
import java.util.List;

public class CoscoParkingBoy extends ParkingBoy{

    CoscoParkingStrategy coscoParkingStrategy = new CoscoParkingStrategy();

    @Override
    public Receipt park(Car car, ParkingLot parkingLot) {
        return coscoParkingStrategy.park(car, parkingLot);
    }
    @Override
    public Receipt park(Car car, List<ParkingLot> parkingLots) {
        return coscoParkingStrategy.park(car, parkingLots);
    }

}
