import com.sun.security.jgss.GSSUtil;

public class Dragon {
    private int healthLVL;
    private int dragonLVL;

    public Dragon() {
        healthLVL = 100;
        dragonLVL = (int)(Math.random() * 3) + 1;
    }
    public int getHealth() {
        return healthLVL;
    }
    public void setHealth(int newHealth) {
        healthLVL += newHealth;
    }
    public int getDragonLVL() {
        return dragonLVL;
    }
    public void dragonAttack(Player player) {
        int attack = dragonLVL * (int)(Math.random() * 10) + 1;
        player.setHealth(-attack);
    }

    public void hit() {

    }

    public void dead(Player player) { // returns what outcome will happen when the dragon dies
    int outcome = (int)(Math.random() * 4) + 1;
    if (outcome == 1) {
        int goldAmount = (int)(Math.random() * 50) + 1;
        player.increaseGold(goldAmount);
        System.out.println("The dragon dropped " + goldAmount + " gold!");
    } else if (outcome == 2) {
        int attackPowerIncrease = (int)(Math.random() * 5) + 1;
        int dodgeRatingIncrease = (int)(Math.random() * 10) + 1;
        player.getSword().upgrade(attackPowerIncrease, dodgeRatingIncrease);
        System.out.println("The dragon dropped a sword upgrade!\nNew Attack Power: " + player.getSword().getAttackPower() + "\nNew Dodge Rating: " + player.getSword().getDodgeRating());
    } else if (outcome == 3) {
        double healthFraction = (Math.random() * 0.5);
        int healthIncrease = (int)(100 * healthFraction);
        player.addHealth(healthIncrease);
        if (player.getHealth() > 100) {
            player.setHealth(100);
        }
    } else {
        System.out.println("The dragon drops nothing.");
    }
    }
}
