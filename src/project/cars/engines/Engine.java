package project.cars.engines;

public abstract class Engine {
    protected static String code;
    protected EngineSpecs specs;
    private final EngineType type;
    private String model;
    private double quality;
    private final String producer;

    protected Engine(EngineType type, String producer, String model) {
        this.type = type;
        this.producer = producer;
        setSpecs();
        setCode();
        setModel(model);
        quality = 100;
    }

    public String getMaxOpportunities(){
        return specs.getMaxPower() + "hp and " +
                specs.getMaxTorque() + "Nm";
    }

    public String getEngineSpecs(){
        return code + model +
                " with " + specs.print() +
                " produced from " + producer;
    }

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
    protected abstract void setCode();
    protected abstract void setSpecs();
    protected void setModel(String model) {
        this.model = model;
    }
}
