package project.cars;

import project.cars.engines.Engine;

public abstract class Car {
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
    public String getSpecs(){
        return name + " " + model + " " + type +
                " has an engine:\n\t" + engine.getEngineSpecs();
    }

    public String getOpportunities(){
        return name + " " + model + " " + type +
                " and engine can has " + engine.getMaxOpportunities();
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    protected abstract void setName();
}
