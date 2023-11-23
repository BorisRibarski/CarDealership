package project.factories;

import project.cars.engines.Engine;

public abstract class EngineFactory {
    private final String name;
    protected EngineFactory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract Engine buildEngine(String engine_number);
}
