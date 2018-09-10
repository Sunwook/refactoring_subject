package coupling07.facade.before;

import java.util.TimerTask;

public class DoorTimerTask extends TimerTask {
    private ElevatorController controller;

    public DoorTimerTask(ElevatorController controller) {
        this.controller = controller;
    }

    public void run() {
        controller.doorTimeout();
    }
}

