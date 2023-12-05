package project.BMW.bmwEngines;

import project.cars.engines.Engine;
import project.cars.engines.EngineSpecs;
import project.cars.engines.EngineType;

public class M54 extends Engine {
    public M54(String producer, String volume){
        super(EngineType.GASOLINE, producer, volume);
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
