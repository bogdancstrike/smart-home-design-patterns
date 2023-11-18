package ro.master.smarthome;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ro.master.smarthome.controller.SensorManager;
import ro.master.smarthome.model.SensorType;
import ro.master.smarthome.sensors.InstalledRoom;
import ro.master.smarthome.state.HomeContext;
import ro.master.smarthome.state.NobodyHomeState;

@SpringBootApplication
@Slf4j
public class SmartHomeApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SmartHomeApplication.class, args);
    }

    private SensorManager sensorManager;

    @Autowired
    public SmartHomeApplication(SensorManager sensorManager) {
        this.sensorManager = sensorManager;
    }

    @Override
    public void run(String... args) throws Exception {
        /**
         * singleton
         * */
        var homeContext = HomeContext.getInstance();

        NobodyHomeState nobodyHomeState = new NobodyHomeState();
        nobodyHomeState.doAction(homeContext);

        var lightSensor = sensorManager.addSensor(SensorType.LIGHT, InstalledRoom.LIVING);
        var proximitySensor = sensorManager.addSensor(SensorType.PROXIMITY, InstalledRoom.LIVING);
        var gasSensor = sensorManager.addSensor(SensorType.GAS, InstalledRoom.KITCHEN);

        log.info(sensorManager.gatherData());
    }
}
