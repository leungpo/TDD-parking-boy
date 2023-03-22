package parking;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class ParkingLotTest {

	public static final String CAR_NAME = "CAR_NAME";
	public static final String PARKING_LOT_ONE = "parkingLotOne";
	public static final String PARKING_LOT_TWO = "parkingLotTwo";

	@Test
	public void test_given_car_when_park_then_the_car_is_parked(){
		//GIVEN
		ParkingBoy parkingBoy = new ParkingBoy();
		Car car = new Car();
		car.setName(CAR_NAME);
		ParkingLot parkingLot = new ParkingLot();

		//WHEN
		Receipt receipt = parkingBoy.park(car, parkingLot);

		//THEN
		Assert.assertEquals(CAR_NAME, receipt.getCarName());
	}


	@Test
	public void should_return_receipt_when_park_car_given_multiple_parking_lot() {
	    //given
		ParkingBoy parkingBoy = new ParkingBoy();
		Car car = new Car();
		car.setName(CAR_NAME);
		List<ParkingLot> parkingLots = createMultipleParkingLots();
		//when
		Receipt receipt = parkingBoy.park(car, parkingLots);
	    //then
		Assert.assertNotNull(receipt);
	}

	@Test
	public void should_return_car_in_most_available_space_parking_lot_when_park_car_given_cosco_parking_boy_and_multiple_parking_lot() {
	    //given
		CoscoParkingBoy coscoparkingBoy = new CoscoParkingBoy();
		Car car = new Car();
		car.setName(CAR_NAME);
		List<ParkingLot> parkingLots = createMultipleParkingLots();
	    //when
		Receipt receipt = coscoparkingBoy.park(car, parkingLots);
	    //then
		Assert.assertEquals(PARKING_LOT_TWO,receipt.getParkingLotName());
	}

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
