package parking;

import java.util.List;

public class StandardFetchingStrategy extends AbstractFetchingStrategy{


    protected StandardFetchingStrategy(List<ParkingLot> parkingLots) {
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
