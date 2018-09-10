package coupling07.facade.before;

public class DoorTimer {
    private Timer timer = new Timer();

    public void start(ElevatorController controller) {
        DoorTimerTask task = new DoorTimerTask(controller);
        timer.schedule(task, 1000);
    }

    public void stop() {
        timer.cancel();
    }
}

