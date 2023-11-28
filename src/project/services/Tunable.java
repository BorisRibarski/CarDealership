package project.services;

import project.cars.engines.Engine;

public interface Tunable {
    void tune(Engine engine, int morePower, int moreTorque);
}
