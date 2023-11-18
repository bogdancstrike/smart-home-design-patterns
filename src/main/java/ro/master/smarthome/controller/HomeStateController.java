package ro.master.smarthome.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ro.master.smarthome.state.HomeContext;
import ro.master.smarthome.state.NobodyHomeState;
import ro.master.smarthome.state.SomeBodyHomeState;

@Component
public class HomeStateController {
    /** in fiecare zi la ora 16 */
    @Scheduled(cron = "0 0 16 1/1 * ?")
    void updateArrival() {
        var homeContext = HomeContext.getInstance();

        SomeBodyHomeState state = new SomeBodyHomeState();
        state.doAction(homeContext);
    }

    /** in fiecare zi la ora 8 */
    @Scheduled(cron = "0 0 8 1/1 * ?")
    void updateDeparture() {
        var homeContext = HomeContext.getInstance();

        NobodyHomeState nobodyHomeState = new NobodyHomeState();
        nobodyHomeState.doAction(homeContext);
    }
}
