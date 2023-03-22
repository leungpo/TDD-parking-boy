package parking;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class StandardParkingBoyTest {


    public static final String CAR_NAME = "CAR_NAME";
    public static final String PARKING_LOT_ONE = "parkingLotOne";
    public static final String PARKING_LOT_TWO = "parkingLotTwo";

    @Test
    public void test_given_car_when_park_then_the_car_is_parked(){
        //GIVEN
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy();
        Car car = new Car();
        car.setName(CAR_NAME);
        ParkingLot parkingLot = new ParkingLot();
        //WHEN
        Receipt receipt = standardParkingBoy.park(car, parkingLot);

        //THEN
        Assert.assertEquals(CAR_NAME, receipt.getCarName());
    }


    @Test
    public void should_return_receipt_when_park_car_given_multiple_parking_lot() {
        //given
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy();
        Car car = new Car();
        car.setName(CAR_NAME);
        List<ParkingLot> parkingLots = createMultipleParkingLots();
        //when
        Receipt receipt = standardParkingBoy.park(car, parkingLots);
        //then
        Assert.assertNotNull(receipt);
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
