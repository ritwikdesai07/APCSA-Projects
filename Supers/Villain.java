public class Villain extends Soop{
    private String evilLaugh;

    public Villain(String n, String j, String sp, boolean c, int hp, int md, String laugh){
        super(n, j, sp, c, hp, md);
        evilLaugh = laugh;
    }

    public String getEvilLaugh(){
        return evilLaugh;
    }
}
