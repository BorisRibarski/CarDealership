package project;

import project.cars.Car;
import project.cars.CarType;
import project.companies.CarCompany;
import project.companies.Companies;

public class Main {
    public static void main(String[] args) {
        CarCompany company = new CarCompany();
        company.setFactory(Companies.BMW);
        Car car = company.produceCar("E46", "m40b16", CarType.COUPE);
        car.print();
    }
}