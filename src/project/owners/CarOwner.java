package project.owners;

import project.cars.Car;
import project.cars.CarType;
import project.dealerships.Dealership;

public class CarOwner {
    private Car car;
    private final String name;
    private int wallet;

    public CarOwner(String name) {
        this.name = name;
        wallet = 0;
    }

    public void work(int days){
        wallet += 100 * days;
    }

    public void buyCar(String name, CarType type, String model, Dealership dealership){
        this.car = dealership.sellCar(name, type, model);
    }

    @Override
    public String toString() {
        return "Name = '" + name +'\'';
    }
}
