package ro.master.smarthome.command.gas;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Gas {
    public void on(){
        log.info("Gas was turned on!");
    }

    public void off(){
        log.info("Gas was turned off!");
    }
}
