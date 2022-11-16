package ro.mta.ip.tema_java;

public class Human implements IHuman {
    protected String firstName;
    protected String lastName;
    protected Integer age;


    public Integer getAge() {
        return age;
    }

    public void greeting() {
        System.out.println("Hello, my name is " + firstName + " " + lastName + "!");
    }

    public void doWork() {
        System.out.println("Go to work...");
    }

}
