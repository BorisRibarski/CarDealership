package project;

import project.cities.CitiesMap;
import project.cities.City;

public class Main {
    public static void main(String[] args) {
        City a = new City("А");
        City b = new City("B");
        City c = new City("C");
        City d = new City("D");
        City e = new City("E");
        City f = new City("F");
        City g = new City("G");
        City h = new City("H");
        City j = new City("J");
        City k = new City("K");
        City l = new City("L");
        City m = new City("M");

        CitiesMap map = new CitiesMap();
        map.addRoad(a, b, 10);
        map.addRoad(a, d, 10);
        map.addRoad(a, l, 60);
        map.addRoad(b, c, 90);
        map.addRoad(b, m, 20);
        map.addRoad(b, f, 30);
        map.addRoad(b, c, 90);
        map.addRoad(d, e, 30);
        map.addRoad(e, j, 70);
        map.addRoad(e, f, 80);
        map.addRoad(f, k, 30);
        map.addRoad(f, m, 40);
        map.addRoad(f, j, 40);
        map.addRoad(k, h, 50);
        map.addRoad(j, l, 50);
        map.addRoad(h, g, 20);
        map.addRoad(a, b, 10);
        System.out.println(map.findShortestRoad(d, h) + "=" + map.findShortestDistance(d, h));
    }
}