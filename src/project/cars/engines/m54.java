package project.cars.engines;

public class m54 extends Engine{
    public m54(int hp, int torque, String producer, String model){
        super(EngineType.GASOLINE, hp, torque,producer, model);
    }
    @Override
    protected void setMax_hp() {
        max_hp = 300;
    }

    @Override
    protected void setMax_torque() {
        max_torque = 400;
    }

    @Override
    protected void setName() {
        name = "m54";
    }
}
