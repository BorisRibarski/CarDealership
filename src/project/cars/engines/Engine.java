package project.cars.engines;

public abstract class Engine {
    protected static String code;
    protected EngineSpecs specs;
    private final EngineType type;
    private String volume;
    private double quality;
    private final String producer;

    protected Engine(EngineType type, String producer, String volume) {
        this.type = type;
        this.producer = producer;
        setSpecs();
        setCode();
        setVolume(volume);
        quality = 100;
    }

    public void tune(int morePower, int moreTorque) {
        this.specs.tune(morePower, moreTorque);
    }

    public void repair(){
        quality = 100;
    }

    public void broke(int km, double coef){
        quality -= km*coef/10;
    }

    public double getQuality() {
        return quality;
    }
    protected abstract void setCode();
    protected abstract void setSpecs();
    protected void setVolume(String volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "specs=" + specs +
                ", type=" + type +
                ", volume='" + volume + '\'' +
                '}';
    }
}
