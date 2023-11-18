package ro.master.smarthome.sensors;

public interface SensorVisitor {
    String visit(GasSensor gasSensor);

    String visit(LightSensor lightSensor);

    String visit(ProximitySensor proximitySensor);

    String visit(TemperatureSensor temperatureSensor);
}
