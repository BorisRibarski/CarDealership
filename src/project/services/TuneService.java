package project.services;

import project.cars.Car;

public class TuneService extends Service implements Tuning {
    @Override
    public void tune(Car car) {
        car.tune(work_done);
    }
}
