package lectures.Lecture7.examples.BasicInheritance;

public class Main {
    public static void main(String[] args) {
        Student s = new Student();
        s.name = "Alex";
        s.age = 20;

        s.introduce(); // inherited method
        s.study(); // subclass method
    }
}
