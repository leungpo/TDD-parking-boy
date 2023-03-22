package parking;

import java.util.HashMap;
import java.util.List;

public class StandardParkingBoy implements Parkable, Fetchable {
    @Override
    public Receipt park(Car car, ParkingLot parkingLot) {
        Receipt receipt = ReceiptCreator.createReceipt(car,parkingLot);
        parkingLot.getParkingCar().put(receipt, car);
        return receipt;
    }

    public Receipt park(Car car, List<ParkingLot> parkingLots) {
        ParkingLot selectedParkingLot = parkingLots.get(0);
        Receipt receipt = ReceiptCreator.createReceipt(car,selectedParkingLot);
        selectedParkingLot.getParkingCar().put(receipt, car);
        return receipt;
    }

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
