package factory;

import factory.model.Car;
import factory.model.Truck;
import factory.model.mersedes.MersedesCar;
import factory.model.mersedes.MersedesTruck;

public class MersedesFactory implements Factory {
    public Car createCar() {
        return new MersedesCar();
    }

    public Truck createTruck() {
        MersedesTruck truck = new MersedesTruck();
        truck.setMaxCapacity(10000);
        return truck;
    }
}
