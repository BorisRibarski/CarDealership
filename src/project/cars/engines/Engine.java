package project.cars.engines;

public abstract class Engine {
    private EngineType type;
    private int horse_power;
    private int torque;
    private int volume;
    private String producer;
    private final int max_hp;
    private final int max_torque;

    protected Engine(EngineType type, int horsePower, int torque, String producer, int maxHp, int maxTorque) {
        this.type = type;
        horse_power = horsePower;
        this.torque = torque;
        this.producer = producer;
        max_hp = maxHp;
        max_torque = maxTorque;
    }

    public int getHorse_power() {
        return horse_power;
    }

    public Engine(int maxHp, int maxTorque) {
        max_hp = maxHp;
        max_torque = maxTorque;
    }
}
