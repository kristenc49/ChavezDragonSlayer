public class Dragon {
    private int healthLVL;
    private int dragonLVL;

    public Dragon() {
        healthLVL = 100;
        dragonLVL = (int)(Math.random() * 3) + 1;
    }

    public void attack() {
        int attack = dragonLVL * (int)(Math.random() * 10) + 1;
        Player.setHealth(-attack);
    }

    public void hit() {

    }

    public void dead() {

    }
}
