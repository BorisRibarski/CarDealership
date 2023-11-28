package project.cities;

import project.services.Repairable;
import project.services.Service;
import project.services.Tunable;
import project.services.TuneService;

import java.util.*;

public class City {
    private final String name;
    private final List<Service> services;

    public City(String name) {
        this.name = name;
        this.services = new ArrayList<>();
    }
    public void addService(Service service) {
        services.add(service);
    }

    public List<Service> getServices() {
        return services;
    }
    public boolean doHaveTuneService(){
        return doHaveServiceType(Tunable.class);
    }
    public boolean doHaveRepairService(){
        return doHaveServiceType(Repairable.class);
    }
    private boolean doHaveServiceType(Class<?> type){
        return serviceTypes().contains(type);
    }
    private Set<Class<?>> serviceTypes(){
        Set<Class<?>> interfaces = new HashSet<>();
        for(Service service : getServices()){
            interfaces.addAll(Arrays.asList(service.getClass().getInterfaces()));
        }
        return interfaces;
    }

    @Override
    public String toString() {
        return name;
    }
}
