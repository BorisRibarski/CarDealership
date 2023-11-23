package project.cars.engines;

public class M40 extends Engine {
    public M40(String producer, String model) {
        super(EngineType.GASOLINE, producer, model);
    }
    @Override
    protected void setCode() {
        code = "m40";
    }
    @Override
    protected void setSpecs() {
        specs = new EngineSpecs(100, 100, 300, 200);
    }
}
