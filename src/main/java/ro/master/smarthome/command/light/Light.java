package ro.master.smarthome.command.light;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Light {
    public void on(){
        log.info("Light was turned on!");
    }

    public void off(){
        log.info("Light was turned off!");
    }
}
