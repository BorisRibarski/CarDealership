package project.cars;

import project.cars.engines.Engine;
import project.services.Service;

public abstract class Car {
    private static final double broke_coefficient  = 0.001;
    protected static String name;
    private Engine engine;
    private final CarType type;
    private final String model;
    private double strength;
    private int mileage;
    private boolean broken;
    private Service service;
    public Car(Engine engine, CarType type, String model) {
        setEngine(engine);
        this.type = type;
        this.model = model;
        setName();
        strength = 100;
        mileage = 0;
        service = null;
        broken = false;
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
    private boolean isBroken(){
        return broken;
    }
    private boolean isNotBroken(){
        return !broken;
    }
    private void broke(){
        broken = true;
    }

    public double drive(int km){
        if(notInService()) {
            if (isNotBroken()) {
                this.mileage += km;
                this.strength -= km * broke_coefficient;
            }
            if (strength < 0) {
                broke();
                double left_km = -strength / broke_coefficient;
                strength = 0;
                return left_km;
            } else return 0;
        }
        else return -1;
    }
    public void enterService(Service service){
        this.service = service;
    }
    public void leavesService(){
        this.service = null;
    }
    public Service getService(){
        return this.service;
    }
    public boolean inService(){
        return service != null;
    }
    public boolean notInService(){
        return service == null;
    }
    public void repair(int repair){
        if(inService()){
            if(strength > 0){
                strength += repair;
                if(strength > 100){
                    strength = 100;
                }
            }// else the car is documented as total damage
        }
    }
    public void tune(int tune){
        if(isNotBroken() && strength > 50) {
            engine.tune(tune);
        }
    }

    public double getStrength() {
        return strength;
    }
}
