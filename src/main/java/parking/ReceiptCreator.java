package parking;

import parking.object.Car;
import parking.object.ParkingLot;
import parking.object.Receipt;

public class ReceiptCreator {

    public static Receipt createReceipt(Car car, ParkingLot parkingLot) {
        Receipt receipt = new Receipt();
        receipt.setCarName(car.getName());
        receipt.setParkingLotName(parkingLot.getParkingLotName());
        return receipt;
    }
}
