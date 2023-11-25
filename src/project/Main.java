package project;

import project.cities.CitiesMap;
import project.cities.City;

public class Main {
    public static void main(String[] args) {
        City sofia = new City("Sofia");
        City plovdiv = new City("Plovdiv");
        City burgas = new City("Burgas");
        City tarnovo = new City("Tarnovo");
        CitiesMap map = new CitiesMap();
        map.addRoad(sofia, plovdiv, 130);
        map.addRoad(sofia, tarnovo, 150);
        map.addRoad(burgas, plovdiv, 300);
        map.addRoad(burgas, sofia, 400);
        map.addRoad(tarnovo, burgas, 100);
        System.out.println(map.find(sofia, burgas));
    }
}