package project.dealerships;

import project.cars.Car;
import project.cars.CarType;
import project.companies.CarCompany;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private CarCompany company;
    private List<Car> garage;
    public Dealership(CarCompany company) {
        this.company = company;
        this.garage = new ArrayList<>();
    }
    public void changeCompany(CarCompany company){
        this.company = company;
    }
    public Car sellCar(String name, CarType type, String model){
        return this.company.produceCar(name, model, "", type);
    }
}
