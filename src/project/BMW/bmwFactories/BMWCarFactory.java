package project.BMW.bmwFactories;

import project.cars.Car;
import project.cars.CarType;
import project.BMW.bmwCars.E36;
import project.BMW.bmwCars.E46;
import project.cars.engines.Engine;
import project.factories.CarFactory;

public class BMWCarFactory extends CarFactory {
    public BMWCarFactory() {
        super("BMW Group",  new BMWEngineFactory());
    }

    @Override
    public Car buildCar(String carName, String model, CarType type){
        Engine engine = engineFactory.buildEngine(carName, model);
        return switch (carName){
            case "E46" -> new E46(engine, type, model);
            case "E36" -> new E36(engine, type, model);
            default -> null;
        };
    }
}
