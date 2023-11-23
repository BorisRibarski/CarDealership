package project;

import project.cars.Car;
import project.cars.CarType;
import project.companies.CarCompany;
import project.companies.Companies;
import project.services.RepairService;
import project.services.Service;
import project.services.Tunable;
import project.services.TuneService;

public class Main {
    public static void main(String[] args) {
        CarCompany company = new CarCompany();
        company.setFactory(Companies.BMW);
        Car car1 = company.produceCar("E36", "318", "m40b16", CarType.COUPE);
        RepairService service = new RepairService();
    }
}