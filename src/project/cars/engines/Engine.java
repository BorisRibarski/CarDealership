package project.cars.engines;

public abstract class Engine {
    private EngineType type;
    private int horse_power;
    private int torque;
    private int volume;
    private String producer;
    protected static int max_hp;
    protected static int max_torque;
    protected static String name;
    private String model;

    protected Engine(EngineType type, int horsePower, int torque,String producer, int maxHp, int maxTorque, String model) {
        this.type = type;
        horse_power = horsePower;
        this.torque = torque;
        this.producer = producer;
        setSpecs();
        setModel(model);
    }

    public int getHorse_power() {
        return horse_power;
    }

    public int getTorque() {
        return torque;
    }

    public Engine(int maxHp, int maxTorque) {
        max_hp = maxHp;
        max_torque = maxTorque;
    }
    protected abstract void setMax_hp();
    protected abstract void setMax_torque();
    protected abstract void setName();

    protected void setModel(String model) {
        this.model = model;
    }

    public int getMax_hp(){
        return max_hp;
    }
    public int getMax_torque(){
        return max_torque;
    }
    public String getEngineSpecs(){
        return name + model +
                " and has " + horse_power + "hp" +
                " and " + torque + "Nm" +
                " produced from " + producer;
    }
    protected void setSpecs(){
        setMax_hp();
        setMax_torque();
        setName();
    }
}
