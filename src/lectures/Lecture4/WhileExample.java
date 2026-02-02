package lectures.Lecture4;

public class WhileExample {

    public static void main(String[] args) {
        int passwordAttempts = 0;

        while (passwordAttempts < 3) {
            System.out.println("Attempting login...");
            passwordAttempts++;
        }

        System.out.println("Account locked");
    }
}
