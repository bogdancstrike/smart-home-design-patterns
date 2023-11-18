package ro.master.smarthome.sensors;

import com.google.gson.Gson;
import ro.master.smarthome.model.Message;
import ro.master.smarthome.model.MessageType;

public class SensorGatherDataVisitor implements SensorVisitor {
    private static final Gson GSON = new Gson();

    @Override
    public String visit(GasSensor gasSensor) {
        return GSON.toJson(new Message(MessageType.GAS, GSON.toJson(gasSensor)));
    }

    @Override
    public String visit(LightSensor lightSensor) {
        return GSON.toJson(new Message(MessageType.GAS, GSON.toJson(lightSensor)));
    }

    @Override
    public String visit(ProximitySensor proximitySensor) {
        return GSON.toJson(new Message(MessageType.GAS, GSON.toJson(proximitySensor)));
    }

    @Override
    public String visit(TemperatureSensor temperatureSensor) {
        return GSON.toJson(new Message(MessageType.GAS, GSON.toJson(temperatureSensor)));
    }

}
