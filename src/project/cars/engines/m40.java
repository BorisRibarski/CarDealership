package project.cars.engines;

public class m40 extends Engine {
    public m40(int maxHp, int maxTorque){
        super(maxHp, maxTorque);

    }
    protected m40(EngineType type, int horsePower, int torque, String producer, int maxHp, int maxTorque) {
        super(type, horsePower, torque, producer, maxHp, maxTorque);
    }
}
