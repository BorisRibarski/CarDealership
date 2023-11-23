package project;

import project.cars.Car;
import project.cars.CarType;
import project.companies.CarCompany;
import project.companies.Companies;

public class Main {
    public static void main(String[] args) {
        CarCompany company = new CarCompany();
        company.setFactory(Companies.BMW);
        Car car = company.produceCar("E46", "318", "m40b19", CarType.COUPE);
        System.out.println(car.getSpecs());
    }
}