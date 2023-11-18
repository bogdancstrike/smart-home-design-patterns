package ro.master.smarthome.sensors;

import ro.master.smarthome.sensors.visitor.SensorVisitor;

public class LightSensor extends Sensor {
    double measured;

    public LightSensor(String ID) {
        this.ID = ID;
    }

    @Override
    public String acceptVisitor(SensorVisitor sensorVisitor) {
        return sensorVisitor.visit(this);
    }

    public double getMeasured() {
        return measured;
    }

    public String getID() {
        return ID;
    }

    public void setMeasured(double measured) {
        this.measured = measured;
    }
}
