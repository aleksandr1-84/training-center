package factory;

import factory.model.Car;
import factory.model.Truck;
import factory.model.volvo.VolvoCar;
import factory.model.volvo.VolvoTruck;

public class VolvoFactory implements Factory {
    public Car createCar() {
        return new VolvoCar();
    }

    public Truck createTruck() {
        VolvoTruck truck = new VolvoTruck();
        truck.setMaxCapacity(15000);
        return truck;
    }
}
