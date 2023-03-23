package parking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CoscoParkingStrategy extends AbstractParkingStrategy{


    private static List<ParkingLot> parkingLots;

    public CoscoParkingStrategy(List<ParkingLot> parkingLots) {
        super(parkingLots);
        this.parkingLots = parkingLots;
    }

    public Receipt park(Car car) {
        ParkingLot selectedParkingLot = parkingLots.stream()
                .max(Comparator.comparing(ParkingLot::getCapacity))
                .orElse(null);
        return ReceiptCreator.createReceipt(car,selectedParkingLot);
    }
}
