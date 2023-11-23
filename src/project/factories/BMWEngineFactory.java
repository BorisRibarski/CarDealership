package project.factories;

import project.cars.engines.Engine;
import project.cars.engines.m40;

public class BMWEngineFactory extends EngineFactory{
    protected BMWEngineFactory() {
        super("BMW Performance");
    }

    @Override
    public Engine buildEngine(String engine_number){
        return switch (engine_number) {
            case "m40b16" -> new m40(100, 100);
            case "m40b18" -> new m40(80,80);
            default -> null;
        };
    }
}
