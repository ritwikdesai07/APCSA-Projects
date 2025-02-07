import java.util.ArrayList;
import java.util.Scanner;

public class SoopRunner {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String[] firstNames = {"Curious", "Zafir", "Tom", "Arjun", "Hari", "Bunty", "Sai", "Man in the Yellow Hat", "Bunty", "Dylan" };
        String[] lastNames = {"Shamshi", "Tyagi", "Smith", "James", "Karthik", "Desai", "Brown", "Geroge", "Lopez", "Garcia" };
        String[] jobs = {"Teacher", "Engineer", "Pharamist", "Janitor", "the IT Guy", "Athlete", "Chef", "Scientist", "Pilot", "Garderner"};

        ArrayList<Person> person = new ArrayList<>();

        for (int i = 0; i < 48; i++) {
            String firstName = firstNames[(int) (Math.random() * firstNames.length)];
            String lastName = lastNames[(int) (Math.random() * lastNames.length)];
            String job = jobs[(int) (Math.random() * jobs.length)];
            person.add(new Person(firstName + " " + lastName, job));
        }

        System.out.println(person);

        Hero hero = new Hero("Hero", "Protector", "Invisablity", true, 100, 20, "heHe Justice Wins");
        Villain villain = new Villain("Villain", "Bad Guy", "Flight", true, 100, 20, "Mwahaha!");

        person.add((int) (Math.random() * person.size()), hero);
        person.add((int) (Math.random() * person.size()), villain);

        ArrayList<Person> safePeople = new ArrayList<>();
        ArrayList<Person> unsafePeople = new ArrayList<>();
        System.out.println("People remaining: " + person.size());
            System.out.println("Safe people: " + safePeople.size());
            System.out.println("Unsafe people: " + unsafePeople.size());
            System.out.println("Total People: " + (safePeople.size() + person.size()+ unsafePeople.size()));
            System.out.println("Press Enter to continue...");
            reader.nextLine();

        while (person.size() > 2) {
            
            int villainIndex = person.indexOf(villain);
            int heroIndex = person.indexOf(hero);

            if (villainIndex != -1) {
                /*if (!(person.get(villainIndex) instanceof Villain)) {
                }*/

                if (villainIndex > 0 && villainIndex < person.size() - 1) {
                    if (villainIndex - 1 == heroIndex || villainIndex + 1 == heroIndex) {

                        if (villainIndex - 1 == heroIndex && !(person.get(villainIndex - 1) instanceof Hero)) {
                            unsafePeople.add(person.remove(villainIndex + 1)); 
                        } else if (villainIndex + 1 == heroIndex && !(person.get(villainIndex + 1) instanceof Hero)) {
                            unsafePeople.add(person.remove(villainIndex - 1));
                        }
                    }
                    if ((int) (Math.random() * 2) < 1) {
                        if (!(person.get(villainIndex - 1) instanceof Hero)) {
                            unsafePeople.add(person.remove(villainIndex - 1)); 
                        }
                    } else {
                        if (!(person.get(villainIndex + 1) instanceof Hero)) {
                            unsafePeople.add(person.remove(villainIndex + 1)); 
                        }
                    }
                } else if (villainIndex > 0 && !(person.get(villainIndex - 1) instanceof Hero)) {
                    unsafePeople.add(person.remove(villainIndex - 1));
                } else if (villainIndex < person.size() - 1 && !(person.get(villainIndex + 1) instanceof Hero)) {
                    unsafePeople.add(person.remove(villainIndex + 1));
                }
            }


            if (!person.isEmpty()) {
                int randomPersonIndex = (int) (Math.random() * person.size());
                
                while (randomPersonIndex == villainIndex || randomPersonIndex == heroIndex || 
                       person.get(randomPersonIndex) instanceof Hero || person.get(randomPersonIndex) instanceof Villain) {
                    randomPersonIndex = (int) (Math.random() * person.size());
                }
            
                safePeople.add(person.remove(randomPersonIndex));
            }
            System.out.println("People remaining: " + person.size());
            System.out.println("Safe people: " + safePeople.size());
            System.out.println("Unsafe people: " + unsafePeople.size());
            System.out.println("Total People: " + (safePeople.size() + person.size()+ unsafePeople.size()));
            System.out.println("Press Enter to continue...");
            
            if (person.contains(hero)) {
                person.remove(hero);
                person.add((int) (Math.random() * person.size()), hero);
            }

            reader.nextLine();
        }
        //System.out.println(person);
        System.out.println("\n3.2.1 fight");
        
        while (hero.getHitPoint() > 0 && villain.getHitPoint() > 0) {
            boolean heroAttacksFirst = Math.random() < 0.5;
            int heroAttack = (int) (Math.random() * hero.getMaxDamage()) + 1;
            int villainAttack = (int) (Math.random() * villain.getMaxDamage()) + 1;

            if (heroAttacksFirst) {
                villain.hpReduction(heroAttack);
                System.out.println("Hero attacks Villain for " + heroAttack + " damage.");
                if (villain.getHitPoint() > 0) {
                    hero.hpReduction(villainAttack);
                    System.out.println("Villain attacks Hero for " + villainAttack + " damage.");
                }
            } else {
                hero.hpReduction(villainAttack);
                System.out.println("Villain attacks Hero for " + villainAttack + " damage.");
                if (hero.getHitPoint() > 0) {
                    villain.hpReduction(heroAttack);

                    System.out.println("Hero attacks Villain for " + heroAttack + " damage.");
                }
            }

            System.out.println("Hero HP: " + hero.getHitPoint());
            System.out.println("Villain HP: " + villain.getHitPoint());

            if (heroAttack > villainAttack && hero.getHitPoint() > 0) {
                System.out.println(hero.getCatchPhrase());
            } else if (villainAttack > heroAttack && villain.getHitPoint() > 0) {
                System.out.println(villain.getEvilLaugh());
            }

            reader.nextLine();
        }

        if (hero.getHitPoint() > 0) {
            System.out.println("Hero wins!");
        } else {
            System.out.println("Villain wins!");
        }
        //System.out.println(person);
        reader.close();
    }
}
