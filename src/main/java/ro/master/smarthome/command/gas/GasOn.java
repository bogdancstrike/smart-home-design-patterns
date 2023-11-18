package ro.master.smarthome.command.gas;

import ro.master.smarthome.command.Command;

/** Command pattern */
public class GasOn implements Command {
    private Gas gas;

    public GasOn(Gas gas) {
        this.gas = gas;
    }

    @Override
    public void execute() {
        this.gas.on();
    }
}
