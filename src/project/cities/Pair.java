package project.cities;

public class Pair{
    private final City city;
    private final int distance;

    public Pair(City city, int distance) {
        this.city = city;
        this.distance = distance;
    }

    public City getCity() {
        return city;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return city + " distance=" + distance;
    }
}
