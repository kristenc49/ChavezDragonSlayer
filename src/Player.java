public class Player {
    // instance variables
    private String name;
    private int health;
    private int gold;
    private Sword sword;
    private boolean healthPotStatus; // whether the player has one (true) or not (false)

    public Player(String name) {
        this.name = name; // change later
        health = 100;
        gold = 0;
        healthPotStatus = false;
        this.sword = new Sword(10, 20);
    }
    public void setHealthPotStatus(boolean newStatus) {
        healthPotStatus = newStatus;
    }

    public boolean getHealthPotStatus() {
        return healthPotStatus;
    }

    public Sword getSword() {
        return sword;
    }

    public void increaseGold(int addGold) {
        gold += addGold;
    }
    public int getGold() {
        return gold;
    }
    public int getHealth() {
        return health;
    }
    public void setHealth(int newHealth) {
        health = newHealth;
    }
    public void addHealth(int newHealth) {
        health += newHealth;
    }

    public void attack(Dragon dragon) { // handle atk
        int attack = sword.getAttackPower() * (int)(Math.random() * 10) + 1;
        dragon.setHealth(-attack);
        System.out.println("You attacked the dragon and dealt " + attack + " damage.");
        if (health <= 0) {
            System.out.println();
        }
    }
public void dragonDefeated(Dragon dragon) {

}
    public void useHealthPot() {
        health += 50;
        healthPotStatus = false;
    }

}
