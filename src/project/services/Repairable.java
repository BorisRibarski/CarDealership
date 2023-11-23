package project.services;

import project.cars.Car;
import project.cars.engines.Engine;

public interface Repairable {
    public void repair(Engine engine);
}
