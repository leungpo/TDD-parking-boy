package parking;

import org.junit.Assert;
import org.junit.Test;
import parking.object.Car;
import parking.object.ParkingLot;
import parking.object.Receipt;

import java.util.ArrayList;
import java.util.List;

public class ParkingManagerTest {
    public static final String CAR_NAME = "CAR_NAME";
    public static final String PARKING_LOT_ONE = "parkingLotOne";
    public static final String PARKING_LOT_TWO = "parkingLotTwo";

    @Test
    public void should_like_cosco_parking_boy_when_park_given_Monday() {
        //given & when
        int weekday = 1;
        Receipt receipt = createParkingProcess(weekday);
        //then
        Assert.assertEquals(PARKING_LOT_ONE,receipt.getParkingLotName());

    }

    @Test
    public void should_like_oocl_parking_boy_when_park_given_Tuesday() {
        //given & when
        int weekday = 2;
        Receipt receipt = createParkingProcess(weekday);
        //then
        Assert.assertEquals(PARKING_LOT_TWO,receipt.getParkingLotName());
    }

    private static List<ParkingLot> createMultipleParkingLots() {
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLotOne = new ParkingLot(1);
        parkingLotOne.setParkingLotName(PARKING_LOT_ONE);
        ParkingLot parkingLotTwo = new ParkingLot(2);
        parkingLotTwo.setParkingLotName(PARKING_LOT_TWO);
        parkingLots.add(parkingLotOne);
        parkingLots.add(parkingLotTwo);
        return parkingLots;
    }

    private static Receipt createParkingProcess(int weekday) {
        List<ParkingLot> parkingLots = createMultipleParkingLots();
        ParkingManager parkingManager = new ParkingManager(weekday, parkingLots);
        Car car = new Car();
        car.setName(CAR_NAME);
        Receipt receipt = parkingManager.park(car);
        return receipt;
    }
}
