package project.factories;

import project.cars.Car;
import project.cars.CarType;
import project.cars.E36;
import project.cars.E46;
import project.cars.engines.Engine;

public class BMWCarFactory extends CarFactory{
    public BMWCarFactory() {
        super("BMW Group");
    }

    private final static EngineFactory engineFactory = new BMWEngineFactory();
    @Override
    public Car buildCar(String name, String model, String engine_number, CarType type){
        Engine engine = engineFactory.buildEngine(engine_number);
        return switch (name){
            case "E46" -> new E46(engine, type, model);
            case "E36" -> new E36(engine, type, model);
            default -> null;
        };
    }
}
