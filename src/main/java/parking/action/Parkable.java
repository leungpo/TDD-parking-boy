package parking.action;

import parking.object.Car;
import parking.object.Receipt;

public interface Parkable {

    public Receipt park(Car car);
}
