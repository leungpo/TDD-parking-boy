package parking;

public class ReceiptCreator {

    public static Receipt createReceipt(Car car, ParkingLot parkingLot) {
        Receipt receipt = new Receipt();
        receipt.setCarName(car.getName());
        receipt.setParkingLotName(parkingLot.getParkingLotName());
        return receipt;
    }
}
