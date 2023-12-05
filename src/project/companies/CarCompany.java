package project.companies;

import project.cars.Car;
import project.cars.CarType;
import project.BMW.bmwFactories.BMWCarFactory;
import project.factories.CarFactory;

public class CarCompany {
    private CarFactory factory;

    public CarCompany(Companies company) {
        setFactory(company);
    }

    public Car produceCar(String name, String model, String engine_number, CarType type){
        if(factory == null){
            return null;
        }
        return factory.buildCar(name, model, type);
    }

    private void setFactory(Companies company) {
        this.factory = switch (company){
            case BMW -> new BMWCarFactory();
            case VOLKSWAGEN -> null;
        };
    }
}
