package lectures.Lecture4;

public class MenuSelector {

    public static void main(String[] args) {
        int choice = 2;

        switch (choice) {
            case 1:
                System.out.println("Create new file");
                break;
            case 2:
                System.out.println("Open existing file");
                break;
            case 3:
                System.out.println("Exit program");
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
}
