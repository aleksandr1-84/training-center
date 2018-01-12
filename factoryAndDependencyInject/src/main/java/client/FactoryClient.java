package client;

import factory.*;
import factory.model.Car;
import factory.model.Truck;

public class FactoryClient {
    static Factory factory;
    static Truck truck;
    static Car car;

    private static void createVehicles(){
        truck = factory.createTruck();
        car = factory.createCar();
    }

    public static void main(String[] args){
        System.out.println("Creating Volvo vehicles...\n");
        factory = new VolvoFactory();
        createVehicles();
        System.out.println("Car{Brand: " + car.getBrand()+"}");
        System.out.println("Truck{Brand: " + truck.getBrand() + ", MaxCapacity: " + truck.getMaxCapacity() + " kg}");

        System.out.println("\nCreating Mersedes vehicles...\n");
        factory = new MersedesFactory();
        createVehicles();
        System.out.println("Car{Brand: " + car.getBrand()+"}");
        System.out.println("Truck{Brand: " + truck.getBrand() + ", MaxCapacity: " + truck.getMaxCapacity() + "kg}");
    }
}
