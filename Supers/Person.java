public class Person {
    private String name;
    private String job;

    // Constructor (no no-arg)
    public Person(String name, String job) {
        this.name = name;
        this.job = job;
    }

    // Accessor methods
    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public String toString() {
        return "(" + name + ", " + job + ")";
    }
}
