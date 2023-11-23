package project.services;

import project.cars.Car;

import java.util.ArrayList;
import java.util.List;

public abstract class Service {
    private final List<Car> garage;
    protected final int work_done = 50;
    protected Service(){
        garage = new ArrayList<>();
    }
    public void addCar(Car car){
        if(car.notInService()) {
            garage.add(car);
            car.enterService(this);
        }
    }
    public void removeCar(Car car){
        if(garage.contains(car)) {
            garage.remove(car);
            car.leavesService();
        }
    }
}
