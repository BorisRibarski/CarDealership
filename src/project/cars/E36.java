package project.cars;

import project.cars.engines.Engine;

public class E36 extends Car{
    public E36(Engine engine, CarType type, String model) {
        super(engine, type, model);
    }

    @Override
    protected void setName() {
        name = "E36";
    }
}
