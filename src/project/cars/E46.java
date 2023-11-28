package project.cars;

import project.cars.engines.Engine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class E46 extends Car {
    public E46(Engine engine, CarType type, String model) {
        super(engine, type, model);
    }

    @Override
    protected void setName() {
        name = "E46";
    }
    @Override
    protected void setPossibleTypes() {
        possibleTypes = Map.of(
                CarType.HATCHBACK, Arrays.asList("316", "318"),
                CarType.SEDAN, Arrays.asList("320", "330")
        );
    }
}
