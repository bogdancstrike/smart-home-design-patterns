package ro.master.smarthome.model;

public class Message {
    private SensorType type;
    private String sensorId;
    private String data;

    public Message() {
    }

    public Message(SensorType type, String data) {
        this.type = type;
        this.data = data;
    }

    public Message(SensorType type, String sensorId, String data) {
        this.type = type;
        this.sensorId = sensorId;
        this.data = data;
    }

    public SensorType getType() {
        return type;
    }

    public String getData() {
        return data;
    }

    public void setType(SensorType type) {
        this.type = type;
    }

    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public void setData(String data) {
        this.data = data;
    }
}
