package project.cities;

import java.util.Objects;

public class Road {
    private final City start;
    private final City end;
    private final int distance;

    public Road(City start, City end, int distance) {
        this.start = start;
        this.end = end;
        this.distance = distance;
    }
    public Road getOpposite(){
        return new Road(end, start, distance);
    }

    @Override
    public String toString() {
        return "Road{" + start + " - " + end + ", distance=" + distance + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Road road = (Road) o;
        return distance == road.distance && Objects.equals(start, road.start) && Objects.equals(end, road.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end, distance);
    }

    public City getStart() {
        return start;
    }

    public City getEnd() {
        return end;
    }

    public int getDistance() {
        return distance;
    }
}
