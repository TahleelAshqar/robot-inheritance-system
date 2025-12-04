public class Main {
    public static void main(String[] args) {
        MoreSpecialRobot r = new MoreSpecialRobot("Optimus", 0, 0, Robot.EAST);

        System.out.println(r); // Optimus, (0,0), EAST, Battery: 100%

        r.move();
        r.move();
        r.turnLeft();
        r.move();

        System.out.println(r); // position changed, battery decreased

        // Drain battery demo
        for (int i = 0; i < 105; i++) {
            r.move();
        }

        System.out.println(r); // battery should be 0, position stopped changing
    }
}
