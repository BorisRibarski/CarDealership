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
    public int find(City start, City end){
        Set<City> visitedCities = new HashSet<>();
        visitedCities.add(start);
        return findDistance(start, end ,visitedCities, start);
    }

    public int findDistance(City start, City end, Set<City> visitedCities, City constStart){
        int distance = 0;
        int shortest = -1;
        for(Road road : map){
            if(road.getStart() == start){
                System.out.print(road + " ");
                if (visitedCities.contains(road.getEnd())) {
                    System.out.println("Don't go back");
                    continue;
                } else if (road.getEnd() == end) {
                    System.out.println("Find end");
                    if(start == constStart){
                        if(shortest > road.getDistance()){
                            return shortest ;
                        }
                    }
                    return road.getDistance();
                } else {
                    System.out.println("driving");
                    visitedCities.add(road.getEnd());
                    distance += findDistance(road.getEnd(), end, visitedCities, constStart);
                    distance += road.getDistance();
                    System.out.println(distance + " " + shortest);
                    if(shortest > distance || shortest == -1){
                        shortest = distance;
                    }
                    distance = 0;
                }
            }
        }
        System.out.println("end  " + shortest);
        return shortest;
    }
}
