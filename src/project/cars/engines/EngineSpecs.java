package project.cars.engines;

public class EngineSpecs {
    private final int maxPower;
    private final int maxTorque;
    private int power;
    private int torque;

    EngineSpecs(int power, int torque, int maxPower, int maxTorque){
        this.power = power;
        this.torque = torque;
        this.maxPower = maxPower;
        this.maxTorque = maxTorque;
    }
    public void tune(int morePower, int moreTorque){
        power += morePower;
        if(power > maxPower){
            power = maxPower;
        }
        torque += moreTorque;
        if(torque > maxTorque){
            torque = maxTorque;
        }
    }

    public int getPower() {
        return power;
    }

    public int getTorque() {
        return torque;
    }

    public int getMaxPower() {
        return maxPower;
    }

    public int getMaxTorque() {
        return maxTorque;
    }

    public String print(){
        return getPower() + "hp" +
                " and " + getTorque() + "Nm";
    }
}
