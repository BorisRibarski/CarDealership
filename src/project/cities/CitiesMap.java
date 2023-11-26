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
    public List<City> findShortestRoad(City start, City end){
        List<City> visitedCities = new ArrayList<>();
        findAllWays(start, visitedCities);
        return null;
    }
    private List<City> findAllWays(City start, List<City> visitedCities){
        visitedCities.add(start);
        for(City city : getSurroundingCities(start)){
            if(!visitedCities.contains(city)){
                System.out.println(findAllWays(city, new ArrayList<>(visitedCities)));
            }
        }
        return visitedCities;
    }
    private List<Road>  getCityRoad(City city){
        List<Road> roads = new ArrayList<>();
        for(Road road : map){
            if(road.getStart() == city){
                roads.add(road);
            }
        }
        return roads;
    }
    private Set<City> getAllCities(){
        Set<City> cities = new HashSet<>();
        for (Road road : map){
            cities.add(road.getStart());
            cities.add(road.getEnd());
        }
        return cities;
    }
    private Set<City> getSurroundingCities(City city){
        Set<City> cities = new HashSet<>();
        for (Road road : map){
            if(road.getStart() == city){
                cities.add(road.getEnd());
            }
        }
        return cities;
    }
    /*
    private int findDistance(City start, City end, Set<City> visitedCities, City constStart, List<City> roadCities){
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
                    distance += findDistance(road.getEnd(), end, new HashSet<>(visitedCities), constStart, roadCities);
                    distance += road.getDistance();
                    if(shortest > distance || shortest == -1){
                        shortest = distance;
                    }
                    distance = 0;
                }
            }
        }
        return shortest;
    }*/
}
