package parking;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ParkingManagerTest {
    public static final String CAR_NAME = "CAR_NAME";
    public static final String PARKING_LOT_ONE = "parkingLotOne";
    public static final String PARKING_LOT_TWO = "parkingLotTwo";

    @Test
    public void should_like_cosco_parking_boy_when_park_given_Monday() {
        //given
        int weekday = 1;
        ParkingManager parkingManager = new ParkingManager(weekday);
        Car car = new Car();
        car.setName(CAR_NAME);
        List<ParkingLot> parkingLots = createMultipleParkingLots();
        Receipt receipt = parkingManager.park(car, parkingLots);
        //then
        Assert.assertEquals(PARKING_LOT_ONE,receipt.getParkingLotName());

    }

    @Test
    public void should_like_oocl_parking_boy_when_park_given_Tuesday() {
        //given
        int weekday = 2;
        ParkingManager parkingManager = new ParkingManager(weekday);
        Car car = new Car();
        car.setName(CAR_NAME);
        List<ParkingLot> parkingLots = createMultipleParkingLots();
        Receipt receipt = parkingManager.park(car, parkingLots);
        //then
        Assert.assertEquals(PARKING_LOT_TWO,receipt.getParkingLotName());

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
