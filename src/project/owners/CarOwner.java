package project.owners;

import project.cars.Car;
import project.cars.CarType;
import project.cities.CitiesMap;
import project.cities.City;
import project.dealerships.Dealership;
import project.services.Repairable;
import project.services.Tunable;

public class CarOwner {
    private CitiesMap map;
    private Car car;
    private String currentCity;
    private final java.lang.String name;
    private int wallet;

    public CarOwner(java.lang.String name, String city, CitiesMap map) {
        this.name = name;
        this.wallet = 10000;
        this.currentCity = city;
        this.map = map;
    }

    public void work(int days){
        wallet += 100 * days;
    }

    public void buyCar(java.lang.String name, CarType type, java.lang.String model, Dealership dealership){
        this.car = dealership.sellCar(name, type, model, this);
    }

    public Car getCar() {
        return car;
    }

    public int money() {
        return wallet;
    }

    public void travel(String city){
        int distance = map.findShortestDistance(this.currentCity, city);
        if(distance != 0){
            map.findShortestDistance(this.currentCity, city);
            double brokeCoef = map.useRoad(map.findShortestRoad(this.currentCity, city));
            this.currentCity = city;
            this.car.drive(distance, brokeCoef);
        }
    }

    public String findNearestTuneService(){
        return map.findNearestService(this.currentCity, Tunable.class);
    }

    public String findNearestRepairService(){
        return map.findNearestService(this.currentCity, Repairable.class);
    }

    public int findDistance(String city){
        return map.findShortestDistance(currentCity, city);
    }

    @Override
    public java.lang.String toString() {
        return "Name = '" + name +"' Car = '" + car + '\'';
    }
}
