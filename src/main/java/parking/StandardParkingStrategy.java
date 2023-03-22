package parking;

import java.util.List;

public class StandardParkingStrategy extends AbstractParkingStrategy{

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

}
