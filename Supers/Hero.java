public class Hero extends Soop {
    private String catchPhrase;

    // Constructor (no no-arg)
    public Hero(String name, String job, String superPower, boolean cape, int hitPoint, int maxDamage, String catchPhrase) {
        super(name, job, superPower, cape, hitPoint, maxDamage);
        this.catchPhrase = catchPhrase;
    }

    // Accessor method
    public String getCatchPhrase() {
        return catchPhrase;
    }
}

