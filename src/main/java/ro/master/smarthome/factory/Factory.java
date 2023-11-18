package ro.master.smarthome.factory;

import ro.master.smarthome.sensors.Sensor;

/** factory pattern */
public abstract class Factory<C> {
    public abstract Sensor getSensor(C message);
}
