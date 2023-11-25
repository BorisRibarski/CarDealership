package project.cities;

import project.services.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class City {
    private final String name;
    private List<Service> services;

    public City(String name) {
        this.name = name;
        this.services = new ArrayList<>();
    }

    @Override
    public String toString() {
        return name;
    }
}
