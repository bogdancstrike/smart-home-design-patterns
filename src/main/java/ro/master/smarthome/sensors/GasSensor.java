package ro.master.smarthome.sensors;

import ro.master.smarthome.sensors.visitor.SensorVisitor;

public class GasSensor extends Sensor {
    double measured;

    public GasSensor(String ID) {
        this.ID = ID;
    }

    @Override
    public String acceptVisitor(SensorVisitor sensorVisitor) {
        return sensorVisitor.visit(this);
    }

    public void setMeasured(double measured) {
        this.measured = measured;
    }

    public double getMeasured() {
        return measured;
    }
}
