package project;

import project.cities.CitiesMap;
import project.cities.City;

public class Main {
    public static void main(String[] args) {
        City sofia = new City("Sofia");
        City plovdiv = new City("Plovdiv");
        City burgas = new City("Burgas");
        City tarnovo = new City("Tarnovo");
        City pernik = new City("Pernik");
        City haskovo = new City("Haskovo");
        CitiesMap map = new CitiesMap();
        map.addRoad(sofia, plovdiv, 130);
        map.addRoad(sofia, tarnovo, 150);
        map.addRoad(burgas, sofia, 400);
        map.addRoad(pernik, sofia, 50);
        map.addRoad(pernik, plovdiv, 70);
        map.addRoad(tarnovo, burgas, 100);
        map.addRoad(tarnovo, plovdiv, 40);
        map.addRoad(haskovo, plovdiv, 70);
        map.addRoad(haskovo, burgas, 200);
        System.out.println(map.findShortestRoad(sofia, burgas));
    }
}