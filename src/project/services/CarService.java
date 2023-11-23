package project.services;

import project.cars.Car;

public class CarService extends Service implements Repairing, Tuning {
    @Override
    public void repair(Car car) {
        car.repair(work_done/2);
    }

    @Override
    public void tune(Car car) {
        car.tune(work_done/2);
    }
}
