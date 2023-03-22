package parking;

import java.util.Comparator;
import java.util.List;

public class CoscoParkingStrategy extends AbstractParkingStrategy{

    @Override
    public Receipt park(Car car, ParkingLot parkingLot) {
        return ReceiptCreator.createReceipt(car,parkingLot);
    }
    public Receipt park(Car car, List<ParkingLot> parkingLots) {
        ParkingLot selectedParkingLot = parkingLots.stream()
                .max(Comparator.comparing(ParkingLot::getCapacity))
                .orElse(null);
        return ReceiptCreator.createReceipt(car,selectedParkingLot);
    }
}
