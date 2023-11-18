package ro.master.smarthome.factory;

import ro.master.smarthome.model.SensorType;
import ro.master.smarthome.sensors.*;

import java.util.UUID;

public class SensorFactory extends Factory<SensorType> {
    @Override
    public Sensor getSensor(SensorType sensorType) {
        return switch (sensorType) {
            case GAS -> new GasSensor(generateId());
            case LIGHT -> new LightSensor(generateId());
            case PROXIMITY -> new ProximitySensor(generateId());
            case TEMPERATURE -> new TemperatureSensor(generateId());
            case HUMIDITY -> new HumiditySensor(generateId());
        };
    }

    private String generateId() {
        return UUID.randomUUID().toString();
    }
}
