package project.cities;

import project.services.Repairable;
import project.services.Tunable;

import java.util.*;

public class CitiesMap {
    private final Set<Road> map;

    public CitiesMap() {
        this.map = new HashSet<>();
    }

    public String findNearestService(String city, Class<?> type){
        return findNearestService(findCity(city), type);
    }

    public String findNearestService(City currentCity, Class<?> type){
        List<City> citiesWithService = new ArrayList<>();
        for(City city : allCities()){
            if(city.doHaveServiceType(type)){
                citiesWithService.add(city);
            }
        }
        int distance = 0;
        City targetCity = citiesWithService.get(0);
        for(City city : citiesWithService){
            int currentDistance = findShortestDistance(currentCity, city);
            if(distance > currentDistance || distance == 0){
                distance = currentDistance;
                targetCity = city;
            }
        }
        return targetCity.toString();
    }

    public void addRoad(Road road){
        map.add(road);
        map.add(road.getOpposite());
    }

    public void addRoad(City start, City end, int distance){
        addRoad(new Road(start, end, distance));
    }

    public List<City> findShortestRoad(String start, String end){
        return findShortestRoad(findCity(start), findCity(end));
    }

    public double useRoad(List<City> cities){
        double broke = 0;
        for (int i = 0;i < cities.size()-1;i++){
            broke += Objects.requireNonNull(getRoad(cities.get(i), cities.get(i + 1))).use();
        }
        return broke;
    }

    public List<City> findShortestRoad(City start, City end){
        if(start == end) return Arrays.asList(start, end);
        List<City> visitedCities = new ArrayList<>();
        List<City> shortestWay = new ArrayList<>();
        List<List<City>> ways = findAllWays(start, end, visitedCities, new ArrayList<>());
        int distance = 0;
        for(List<City> cities : ways){
            if(calculateDistance(cities) < distance || distance == 0){
                distance = calculateDistance(cities);
                shortestWay = cities;
            }
        }
        return shortestWay;
    }

    public int findShortestDistance(String start, String end){
        return findShortestDistance(findCity(start), findCity(end));
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
                if(ways.size() == 1){
                    visitedCities.remove(end);
                    continue;
                }
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
        if(cities.size() == 2 && cities.get(0) == cities.get(1)) return 0;
        int distance = 0;
        for (int i = 0;i < cities.size()-1;i++){
            distance += Objects.requireNonNull(getRoad(cities.get(i), cities.get(i + 1))).getDistance();
        }
        return distance;
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
    public City findCity(String city){
        for (Road road : this.map){
            if(road.getStart().toString().equals(city)){
                return road.getStart();
            }
            if(road.getEnd().toString().equals(city)){
                return road.getEnd();
            }
        }
        return null;
    }

    private Set<City> allCities(){
        Set<City> cities = new HashSet<>();
        for (Road road : map){
            cities.add(road.getStart());
            cities.add(road.getEnd());
        }
        return cities;
    }
}
