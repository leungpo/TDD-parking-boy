package parking.action;

import parking.object.Car;
import parking.object.Receipt;

public interface Fetchable {

    public Car fetch(Receipt receipt);
}
