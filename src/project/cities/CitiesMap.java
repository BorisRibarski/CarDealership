package project.cities;

import java.util.*;

public class CitiesMap {
    private Set<Road> map;

    public CitiesMap() {
        this.map = new HashSet<>();
    }

    public void addRoad(Road road){
        map.add(road);
        map.add(road.getOpposite());
    }
    public void addRoad(City start, City end, int distance){
        addRoad(new Road(start, end, distance));
    }
    public int findShortestRoad(City start, City end){
        Set<City> visitedCities = new HashSet<>();
        visitedCities.add(start);
        return findDistance(start, end ,visitedCities, start);
    }

    private int findDistance(City start, City end, Set<City> visitedCities, City constStart){
        int distance = 0;
        int shortest = -1;
        for(Road road : map){
            if(road.getStart() == start){
                if (visitedCities.contains(road.getEnd())) {
                    continue;
                } else if (road.getEnd() == end) {
                    if (start != constStart){
                        return road.getDistance();
                    }
                    else if(shortest > road.getDistance() || shortest == -1){
                        shortest = road.getDistance();
                    }
                } else {
                    visitedCities.add(road.getEnd());
                    distance += findDistance(road.getEnd(), end, visitedCities, constStart);
                    distance += road.getDistance();
                    if(shortest > distance || shortest == -1){
                        shortest = distance;
                    }
                    distance = 0;
                }
            }
        }
        return shortest;
    }
}
