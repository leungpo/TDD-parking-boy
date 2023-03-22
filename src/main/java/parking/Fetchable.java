package parking;

public interface Fetchable {

    public Car fetch(Receipt receipt, ParkingLot parkingLot);
}
