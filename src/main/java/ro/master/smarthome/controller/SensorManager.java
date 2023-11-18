package ro.master.smarthome.controller;

import org.springframework.stereotype.Component;
import ro.master.smarthome.factory.SensorFactory;
import ro.master.smarthome.model.SensorType;
import ro.master.smarthome.sensors.InstalledRoom;
import ro.master.smarthome.sensors.Sensor;
import ro.master.smarthome.sensors.visitor.SensorGatherDataVisitor;

import java.util.ArrayList;
import java.util.List;

@Component
public class SensorManager {
    List<Sensor> sensors = new ArrayList<>();

    public String addSensor(SensorType sensorType, InstalledRoom installedRoom) {
        SensorFactory sensorFactory = new SensorFactory();
        Sensor sensor = sensorFactory.getSensor(sensorType);
        sensor.installSensor(InstalledRoom.LIVING);
        sensors.add(sensor);
        return sensor.getID();
    }

    public Sensor getSensor(String id) {
        for (var sensor : sensors) {
            if (sensor.getID().equals(id))
                return sensor;
        }
        return null;
    }

    public String gatherData(String id) {
        for (var sensor : sensors) {
            if (sensor.getID().equals(id))
                return sensor.acceptVisitor(new SensorGatherDataVisitor());
        }
        return "";
    }

    public String gatherData() {
        StringBuilder builder = new StringBuilder();
        for (var sensor : sensors) {
                builder.append(sensor.acceptVisitor(new SensorGatherDataVisitor()))
                        .append("\n");
        }
        return builder.toString();
    }
}
