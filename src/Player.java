public class Player {
    // instance variables
    private String name;
    private static int health;
    private int gold;
    private static boolean healthPotStatus; // whether the player has one (true) or not (false)

    public static void setHealthPotStatus (boolean newStatus) {
        healthPotStatus = newStatus;
    }

    public static boolean getHealthPotStatus () {
        return healthPotStatus;
    }

    public static void setHealth(int newHealth) {
        health += newHealth;
    }
    public Player() {
        name = ""; // change later
        health = 100;
        gold = 0;
        healthPotStatus = false;
    }

    public void attack() { // handle atk

    }

    public void useHealthPot() {
        health += 50;
        healthPotStatus = false;
    }

}
