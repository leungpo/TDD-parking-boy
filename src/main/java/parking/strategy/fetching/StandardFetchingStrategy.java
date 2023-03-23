package parking.strategy.fetching;

import parking.object.Car;
import parking.exception.IncorrectReceiptException;
import parking.object.ParkingLot;
import parking.object.Receipt;

import java.util.List;

public class StandardFetchingStrategy extends AbstractFetchingStrategy {


    public StandardFetchingStrategy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    public Car fetch(Receipt receipt) {
        ParkingLot selectedParkingLot = parkingLots.stream()
                .filter(parkingLot -> parkingLot.getParkingCar().containsKey(receipt))
                .findFirst()
                .orElseThrow(IncorrectReceiptException::new);
        return selectedParkingLot.getParkingCar().get(receipt);
    }
}
