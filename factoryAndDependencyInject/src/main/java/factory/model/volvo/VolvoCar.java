package factory.model.volvo;

import factory.model.Brand;
import factory.model.Car;

public class VolvoCar implements Car {
    public Brand getBrand(){
        return Brand.Volvo;
    }
}
