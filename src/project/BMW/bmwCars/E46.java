package project.BMW.bmwCars;

import project.cars.Car;
import project.cars.CarType;
import project.cars.engines.Engine;

public class E46 extends Car {
    public E46(Engine engine, CarType type, String model) {
        super(engine, type, model);
    }

    @Override
    protected void setName() {
        name = "E46";
    }

    @Override
    protected void setPrice() {
        price = 15000;
    }
}
