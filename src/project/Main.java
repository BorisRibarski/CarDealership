package project;

import project.cars.CarType;
import project.cities.CitiesMap;
import project.cities.City;
import project.companies.Companies;
import project.companies.DealershipFactory;
import project.companies.ServiceFactory;
import project.dealerships.Dealership;
import project.owners.CarOwner;


public class Main {
    public static void main(java.lang.String[] args){
        CarOwner owner = new CarOwner("William", "Sofia", createMap());
        owner.work(50);
        Dealership dealership = DealershipFactory.generateDealership(Companies.BMW);
        owner.buyCar("E46", CarType.COUPE, "325", dealership);
        owner.travel("Burgas");
        owner.travel("Sofia");
        System.out.println(owner.findDistance(owner.findNearestRepairService()));
    }
    private static CitiesMap createMap(){
        City sofia = new City("Sofia");
        City burgas = new City("Burgas");
        City plovdiv = new City("Plovdiv");
        City haskovo = new City("Haskovo");
        //sofia.addService(ServiceFactory.generateRepairService());
        sofia.addService(ServiceFactory.generateTuneService());
        burgas.addService(ServiceFactory.generateRepairService());
        plovdiv.addService(ServiceFactory.generateTuneService());
        CitiesMap map = new CitiesMap();
        map.addRoad(sofia, burgas, 400);
        map.addRoad(sofia, plovdiv, 130);
        map.addRoad(plovdiv, haskovo, 100);
        map.addRoad(plovdiv, burgas, 250);
        map.addRoad(sofia, haskovo, 260);
        return map;
    }
}