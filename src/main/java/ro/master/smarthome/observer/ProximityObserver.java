package ro.master.smarthome.observer;

import lombok.extern.slf4j.Slf4j;
import ro.master.smarthome.database.Log;
import ro.master.smarthome.database.LogsRepository;
import ro.master.smarthome.model.SensorType;

/** Observer */
@Slf4j
public class ProximityObserver implements Observer {
    @Override
    public void notify(SensorType sensorType, String data) {
        log.info("{} got data: {}", this.getClass().getSimpleName(), data);
    }


    @Override
    public void notify(SensorType sensorType, String data, LogsRepository logsRepository) {
        logsRepository.save(new Log(data, sensorType.toString()));
        log.info("{} got data: {}", this.getClass().getSimpleName(), data);
    }
}
