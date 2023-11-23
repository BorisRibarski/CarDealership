package project.services;

import project.cars.Car;

import java.util.ArrayList;
import java.util.List;

public abstract class Service {
    private final List<Car> garage;
    protected Service(){
        garage = new ArrayList<>();
    }
    public void addCar(Car car){
        garage.add(car);
    }
    public void removeCar(Car car){
        garage.remove(car);
    }
}
