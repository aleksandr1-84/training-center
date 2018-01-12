package factory.model.volvo;

import factory.model.Brand;
import factory.model.Truck;

public class VolvoTruck implements Truck {
    private int maxCapacity=0;

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int value) {
        maxCapacity=value;
    }

    public Brand getBrand(){
        return Brand.Volvo;
    }
}
