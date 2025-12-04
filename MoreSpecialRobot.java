public class MoreSpecialRobot extends SpecialRobot {

    private int battery; // battery percentage 0–100

    // Constructor: name only
    public MoreSpecialRobot(String name) {
        super(name);
        this.battery = 100;
    }

    // Constructor: name + position + facing
    public MoreSpecialRobot(String name, int positionX, int positionY, int facing) {
        super(name, positionX, positionY, facing);
        this.battery = 100;
    }

    // Getter for battery
    public int getBattery() {
        return battery;
    }

    @Override
    public void move() {
        // If battery already empty, no movement
        if (battery <= 0) {
            return;
        }

        // Save old position to see if movement really happened
        int oldX = getPositionX();
        int oldY = getPositionY();

        // Use parent movement logic
        super.move();

        // Check if we actually moved (not blocked by negative coordinates)
        boolean moved = (getPositionX() != oldX) || (getPositionY() != oldY);

        if (moved) {
            battery--;
            if (battery < 0) {
                battery = 0;
            }
        }
    }

    @Override
    public String toString() {
        // Example: "Optimus, (5,0), EAST, Battery: 97%"
        return super.toString() + ", Battery: " + battery + "%";
    }
}
