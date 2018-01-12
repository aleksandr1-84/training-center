package factory;

import factory.model.Car;
import factory.model.Truck;

public interface Factory {
    Car createCar();
    Truck createTruck();
}
