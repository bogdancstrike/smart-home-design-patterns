package ro.master.smarthome.factory;

import com.google.gson.Gson;
import ro.master.smarthome.model.Message;
import ro.master.smarthome.sensors.*;

public class MessageFactory extends Factory<String> {
    @Override
    public Sensor getSensor(String rawMessage) {
        final var gson = new Gson();
        var message = gson.fromJson(rawMessage, Message.class);
        Sensor sensor = null;
        switch (message.getType()) {
            case HUMIDITY -> sensor = gson.fromJson(message.getData(), HumiditySensor.class);
            case GAS -> sensor = gson.fromJson(message.getData(), GasSensor.class);
            case LIGHT -> sensor = gson.fromJson(message.getData(), LightSensor.class);
            case PROXIMITY -> sensor = gson.fromJson(message.getData(), ProximitySensor.class);
            case TEMPERATURE -> sensor = gson.fromJson(message.getData(), TemperatureSensor.class);
        }
        return sensor;
    }
}
