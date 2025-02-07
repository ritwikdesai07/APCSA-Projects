public class Soop extends Person {
    private String superPower;
    private boolean cape;
    private int hitPoint;
    private int maxDamage;

    // Constructor (no no-arg)
    public Soop(String name, String job, String superPower, boolean cape, int hitPoint, int maxDamage) {
        super(name, job);
        this.superPower = superPower;
        this.cape = cape;
        this.hitPoint = hitPoint;
        this.maxDamage = maxDamage;
    }

    // Accessor methods
    public String getSuperPower() {
        return superPower;
    }

    public boolean hasCape() {
        return cape;
    }

    public int getHitPoint() {
        return hitPoint;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    // Mutator method
    public void hpReduction(int damage) {
        hitPoint -= damage;
        if (hitPoint < 0) {
            hitPoint = 0;
        }
    }
}
