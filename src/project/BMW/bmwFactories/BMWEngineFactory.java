package project.BMW.bmwFactories;

import project.cars.engines.Engine;
import project.BMW.bmwEngines.M40;
import project.BMW.bmwEngines.M54;
import project.factories.EngineFactory;

import java.io.File;
import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;

public class BMWEngineFactory extends EngineFactory {
    private static final String BMW_ENGINES_FILE_LOCATION = "./src/project/BMW/BMW_Engines";
    private static final String producer = "BMW Performance";
    private static final Map<String, Function<String, Engine>> engines = Map.of(
            "m40", (x) -> new M40(producer, x),
            "m54", (x) -> new M54(producer, x)
    );
    private static final Map<String, Map<String, Supplier<Engine>>> producedEngines = new HashMap<>();

    private void updateEngines(){
        File file = new File(BMW_ENGINES_FILE_LOCATION);
        try {
            Scanner scanner = new Scanner(file);
            while(scanner.hasNext()){
                List<String> list = Arrays.asList(scanner.nextLine().split(" "));
                String carName = list.get(0);
                String model = list.get(1);
                String engine = list.get(2);
                String type = list.get(3);
                producedEngines.computeIfAbsent(carName, k -> new HashMap<>());
                producedEngines.get(carName).put(model, () -> engines.get(engine).apply(type));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    protected BMWEngineFactory() {
        super(producer);
        updateEngines();
    }

    @Override
    public Engine buildEngine(String carName, String model){
        return producedEngines.get(carName).get(model).get();
    }
}

