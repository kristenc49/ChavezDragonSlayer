public class Sword {
    private int attackPower;
    private int dodgeRating;

    public Sword(int attackPower, int dodgeRating) {
        this.attackPower = attackPower; // starts at 10
        this.dodgeRating = dodgeRating; // starts at 20: likelihood that the dragon will miss; 20%
    }

    public void setAttackPower(int newAttackPower) {
        attackPower = newAttackPower;
    }
    public int getAttackPower() {
        return attackPower;
    }
    public void setDodgeRating(int newDodgeRating) {
        dodgeRating = newDodgeRating;
    }
    public int getDodgeRating() {
        return dodgeRating;
    }
    public void upgrade(int attackPowerUpgrade, int dodgeRatingUpgrade) {
    attackPower += attackPowerUpgrade;
    dodgeRating += dodgeRatingUpgrade;
    }
}
