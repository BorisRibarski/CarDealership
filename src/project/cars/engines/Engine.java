package project.cars.engines;

import project.services.Tunable;

public abstract class Engine {
    private final EngineType type;
    private final String producer;
    protected EngineSpecs specs;
    protected static String code;
    private String model;
    private double quality;

    protected Engine(EngineType type, String producer, String model) {
        this.type = type;
        this.producer = producer;
        setSpecs();
        setCode();
        setModel(model);
        quality = 100;
    }
    protected abstract void setCode();

    protected void setModel(String model) {
        this.model = model;
    }
    public String getEngineSpecs(){
        return code + model +
                " with " + specs.print() +
                " produced from " + producer;
    }
    public String getMaxOpportunities(){
        return specs.getMaxPower() + "hp and " +
                specs.getMaxTorque() + "Nm";
    }
    protected abstract void setSpecs();

    public void tune(int morePower, int moreTorque) {
        this.specs.tune(morePower, moreTorque);
    }

    public void repair(){
        quality = 100;
    }
    public void broke(){
        quality = 30;
    }

    public double getQuality() {
        return quality;
    }
}
