package lectures.Lecture7.examples.Overriding;

public class Student extends Person {
    @Override
    public void introduce() {
        System.out.println("I am a student.");
    }
}
