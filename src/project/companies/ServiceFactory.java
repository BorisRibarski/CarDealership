package project.companies;

import project.services.RepairService;
import project.services.Service;
import project.services.TuneService;

public class ServiceFactory {
    public static Service generateTuneService(){
        return new TuneService();
    }
    public static Service generateRepairService(){
        return new RepairService();
    }
}
