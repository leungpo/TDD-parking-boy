package parking;

import java.util.Comparator;
import java.util.List;

public class ParkingManager implements Parkable{

    AbstractParkingStrategy parkingStrategy;

    public ParkingManager (int weekDay){
        if (weekDay == 1){
            parkingStrategy = new OoclParkingStrategy();
        }else if (weekDay == 2){
            parkingStrategy = new CoscoParkingStrategy();
        }
    }

    @Override
    public Receipt park(Car car, ParkingLot parkingLot) {
        return ReceiptCreator.createReceipt(car,parkingLot);
    }
    public Receipt park(Car car, List<ParkingLot> parkingLots) {
        return parkingStrategy.park(car,parkingLots);
    }

}
