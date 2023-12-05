package project.BMW.bmwCars;

import project.cars.Car;
import project.cars.CarType;
import project.cars.engines.Engine;

public class E36 extends Car {
    public E36(Engine engine, CarType type, String model) {
        super(engine, type, model);
    }

    @Override
    protected void setName() {
        name = "E36";
    }

    @Override
    protected void setPrice() {
        price = 15000;
    }
}
