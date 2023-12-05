package project.factories;

import project.cars.Car;
import project.cars.CarType;

public abstract class CarFactory {
    private final String name;
    protected final EngineFactory engineFactory;

    protected CarFactory(String name, EngineFactory engineFactory) {
        this.name = name;
        this.engineFactory = engineFactory;
    }

    public String getName() {
        return name;
    }

    public abstract Car buildCar(String carName, String model, CarType type);
}
