package project.dealerships;

import project.cars.Car;
import project.cars.CarType;
import project.companies.CarCompany;
import project.owners.CarOwner;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private CarCompany company;
    private final List<Car> garage;

    public Dealership(CarCompany company) {
        this.company = company;
        this.garage = new ArrayList<>();
    }

    public void changeCompany(CarCompany company){
        this.company = company;
    }

    public Car sellCar(String name, CarType type, String model, CarOwner owner){
        Car selling = null;
        for(Car car : garage){
            if(car.equals(name, type, model)){
                garage.remove(car);
                selling = car;
                break;
            }
        }
        if(selling == null) {
            selling = this.company.produceCar(name, model, "", type);
        }
        if(owner.money() >= selling.getPrice()){
            return selling;
        }
        else {
            garage.add(selling);
            return null;
        }
    }
}
