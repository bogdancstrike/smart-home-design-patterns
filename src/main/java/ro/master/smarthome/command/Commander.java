package ro.master.smarthome.command;

public class Commander {
    private Commander() {
        // is not instantiable
    }

    public static void executeCommand(Command command) {
        command.execute();
    }
}
