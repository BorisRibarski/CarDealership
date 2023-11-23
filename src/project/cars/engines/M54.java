package project.cars.engines;

public class M54 extends Engine{
    public M54(String producer, String model){
        super(EngineType.GASOLINE, producer, model);
    }
    @Override
    protected void setCode() {
        code = "m54";
    }
    @Override
    protected void setSpecs() {
        specs = new EngineSpecs(150,150,900, 900);
    }
}
