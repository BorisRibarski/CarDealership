package project.factories;

import project.cars.engines.Engine;
import project.cars.engines.M40;
import project.cars.engines.M54;

import java.util.Map;
import java.util.function.Supplier;

public class BMWEngineFactory extends EngineFactory{
    private final static String producer = "BMW Performance";
    private static final Map<String, Supplier<Engine>> engines = Map.of(
            "m40b16", () -> new M40(producer, "b16"),
            "m40b19", () -> new M40(producer, "b19"),
            "m54b22", () -> new M54(producer, "b22"),
            "m54b25", () -> new M54(producer, "b25")
    );

    protected BMWEngineFactory() {
        super(producer);
    }

    @Override
    public Engine buildEngine(String engine_number){
        return engines.get(engine_number).get();
    }
}

