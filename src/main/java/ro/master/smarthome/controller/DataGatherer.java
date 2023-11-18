package ro.master.smarthome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ro.master.smarthome.database.LogsRepository;
import ro.master.smarthome.model.Message;
import ro.master.smarthome.model.SensorType;
import ro.master.smarthome.observer.*;

@Service
public class DataGatherer {

    /* Observers*/
    private Observer humidityObserver;
    private Observer proximityObserver;
    private Observer temperatureObserver;
    private Observer gasObserver;
    public Observer lightObserver;

    private LogsRepository logsRepository;

    public DataGatherer() {
        this.humidityObserver = new HumidityObserver();
        this.proximityObserver = new ProximityObserver();
        this.temperatureObserver = new TemperatureObserver();
        this.gasObserver = new GasObserver();
        this.lightObserver = new LightObserver();
    }

    public void getRawMessage(Message message) {
        var model = message;
        switch (model.getType()) {
            case HUMIDITY -> humidityObserver.notify(message.getType(), message.getData(), logsRepository);
            case PROXIMITY -> proximityObserver.notify(message.getType(), message.getData(), logsRepository);
            case TEMPERATURE -> temperatureObserver.notify(message.getType(), message.getData(), logsRepository);
            case GAS -> gasObserver.notify(message.getType(), message.getData(), logsRepository);
            case LIGHT -> lightObserver.notify(message.getType(), message.getData(), logsRepository);
        }
    }

    /**
     * la fiecare 5 secunde - simulare ca cineva este in casa
     */
    @Scheduled(fixedDelay = 5_000L)
    void simulateProximity() {
        getRawMessage(new Message(SensorType.PROXIMITY, "movement"));
    }

    /**
     * la fiecare 15 secunde - simulare ca exista scurgeri de gaze
     */
    @Scheduled(fixedDelay = 15_000L)
    void simulateGas() {
        getRawMessage(new Message(SensorType.GAS, "gas leaks"));
    }

    public Observer getHumidityObserver() {
        return humidityObserver;
    }

    public Observer getProximityObserver() {
        return proximityObserver;
    }

    public Observer getTemperatureObserver() {
        return temperatureObserver;
    }

    public Observer getGasObserver() {
        return gasObserver;
    }

    @Autowired
    public void setLogRepository(LogsRepository logsRepository) {
        this.logsRepository = logsRepository;
    }
}
