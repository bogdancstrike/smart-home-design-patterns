package ro.master.smarthome.command.light;

import ro.master.smarthome.command.Command;

/** Command pattern */
public class LightOn implements Command {
    private Light light;

    public LightOn(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        this.light.on();
    }
}
