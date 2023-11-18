package ro.master.smarthome.database;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import ro.master.smarthome.model.SensorType;

import java.io.Serializable;
import java.time.Instant;

@Entity
public class Log implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;

    private String data;
    private String sensor;
    private Instant timestamp;

    public Log() {
        // empty constructor required
    }

    public Log(String data, String sensorType) {
        this.data = data;
        this.sensor = sensorType;
        this.timestamp = Instant.now();
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long departmentId) {
        this.ID = departmentId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public String getSensor() {
        return sensor;
    }

    public void setSensor(String sensor) {
        this.sensor = sensor;
    }
}
