package ro.master.smarthome.state;

import lombok.extern.slf4j.Slf4j;
import ro.master.smarthome.command.Commander;
import ro.master.smarthome.command.gas.Gas;
import ro.master.smarthome.command.gas.GasOff;
import ro.master.smarthome.command.light.Light;
import ro.master.smarthome.command.light.LightOff;

@Slf4j
public class NobodyHomeState implements State {
    @Override
    public void doAction(HomeContext context) {
        log.info("Home is now in the {} state", this.getClass().getSimpleName());
        context.setState(this);

        Commander.executeCommand(new LightOff(new Light()));
        Commander.executeCommand(new GasOff(new Gas()));
    }
}
