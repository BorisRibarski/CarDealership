package project.cities;

import java.util.*;

public class CitiesMap {
    private final Set<Road> map;

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
        List<City> shortestWay = new ArrayList<>();
        List<List<City>> ways = findAllWays(start, end, visitedCities, new ArrayList<>());
        int distance = 0;
        for(List<City> cities : ways){
            if(calculateDistance(cities) < distance || distance == -1){
                distance = calculateDistance(cities);
                shortestWay = cities;
            }
        }
        return shortestWay;
    }
    public int findShortestDistance(City start, City end){
        return calculateDistance(findShortestRoad(start, end));
    }
    private List<List<City>> findAllWays(City start, City end, List<City> visitedCities, List<List<City>> ways){
        visitedCities.add(start);
        for(City city : getSurroundingCities(start)){
            if(city == end){
                visitedCities.add(end);
                ways.add(visitedCities);
                break;
            }
            if(!visitedCities.contains(city)){
                findAllWays(city, end, new ArrayList<>(visitedCities), ways);
            }
        }
        return ways;
    }
    private Road getRoad(City start, City end){
        for(Road road : map){
            if(road.getStart() == start && road.getEnd() == end){
                return road;
            }
        }
        return null;
    }
    private int calculateDistance(List<City> cities){
        int distance = 0;
        for (int i = 0;i < cities.size()-1;i++){
            distance += getRoad(cities.get(i), cities.get(i+1)).getDistance();
        }
        return distance;
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
}
