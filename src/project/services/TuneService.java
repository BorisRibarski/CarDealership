package project.services;

import project.cars.engines.Engine;

public class TuneService extends Service implements Tunable{
    public void tune(Engine engine, int power, int torque){
        engine.tune(power, torque);
    }
}
