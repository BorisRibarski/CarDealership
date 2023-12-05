package project.cars;

import project.cars.engines.Engine;
import project.services.Repairable;
import project.services.Tunable;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public abstract class Car {
    protected static java.lang.String name;
    protected static Map<CarType, List<java.lang.String>> possibleTypes;
    private Engine engine;
    private final CarType type;
    private final java.lang.String model;
    protected static int price;
    private int millage;

    public Car(Engine engine, CarType type, java.lang.String model) {
        setEngine(engine);
        this.type = type;
        this.model = model;
        this.millage = 0;
        setName();
        setPrice();
    }

    public int getPrice() {
        return price;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
    public void drive(int distance, double brokeCoef){
        this.millage += distance;
        this.engine.broke(distance, brokeCoef);
    }

    public void tune(int power, int torque, Tunable service){
        service.tune(engine, power, torque);
    }

    public void repair(Repairable service){
        service.repair(engine);
    }

    public double getQuality(){
        return engine.getQuality();
    }

    protected abstract void setName();
    protected abstract void setPrice();

    @Override
    public java.lang.String toString() {
        return "Car{" +
                "engine=" + engine +
                ", model='" + model + '\'' +
                '}';
    }

    public boolean equals(java.lang.String carName, CarType type, java.lang.String model){
        return Objects.equals(carName, name) && type == this.type && Objects.equals(model, this.model);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car car)) return false;
        return Objects.equals(engine, car.engine) && type == car.type && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(engine, type, model);
    }
}
