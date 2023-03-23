package parking;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import parking.exception.IncorrectReceiptException;
import parking.exception.NoSeatException;
import parking.object.Car;
import parking.object.ParkingLot;
import parking.object.Receipt;
import parking.parkingBoy.ParkingBoy;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoyTest {


    public static final String CAR_NAME = "CAR_NAME";
    public static final String PARKING_LOT_ONE = "parkingLotOne";
    public static final String PARKING_LOT_TWO = "parkingLotTwo";

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();
    @Test
    public void test_given_car_when_park_then_the_car_is_parked(){
        //GIVEN
        ParkingLot parkingLot = new ParkingLot(1);
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
    public void should_return_noseatexception_when_park_car_given_parking_lot() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car1 = new Car();
        parkingBoy.park(car1);
        Car car2 = new Car();
        //when
        exceptionRule.expect(NoSeatException.class);
        exceptionRule.expectMessage("No Seat");
        parkingBoy.park(car2);
        //then

    }

    @Test
    public void should_return_incorrectReceiptException_when_fetch_car_given_incorrect_receipt() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        parkingBoy.park(car);
        //when
        Receipt fakeReceipt = new Receipt();
        //then
        exceptionRule.expect(IncorrectReceiptException.class);
        exceptionRule.expectMessage("Incorrect Receipt");
        parkingBoy.fetch(fakeReceipt);

    }

    @Test
    public void should_return_car_when_fetch_car_given_parking_lot() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
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
        ParkingLot parkingLotOne = new ParkingLot(1);
        parkingLotOne.setParkingLotName(PARKING_LOT_ONE);
        ParkingLot parkingLotTwo = new ParkingLot(2);
        parkingLotTwo.setParkingLotName(PARKING_LOT_TWO);
        parkingLots.add(parkingLotOne);
        parkingLots.add(parkingLotTwo);
        return parkingLots;
    }
}
