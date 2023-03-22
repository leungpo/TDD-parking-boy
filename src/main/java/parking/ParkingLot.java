package parking;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private String parkingLotName;
    private int capacity;

    private Map<Receipt, Car> parkedCar = new HashMap<>();

    public String getParkingLotName() {
        return parkingLotName;
    }

    public void setParkingLotName(String parkingLotName) {
        this.parkingLotName = parkingLotName;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public Map<Receipt, Car> getParkingCar() {
        return parkedCar;
    }
}
