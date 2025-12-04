public class Robot {

    public static final int NORTH = 1;
    public static final int EAST  = 2;
    public static final int SOUTH = 3;
    public static final int WEST  = 4;

    private String name;
    private int positionX;
    private int positionY;
    private int facing;

    // Constructor: name, start at (0,0), facing NORTH
    public Robot(String name) {
        this.name = name;
        this.positionX = 0;
        this.positionY = 0;
        this.facing = NORTH;
    }

    // Constructor: name + position + facing, with validation
    public Robot(String name, int positionX, int positionY, int facing) {
        this.name = name;

        // validate coordinates (must be non-negative)
        if (positionX >= 0) {
            this.positionX = positionX;
        } else {
            this.positionX = 0;
        }

        if (positionY >= 0) {
            this.positionY = positionY;
        } else {
            this.positionY = 0;
        }

        // validate facing (must be NORTH/EAST/SOUTH/WEST)
        if (isValidDirection(facing)) {
            this.facing = facing;
        } else {
            this.facing = NORTH;
        }
    }

    private boolean isValidDirection(int dir) {
        return dir == NORTH || dir == EAST || dir == SOUTH || dir == WEST;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public int getFacing() {
        return facing;
    }

    // Turn 90 degrees left (counter-clockwise)
    public void turnLeft() {
        switch (facing) {
            case NORTH:
                facing = WEST;
                break;
            case WEST:
                facing = SOUTH;
                break;
            case SOUTH:
                facing = EAST;
                break;
            case EAST:
                facing = NORTH;
                break;
            default:
                facing = NORTH;
        }
    }

    // Move one step in the facing direction, staying in non-negative coordinates
    public void move() {
        int newX = positionX;
        int newY = positionY;

        switch (facing) {
            case NORTH:
                newY = positionY + 1;
                break;
            case SOUTH:
                newY = positionY - 1;
                break;
            case EAST:
                newX = positionX + 1;
                break;
            case WEST:
                newX = positionX - 1;
                break;
        }

        // Only update if coordinates stay non-negative
        if (newX >= 0 && newY >= 0) {
            positionX = newX;
            positionY = newY;
        }
    }

    private String directionToString() {
        switch (facing) {
            case NORTH:
                return "NORTH";
            case EAST:
                return "EAST";
            case SOUTH:
                return "SOUTH";
            case WEST:
                return "WEST";
            default:
                return "UNKNOWN";
        }
    }

    @Override
    public String toString() {
        // Example: "Optimus, (5,0), EAST"
        return name + ", (" + positionX + "," + positionY + "), " + directionToString();
    }
}
