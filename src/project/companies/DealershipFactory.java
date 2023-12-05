package project.companies;

import project.dealerships.Dealership;

public class DealershipFactory {
    public static Dealership generateDealership(Companies company){
        return new Dealership(new CarCompany(company));
    }
}
