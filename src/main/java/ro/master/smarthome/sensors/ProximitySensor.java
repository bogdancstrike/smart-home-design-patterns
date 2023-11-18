package ro.master.smarthome.sensors;

import ro.master.smarthome.sensors.visitor.SensorVisitor;

public class ProximitySensor extends Sensor {
    boolean detectedMovement;

    public ProximitySensor(String ID) {
        this.ID = ID;
    }

    @Override
    public String acceptVisitor(SensorVisitor sensorVisitor) {
        return sensorVisitor.visit(this);
    }

    public boolean isDetectedMovement() {
        return detectedMovement;
    }

    public void setDetectedMovement(boolean detectedMovement) {
        this.detectedMovement = detectedMovement;
    }

    public String getID() {
        return ID;
    }
}
