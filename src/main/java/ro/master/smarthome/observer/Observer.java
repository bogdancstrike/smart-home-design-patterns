package ro.master.smarthome.observer;

import ro.master.smarthome.database.LogsRepository;
import ro.master.smarthome.model.SensorType;

public interface Observer {
    void notify(SensorType sensorType, String data);

    void notify(SensorType sensorType, String data, LogsRepository logsRepository);
}
