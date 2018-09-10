package coupling07.facade.before;

public class ElevatorDoor implements IDoor {
    public void open() { System.out.println("Elevator Door Open") ; }
    public void close() { System.out.println("Elevator Door Close") ; }
}
