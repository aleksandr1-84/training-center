package factory.model.mersedes;

import factory.model.Brand;
import factory.model.Truck;

public class MersedesTruck implements Truck {
    private int maxCapacity=0;

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int value) {
        maxCapacity=value;
    }

    public Brand getBrand(){
        return Brand.Mersedes;
    }
}
