package project.cars.engines;

public abstract class Engine {
    private final EngineType type;
    private int horse_power;
    private int torque;
    private final String producer;
    protected static int max_hp;
    protected static int max_torque;
    protected static String name;
    private String model;

    protected Engine(EngineType type, int horsePower, int torque,String producer, String model) {
        this.type = type;
        horse_power = horsePower;
        this.torque = torque;
        this.producer = producer;
        setSpecs();
        setModel(model);
    }
    protected abstract void setMax_hp();
    protected abstract void setMax_torque();
    protected abstract void setName();

    protected void setModel(String model) {
        this.model = model;
    }
    public String getEngineSpecs(){
        return name + model +
                " and has " + horse_power + "hp" +
                " and " + torque + "Nm" +
                " produced from " + producer;
    }
    public String getMaxOpportunities(){
        return horse_power + "hp and " +
                torque + "Nm";
    }
    protected void setSpecs(){
        setMax_hp();
        setMax_torque();
        setName();
    }
    public void tune(int tune){
        horse_power += tune;
        torque += tune;
        if(horse_power > max_hp){
            horse_power = max_hp;
        }
        if(torque > max_torque){
            torque = max_torque;
        }
    }
}
