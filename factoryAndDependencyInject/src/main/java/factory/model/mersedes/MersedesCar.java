package factory.model.mersedes;

import factory.model.Brand;
import factory.model.Car;

public class MersedesCar implements Car {

    public Brand getBrand(){
        return Brand.Mersedes;
    }
}
