package project;

import project.cars.Car;
import project.cars.CarType;
import project.companies.CarCompany;
import project.companies.Companies;

public class Main {
    public static void main(String[] args) {
        CarCompany company = new CarCompany();
        company.setFactory(Companies.BMW);
        Car car1 = company.produceCar("E36", "318", "m40b19", CarType.COUPE);
        Car car2 = company.produceCar("E46", "320", "m54b22", CarType.COUPE);
        System.out.println(car1.getSpecs());
        System.out.println(car2.getOpportunities());
    }
}