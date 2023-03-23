package parking;

import org.apache.commons.lang3.StringUtils;

import java.util.Comparator;
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
