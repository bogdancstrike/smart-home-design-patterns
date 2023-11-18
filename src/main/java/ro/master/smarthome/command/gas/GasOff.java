package ro.master.smarthome.command.gas;

import ro.master.smarthome.command.Command;

/** Command pattern */
public class GasOff implements Command {
    private Gas gas;

    public GasOff(Gas gas) {
        this.gas = gas;
    }

    @Override
    public void execute() {
        this.gas.off();
    }
}
