package project.cars;

import project.cars.engines.Engine;
import project.services.Repairable;
import project.services.Service;
import project.services.Tunable;

public abstract class Car {
    private static final double broke_coefficient  = 0.001;
    protected static String name;
    private Engine engine;
    private final CarType type;
    private final String model;
    public Car(Engine engine, CarType type, String model) {
        setEngine(engine);
        this.type = type;
        this.model = model;
        setName();
    }
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    protected abstract void setName();
    public void tune(int power, int torque, Tunable service){
        service.tune(engine, power, torque);
    }
    public void repair(Repairable service){
        service.repair(engine);
    }
    public void broke(){
        engine.broke();
    }
    public double getQuality(){
        return engine.getQuality();
    }
}
