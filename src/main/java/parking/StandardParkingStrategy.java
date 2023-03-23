package parking;

import java.util.List;

public class StandardParkingStrategy extends AbstractParkingStrategy{


    public StandardParkingStrategy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    public Receipt park(Car car) {
        ParkingLot selectedParkingLot = parkingLots
                .stream()
                .filter(parkingLot -> !parkingLot.isFull())
                .findFirst()
                .orElseThrow(NoSeatException::new);
        Receipt receipt = ReceiptCreator.createReceipt(car,selectedParkingLot);
        selectedParkingLot.getParkingCar().put(receipt, car);

        return receipt;
    }

}
