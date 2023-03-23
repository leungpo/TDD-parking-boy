package parking;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class OoclParkingBoyTest {

    public static final String CAR_NAME = "CAR_NAME";
    public static final String PARKING_LOT_ONE = "parkingLotOne";
    public static final String PARKING_LOT_TWO = "parkingLotTwo";

    @Test
    public void should_return_car_in_less_available_space_parking_lot_when_park_car_given_oocl_parking_boy_and_multiple_parking_lot() {
        //given
        List<ParkingLot> parkingLots = createMultipleParkingLots();
        OoclParkingBoy ooclParkingBoy = new OoclParkingBoy(parkingLots);
        Car car = new Car();
        car.setName(CAR_NAME);
        //when
        Receipt receipt = ooclParkingBoy.park(car);
        //then
        Assert.assertEquals(PARKING_LOT_ONE,receipt.getParkingLotName());
    }

    private static List<ParkingLot> createMultipleParkingLots() {
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLotOne = new ParkingLot();
        parkingLotOne.setParkingLotName(PARKING_LOT_ONE);
        parkingLotOne.setCapacity(1);
        ParkingLot parkingLotTwo = new ParkingLot();
        parkingLotTwo.setParkingLotName(PARKING_LOT_TWO);
        parkingLotTwo.setCapacity(2);
        parkingLots.add(parkingLotOne);
        parkingLots.add(parkingLotTwo);
        return parkingLots;
    }
}
