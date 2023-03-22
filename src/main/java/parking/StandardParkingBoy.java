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
        return ReceiptCreator.createReceipt(car,selectedParkingLot);
    }

    public Car fetch(Receipt receipt, ParkingLot parkingLot) {
        return parkingLot.getParkingCar().get(receipt);
    }
}
