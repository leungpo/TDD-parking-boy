package parking.strategy.parking;

import parking.object.Car;
import parking.object.ParkingLot;
import parking.object.Receipt;
import parking.ReceiptCreator;

import java.util.Comparator;
import java.util.List;

public class OoclParkingStrategy extends AbstractParkingStrategy {

    private final List<ParkingLot> parkingLots;
    public OoclParkingStrategy(List<ParkingLot> parkingLots) {
        super(parkingLots);
        this.parkingLots = parkingLots;
    }

    @Override
    public Receipt park(Car car) {
        ParkingLot selectedParkingLot = parkingLots.stream()
                .min(Comparator.comparing(ParkingLot::getCapacity))
                .orElse(null);
        return ReceiptCreator.createReceipt(car,selectedParkingLot);
    }
}
