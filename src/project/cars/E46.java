package project.cars;

import project.cars.engines.Engine;

public class E46 extends Car {
    public E46(Engine engine, CarType type, String model) {
        super(engine, type, model);
    }

    @Override
    protected void setName() {
        name = "E46";
    }
}
