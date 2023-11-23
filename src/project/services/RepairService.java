package project.services;

import project.cars.Car;

public class RepairService extends Service implements Repairing {
    @Override
    public void repair(Car car) {
        car.repair(work_done);
    }
}
