package ro.master.smarthome.state;

public class HomeContext {
    private static HomeContext INSTANCE;
    private State state;

    private HomeContext() {
        // this class is Singleton
    }

    public static HomeContext getInstance() {
        if (INSTANCE == null)
            INSTANCE = new HomeContext();
        return INSTANCE;
    }

    public State getState() {
        return state;
    }

    void setState(State state) {
        this.state = state;
    }
}
