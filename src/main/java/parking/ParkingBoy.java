package parking;

import java.util.List;

public class ParkingBoy implements Parkable{
    @Override
    public Receipt park(Car car, ParkingLot parkingLot) {
        return ReceiptCreator.createReceipt(car,parkingLot);
    }

    public Receipt park(Car car, List<ParkingLot> parkingLots) {
        ParkingLot selectedParkingLot = parkingLots.get(0);
        return ReceiptCreator.createReceipt(car,selectedParkingLot);
    }

}
