package project.cars.engines;

public class m40 extends Engine {
    public m40(int hp, int torque, String producer, String model){
        super(EngineType.GASOLINE, hp, torque,producer, 200, 300, model);
    }
    @Override
    protected void setMax_hp() {
        max_hp = 220;
    }

    @Override
    protected void setMax_torque() {
        max_torque = 300;
    }

    @Override
    protected void setName() {
        name = "m40";
    }
}
