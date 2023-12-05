package project.BMW.bmwEngines;

import project.cars.engines.Engine;
import project.cars.engines.EngineSpecs;
import project.cars.engines.EngineType;

public class M40 extends Engine {
    public M40(String producer, String volume) {
        super(EngineType.GASOLINE, producer, volume);
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
