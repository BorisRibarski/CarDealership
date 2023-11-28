package project.cars;

import project.cars.engines.Engine;
import project.services.Repairable;
import project.services.Service;
import project.services.Tunable;

import java.util.List;
import java.util.Map;

public abstract class Car {
    protected static String name;
    private Engine engine;
    private final CarType type;
    protected static Map<CarType, List<String>> possibleTypes;
    private final String model;
    public Car(Engine engine, CarType type, String model) {
        setEngine(engine);
        if(checkType(type)){
            this.type = type;
        } else {
            throw new IllegalArgumentException("Not comparable type");
        }
        if(checkModel(type, model)){
            this.model = model;
        } else {
            throw new IllegalArgumentException("Not comparable model to the type");
        }
        setName();
        setPossibleTypes();
    }
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    protected abstract void setName();
    protected abstract void setPossibleTypes();
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
    private boolean checkType(CarType type){
        return possibleTypes.containsKey(type);
    }
    private boolean checkModel(CarType type, String model){
        return possibleTypes.get(type).contains(model);
    }
}
