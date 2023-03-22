package parking;

import java.util.List;

public class StandardFetchingStrategy extends AbstractFetchingStrategy{


    public Car fetch(Receipt receipt, ParkingLot parkingLot) {
        return parkingLot.getParkingCar().get(receipt);
    }

    public Car fetch(Receipt receipt, List<ParkingLot> parkingLots) {
        ParkingLot selectedParkingLot = parkingLots.stream()
                .filter(parkingLot -> parkingLot.getParkingCar().containsKey(receipt))
                .findFirst()
                .orElse(null);
        return selectedParkingLot.getParkingCar().get(receipt);
    }
}
