package ro.master.smarthome.sensors.visitor;

import com.google.gson.Gson;
import ro.master.smarthome.model.Message;
import ro.master.smarthome.model.SensorType;
import ro.master.smarthome.sensors.*;

public class SensorGatherDataVisitor implements SensorVisitor {
    private static final Gson GSON = new Gson();

    @Override
    public String visit(GasSensor gasSensor) {
        return GSON.toJson(new Message(SensorType.GAS, GSON.toJson(gasSensor)));
    }

    @Override
    public String visit(LightSensor lightSensor) {
        return GSON.toJson(new Message(SensorType.LIGHT, GSON.toJson(lightSensor)));
    }

    @Override
    public String visit(ProximitySensor proximitySensor) {
        return GSON.toJson(new Message(SensorType.PROXIMITY, GSON.toJson(proximitySensor)));
    }

    @Override
    public String visit(TemperatureSensor temperatureSensor) {
        return GSON.toJson(new Message(SensorType.TEMPERATURE, GSON.toJson(temperatureSensor)));
    }

    @Override
    public String visit(HumiditySensor humiditySensor) {
        return GSON.toJson(new Message(SensorType.HUMIDITY, GSON.toJson(humiditySensor)));
    }

}
