package parking;

import java.util.List;

public class StandardParkingStrategy extends AbstractParkingStrategy{


    public StandardParkingStrategy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    public Receipt park(Car car) {
        ParkingLot selectedParkingLot = parkingLots.get(0);
        Receipt receipt = ReceiptCreator.createReceipt(car,selectedParkingLot);
        selectedParkingLot.getParkingCar().put(receipt, car);
        return receipt;
    }

}
