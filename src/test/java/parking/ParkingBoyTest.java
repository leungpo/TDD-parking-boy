package parking;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoyTest {


    public static final String CAR_NAME = "CAR_NAME";
    public static final String PARKING_LOT_ONE = "parkingLotOne";
    public static final String PARKING_LOT_TWO = "parkingLotTwo";

    @Test
    public void test_given_car_when_park_then_the_car_is_parked(){
        //GIVEN
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        car.setName(CAR_NAME);

        //WHEN
        Receipt receipt = parkingBoy.park(car);

        //THEN
        Assert.assertEquals(CAR_NAME, receipt.getCarName());
    }


    @Test
    public void should_return_receipt_when_park_car_given_multiple_parking_lot() {
        //given
        List<ParkingLot> parkingLots = createMultipleParkingLots();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car car = new Car();
        car.setName(CAR_NAME);
        //when
        Receipt receipt = parkingBoy.park(car);
        //then
        Assert.assertNotNull(receipt);
    }

    @Test
    public void should_return_car_when_fetch_car_given_parking_lot() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        car.setName(CAR_NAME);
        Receipt receipt = parkingBoy.park(car);
        //when
        Car receivedCar = parkingBoy.fetch(receipt);
        //then
        Assert.assertEquals(car,receivedCar);
    }

    @Test
    public void should_return_car_when_fetch_car_given_multiple_parking_lot() {
        //given
        List<ParkingLot> parkingLots = createMultipleParkingLots();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car car = new Car();
        car.setName(CAR_NAME);
        Receipt receipt = parkingBoy.park(car);
        //when
        Car receivedCar = parkingBoy.fetch(receipt);
        //then
        Assert.assertEquals(car, receivedCar);
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
