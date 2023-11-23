package project.services;

import project.cars.Car;
import project.cars.engines.Engine;

public class RepairService extends Service implements Repairable{
    @Override
    public void repair(Engine engine) {
        engine.repair();
    }
}
