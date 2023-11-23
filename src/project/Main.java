package project;

import project.cars.Car;
import project.cars.CarType;
import project.companies.CarCompany;
import project.companies.Companies;
import project.services.RepairService;
import project.services.Service;

public class Main {
    public static void main(String[] args) {
        CarCompany company = new CarCompany();
        company.setFactory(Companies.BMW);
        Car car1 = company.produceCar("E36", "318", "m40b19", CarType.COUPE);
        Car car2 = company.produceCar("E46", "320", "m54b22", CarType.COUPE);
        double left_km = car1.drive(64000);
        if(left_km > 0){
            System.out.printf("Left %.0fkm to drive\n", left_km);
        }
        System.out.println("Strength of car 1 is " + car1.getStrength() + "%");
        RepairService service = new RepairService();
        service.addCar(car1);
        service.repair(car1);
        System.out.println("Strength of car 1 is " + car1.getStrength() + "%");
    }
}