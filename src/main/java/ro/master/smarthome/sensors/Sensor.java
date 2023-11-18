package ro.master.smarthome.sensors;

import ro.master.smarthome.sensors.visitor.SensorVisitor;

public abstract class Sensor {
    protected String ID;
    protected InstalledRoom installedRoom;

    /** visitor pattern */
    public abstract String acceptVisitor(SensorVisitor sensorVisitor);

    /** getters */
    public String getID() {
        return ID;
    }

    public InstalledRoom getInstalledRoom() {
        return installedRoom;
    }

    public void installSensor(InstalledRoom installedRoom) {
        this.installedRoom = installedRoom;
    }
}
