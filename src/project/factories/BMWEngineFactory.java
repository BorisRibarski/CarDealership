package project.factories;

import project.cars.engines.Engine;
import project.cars.engines.m40;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class BMWEngineFactory extends EngineFactory{
    private final static String producer = "BMW Performance";
    private static final Map<String, Engine> map = Map.of(
        "m40b16", new m40(100, 100, producer, "b16"),
        "m40b19", new m40(120, 120, producer, "b19")
    );
    protected BMWEngineFactory() {
        super(producer);
    }

    @Override
    public Engine buildEngine(String engine_number){
        return map.get(engine_number);
    }
}
