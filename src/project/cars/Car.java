package project.cars;

import project.cars.engines.Engine;

public abstract class Car {
    private Engine engine;
    private CarType type;
    private String model;
    public Car(Engine engine, CarType type, String model) {
        this.engine = engine;
        this.type = type;
        this.model = model;
    }
    public void print(){
        System.out.printf("%s has %d horse power\n", this.model, this.engine.getHorse_power());
    }
}
