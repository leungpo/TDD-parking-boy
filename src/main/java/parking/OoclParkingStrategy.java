package parking;

import java.util.Comparator;
import java.util.List;

public class OoclParkingStrategy extends AbstractParkingStrategy{

    @Override
    public Receipt park(Car car, ParkingLot parkingLot) {
        return ReceiptCreator.createReceipt(car,parkingLot);
    }
    @Override
    public Receipt park(Car car, List<ParkingLot> parkingLots) {
        ParkingLot selectedParkingLot = parkingLots.stream()
                .min(Comparator.comparing(ParkingLot::getCapacity))
                .orElse(null);
        return ReceiptCreator.createReceipt(car,selectedParkingLot);
    }
}
