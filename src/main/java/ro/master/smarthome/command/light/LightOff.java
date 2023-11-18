package ro.master.smarthome.command.light;

import ro.master.smarthome.command.Command;

/** Command pattern */
public class LightOff implements Command {
    private Light light;

    public LightOff(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        this.light.off();
    }
}
