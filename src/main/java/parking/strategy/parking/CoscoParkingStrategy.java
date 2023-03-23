package parking.strategy.parking;

import parking.object.Car;
import parking.object.ParkingLot;
import parking.object.Receipt;
import parking.ReceiptCreator;

import java.util.Comparator;
import java.util.List;

public class CoscoParkingStrategy extends AbstractParkingStrategy {


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
