package project.services;

import project.cars.Car;
import project.cars.engines.Engine;

public interface Tunable {
    public void tune(Engine engine, int morePower, int moreTorque);
}
