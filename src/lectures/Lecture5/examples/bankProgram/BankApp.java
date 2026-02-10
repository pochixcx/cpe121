package lectures.Lecture5.examples.bankProgram;

public class BankApp {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("Mark", 5000);

        account.withdraw(2000);
        account.deposit(1500);
        account.printStatus();
    }
}
