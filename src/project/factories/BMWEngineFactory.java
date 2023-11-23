package project.factories;

import project.cars.engines.Engine;
import project.cars.engines.m40;
import project.cars.engines.m54;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class BMWEngineFactory extends EngineFactory{
    private final static String producer = "BMW Performance";
    private static final Map<String, Engine> map = Map.of(
        "m40b16", new m40(100, 100, producer, "b16"),
        "m40b19", new m40(120, 120, producer, "b19"),
        "m54b22", new m54(150, 170, producer, "b22"),
        "m54b25", new m54(170, 220, producer, "b25")
    );
    protected BMWEngineFactory() {
        super(producer);
    }

    @Override
    public Engine buildEngine(String engine_number){
        return map.get(engine_number);
    }
}
